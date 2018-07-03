package com.jackie.classbook.service.write.impl;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.common.ClassbookCodeEnum;
import com.jackie.classbook.common.ClassbookException;
import com.jackie.classbook.dao.*;
import com.jackie.classbook.dto.request.*;
import com.jackie.classbook.entity.*;
import com.jackie.classbook.entity.Class;
import com.jackie.classbook.process.AbstractService;
import com.jackie.classbook.process.Context;
import com.jackie.classbook.service.write.ClassWriteService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    @Autowired
    private MateDao mateDao;
    @Autowired
    private SchoolDao schoolDao;
    @Autowired
    private MateClassMapperDao mateClassMapperDao;

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

    @Override
    public Context<ClassUpdateReqDTO, Void> updateClass(ClassUpdateReqDTO reqDTO) {
        Class clazz = JSON.parseObject(JSON.toJSONString(reqDTO), Class.class);
        classDao.update(clazz);
        Context<ClassUpdateReqDTO, Void> context = new Context<>();
        return context;
    }

    @Override
    public Context<ClassRemoveTeacherReqDTO, Void> removeTeacher(ClassRemoveTeacherReqDTO reqDTO) {
        teacherClassMapperDao.delete(reqDTO.getClassId(), reqDTO.getTeacherId());
        Context<ClassRemoveTeacherReqDTO, Void> context = new Context<>();
        return context;
    }

    @Override
    public Context<ClassAddMateReqDTO, Void> addMate(ClassAddMateReqDTO reqDTO) {
        Mate mate = mateDao.queryById(reqDTO.getMateId());
        School school = schoolDao.querySchoolById(reqDTO.getSchoolId());
        Class clazz = classDao.queryById(reqDTO.getClassId());

        MateClassMapper mateClassMapper = new MateClassMapper();
        mateClassMapper.setAccountId(mate.getAccountId());
        mateClassMapper.setSchoolId(school.getId());
        mateClassMapper.setSchoolName(school.getSchoolName());
        mateClassMapper.setClassId(clazz.getId());
        mateClassMapper.setClassName(clazz.getClassName());
        mateClassMapper.setMateId(mate.getId());
        mateClassMapper.setMateName(mate.getName());
        mateClassMapper.setMateType(reqDTO.getMateType());
        mateClassMapper.setValidFlag((byte)1);
        mateClassMapperDao.insert(mateClassMapper);
        Context<ClassAddMateReqDTO, Void> context = new Context<>();
        return context;
    }

    @Override
    public Context<ClassRemoveMateReqDTO, Void> removeMate(ClassRemoveMateReqDTO reqDTO) {
        List<String> list = Arrays.asList(reqDTO.getMateIds().split(","));
        List<Long> idList = new ArrayList<>();
        for (String string : list){
            idList.add(Long.valueOf(string));
        }
        Map filters = new HashMap();
        filters.put("classId", reqDTO.getClassId());
        filters.put("mateIdList", idList);
        mateClassMapperDao.deleteByIdList(filters);
        Context<ClassRemoveMateReqDTO, Void> context = new Context<>();
        return context;
    }
}
