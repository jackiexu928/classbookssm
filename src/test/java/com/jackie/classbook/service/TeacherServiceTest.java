package com.jackie.classbook.service;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.BaseTest;
import com.jackie.classbook.dto.request.TeacherAddReqDTO;
import com.jackie.classbook.process.Context;
import com.jackie.classbook.service.write.TeacherWriteService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/28
 */
public class TeacherServiceTest extends BaseTest {
    @Autowired
    private TeacherWriteService teacherWriteService;

    @Test
    public void addTeacherTest(){
        TeacherAddReqDTO reqDTO = new TeacherAddReqDTO();
        reqDTO.setSchoolId(1L);
        reqDTO.setName("许基法");
        reqDTO.setSex((byte)1);
        reqDTO.setSubjects("语文");
        Context<TeacherAddReqDTO, Void> context = teacherWriteService.addTeacher(reqDTO);
        System.out.println(JSON.toJSONString(context));
    }
}
