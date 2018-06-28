package com.jackie.classbook.service.read.impl;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.dao.ClassDao;
import com.jackie.classbook.dao.SchoolDao;
import com.jackie.classbook.dao.TeacherClassMapperDao;
import com.jackie.classbook.dto.request.BaseIdReqDTO;
import com.jackie.classbook.dto.request.ClassQueryReqDTO;
import com.jackie.classbook.dto.response.ClassDetailRespDTO;
import com.jackie.classbook.dto.response.ClassRespDTO;
import com.jackie.classbook.dto.response.TeacherClassMapperRespDTO;
import com.jackie.classbook.entity.Class;
import com.jackie.classbook.entity.TeacherClassMapper;
import com.jackie.classbook.entity.module.ClassFactory;
import com.jackie.classbook.entity.module.TeacherClassMapperFactory;
import com.jackie.classbook.process.AbstractQueryService;
import com.jackie.classbook.process.Context;
import com.jackie.classbook.service.read.ClassReadService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/25
 */
@Service
public class ClassReadServiceImpl extends AbstractQueryService implements ClassReadService{

    @Autowired
    private ClassDao classDao;
    @Autowired
    private SchoolDao schoolDao;
    @Autowired
    private TeacherClassMapperDao teacherClassMapperDao;

    @Override
    public Context<ClassQueryReqDTO, List<ClassRespDTO>> getClasses(ClassQueryReqDTO reqDTO) {
        Class clazz = JSON.parseObject(JSON.toJSONString(reqDTO), Class.class);
        List<Class> list = classDao.getClasses(clazz);
        List<ClassRespDTO> resultList = ClassFactory.convertToDTO(list);
        Context<ClassQueryReqDTO, List<ClassRespDTO>> context = new Context<>();
        context.setResult(resultList);
        return context;
    }

    @Override
    public Context<BaseIdReqDTO, ClassDetailRespDTO> getClassDetail(BaseIdReqDTO reqDTO) {
        Class clazz = classDao.queryById(reqDTO.getId());
        TeacherClassMapper teacherClassMapper = new TeacherClassMapper();
        teacherClassMapper.setClassId(reqDTO.getId());
        List<TeacherClassMapper> list = teacherClassMapperDao.queryList(teacherClassMapper);
        List<TeacherClassMapperRespDTO> resultList = TeacherClassMapperFactory.getTeachers(list);
        ClassDetailRespDTO classDetailRespDTO = new ClassDetailRespDTO();
        classDetailRespDTO.setClassId(clazz.getId());
        classDetailRespDTO.setClassName(clazz.getClassName());
        classDetailRespDTO.setSchoolId(clazz.getSchoolId());
        classDetailRespDTO.setSchoolName(getSchool(clazz.getSchoolId()));
        classDetailRespDTO.setTeachersList(resultList);
        Context<BaseIdReqDTO, ClassDetailRespDTO> context = new Context<>();
        context.setResult(classDetailRespDTO);
        return context;
    }

    public String getSchool(Long schoolId){
        return schoolDao.querySchoolById(schoolId).getSchoolName();
    }
}
