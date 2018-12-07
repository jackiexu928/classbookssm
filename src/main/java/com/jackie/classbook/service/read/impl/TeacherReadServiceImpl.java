package com.jackie.classbook.service.read.impl;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.dao.SchoolDao;
import com.jackie.classbook.dao.TeacherClassMapperDao;
import com.jackie.classbook.dao.TeacherDao;
import com.jackie.classbook.dto.request.BaseIdReqDTO;
import com.jackie.classbook.dto.request.TeacherQueryReqDTO;
import com.jackie.classbook.dto.response.TeacherClassMapperRespDTO;
import com.jackie.classbook.dto.response.TeacherDetailRespDTO;
import com.jackie.classbook.dto.response.TeacherRespDTO;
import com.jackie.classbook.entity.Teacher;
import com.jackie.classbook.entity.TeacherClassMapper;
import com.jackie.classbook.entity.module.TeacherClassMapperFactory;
import com.jackie.classbook.entity.module.TeacherFactory;
import com.jackie.classbook.process.AbstractQueryService;
import com.jackie.classbook.process.Context;
import com.jackie.classbook.service.read.TeacherReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/28
 */
@Service
public class TeacherReadServiceImpl extends AbstractQueryService implements TeacherReadService{

    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private TeacherClassMapperDao teacherClassMapperDao;

    @Override
    public Context<TeacherQueryReqDTO, List<TeacherRespDTO>> queryTeachers(TeacherQueryReqDTO reqDTO) {
        Teacher teacher = JSON.parseObject(JSON.toJSONString(reqDTO), Teacher.class);
        List<Teacher> list = teacherDao.queryTeachers(teacher);
        List<TeacherRespDTO> resultList = TeacherFactory.convertToDTO(list);
        Context<TeacherQueryReqDTO, List<TeacherRespDTO>> context = new Context<>();
        context.setResult(resultList);
        return context;
    }

    @Override
    public Context<BaseIdReqDTO, TeacherDetailRespDTO> getTeacherDetail(BaseIdReqDTO reqDTO) {
        Teacher teacher = teacherDao.queryById(reqDTO.getId());
        TeacherClassMapper teacherClassMapper = new TeacherClassMapper();
        teacherClassMapper.setTeacherId(reqDTO.getId());
        List<TeacherClassMapper> list = teacherClassMapperDao.queryList(teacherClassMapper);
        List<TeacherClassMapperRespDTO> resultList = TeacherClassMapperFactory.getClasses(list);
        TeacherDetailRespDTO teacherDetailRespDTO = new TeacherDetailRespDTO();
        teacherDetailRespDTO.setTeacherId(teacher.getId());
        teacherDetailRespDTO.setSchoolId(teacher.getSchoolId());
        teacherDetailRespDTO.setSchoolName(teacher.getSchoolName());
        teacherDetailRespDTO.setName(teacher.getName());
        teacherDetailRespDTO.setSex(teacher.getSex());
        teacherDetailRespDTO.setMobile(teacher.getMobile());
        teacherDetailRespDTO.setEmail(teacher.getEmail());
        teacherDetailRespDTO.setSubjects(teacher.getSubjects());
        teacherDetailRespDTO.setClassList(resultList);
        Context<BaseIdReqDTO, TeacherDetailRespDTO> context = new Context<>();
        context.setResult(teacherDetailRespDTO);
        return context;
    }
}
