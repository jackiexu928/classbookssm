package com.jackie.classbook.service.write.impl;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.common.ClassbookCodeEnum;
import com.jackie.classbook.common.ClassbookException;
import com.jackie.classbook.dao.ClassDao;
import com.jackie.classbook.dao.TeacherClassMapperDao;
import com.jackie.classbook.dao.TeacherDao;
import com.jackie.classbook.dto.request.ClassAddReqDTO;
import com.jackie.classbook.dto.request.ClassSetTeacherReqDTO;
import com.jackie.classbook.entity.Class;
import com.jackie.classbook.entity.Teacher;
import com.jackie.classbook.entity.TeacherClassMapper;
import com.jackie.classbook.process.AbstractService;
import com.jackie.classbook.process.Context;
import com.jackie.classbook.service.write.ClassWriteService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/25
 */
@Service
public class ClassWriteServiceImpl extends AbstractService implements ClassWriteService{

    @Autowired
    private ClassDao classDao;
    @Autowired
    private TeacherClassMapperDao teacherClassMapperDao;
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public Context<ClassAddReqDTO, Void> insert(ClassAddReqDTO reqDTO) {
        Context<ClassAddReqDTO, Void> context = new Context<>();
        Class clazz = JSON.parseObject(JSON.toJSONString(reqDTO), Class.class);
        clazz.setValidFlag((byte)1);
        classDao.insert(clazz);
        return context;
    }

    @Override
    public Context<ClassSetTeacherReqDTO, Void> setTeacher(ClassSetTeacherReqDTO reqDTO) {
        TeacherClassMapper teacherClassMapper = JSON.parseObject(JSON.toJSONString(reqDTO), TeacherClassMapper.class);
        teacherClassMapper.setValidFlag((byte)1);
        Class clazz = classDao.queryById(reqDTO.getClassId());
        Teacher teacher = teacherDao.queryById(reqDTO.getTeacherId());
        if (clazz == null || teacher == null){
            throw new ClassbookException(ClassbookCodeEnum.NO_RECORD);
        }
        teacherClassMapper.setYear(clazz.getYear());
        teacherClassMapper.setClassName(clazz.getClassName());
        teacherClassMapper.setTeacherName(teacher.getName());
        teacherClassMapper.setSubjects(teacher.getSubjects());
        teacherClassMapperDao.insert(teacherClassMapper);
        Context<ClassSetTeacherReqDTO, Void> context = new Context<>();
        return context;
    }
}
