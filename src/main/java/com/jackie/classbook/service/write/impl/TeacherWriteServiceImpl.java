package com.jackie.classbook.service.write.impl;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.dao.TeacherDao;
import com.jackie.classbook.dto.request.TeacherAddReqDTO;
import com.jackie.classbook.entity.Teacher;
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

    @Override
    public Context<TeacherAddReqDTO, Void> addTeacher(TeacherAddReqDTO reqDTO) {
        Teacher teacher = JSON.parseObject(JSON.toJSONString(reqDTO), Teacher.class);
        teacher.setValidFlag((byte)1);
        teacherDao.insert(teacher);
        Context<TeacherAddReqDTO, Void> context = new Context<>();
        return context;
    }
}
