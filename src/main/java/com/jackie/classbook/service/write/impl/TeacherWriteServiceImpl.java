package com.jackie.classbook.service.write.impl;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.common.ClassbookCodeEnum;
import com.jackie.classbook.common.ClassbookException;
import com.jackie.classbook.dao.TeacherClassMapperDao;
import com.jackie.classbook.dao.TeacherDao;
import com.jackie.classbook.dto.request.TeacherAddReqDTO;
import com.jackie.classbook.dto.request.TeacherUpdateReqDTO;
import com.jackie.classbook.entity.Teacher;
import com.jackie.classbook.entity.TeacherClassMapper;
import com.jackie.classbook.process.AbstractService;
import com.jackie.classbook.process.Context;
import com.jackie.classbook.service.write.TeacherWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/28
 */
@Service
public class TeacherWriteServiceImpl extends AbstractService implements TeacherWriteService{
    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private TeacherClassMapperDao teacherClassMapperDao;

    @Override
    public Context<TeacherAddReqDTO, Void> addTeacher(TeacherAddReqDTO reqDTO) {
        Teacher teacher = JSON.parseObject(JSON.toJSONString(reqDTO), Teacher.class);
        teacher.setValidFlag((byte)1);
        //校验手机号和邮箱，不能有重复
        if (teacher.getMobile() != null){
            Teacher teacherMobile = teacherDao.queryByMobile(teacher.getMobile());
            if (teacherMobile != null){
                throw new ClassbookException(ClassbookCodeEnum.MOBILE_EXIST);
            }
        }
        if (teacher.getEmail() != null){
            Teacher teacherEmail = teacherDao.queryByEmail(teacher.getEmail());
            if (teacherEmail != null){
                throw new ClassbookException(ClassbookCodeEnum.EMAIL_EXIST);
            }
        }
        teacherDao.insert(teacher);
        Context<TeacherAddReqDTO, Void> context = new Context<>();
        return context;
    }

    @Override
    public Context<TeacherUpdateReqDTO, Void> updateTeacher(TeacherUpdateReqDTO reqDTO) {
        Teacher teacher = JSON.parseObject(JSON.toJSONString(reqDTO), Teacher.class);
        //校验手机号和邮箱，不能有重复
        if (teacher.getMobile() != null){
            Teacher teacherMobile = teacherDao.queryByMobile(teacher.getMobile());
            if (teacherMobile != null && !teacherMobile.getId().equals(teacher.getId())){
                throw new ClassbookException(ClassbookCodeEnum.MOBILE_EXIST);
            }
        }
        if (teacher.getEmail() != null){
            Teacher teacherEmail = teacherDao.queryByEmail(teacher.getEmail());
            if (teacherEmail != null && !teacherEmail.getId().equals(teacher.getId())){
                throw new ClassbookException(ClassbookCodeEnum.EMAIL_EXIST);
            }
        }
        teacherDao.update(teacher);
        //修改教师班级映射表
        TeacherClassMapper teacherClassMapper = new TeacherClassMapper();
        teacherClassMapper.setTeacherId(teacher.getId());
        teacherClassMapper.setTeacherName(teacher.getName() == null ? null : teacher.getName());
        teacherClassMapper.setSubjects(teacher.getSubjects() == null ? null : teacher.getSubjects());
        teacherClassMapperDao.update(teacherClassMapper);

        Context<TeacherUpdateReqDTO, Void> context = new Context<>();
        return context;
    }
}
