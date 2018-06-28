package com.jackie.classbook.controller;

import com.jackie.classbook.dto.request.TeacherAddReqDTO;
import com.jackie.classbook.service.write.TeacherWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/28
 */
@RestController
@RequestMapping("teacher")
public class TeacherController extends BaseController {
    @Autowired
    private TeacherWriteService teacherWriteService;

    /**
     * 添加教师
     * @param reqDTO
     * @return
     */
    @RequestMapping(value = "/insert",
                    method = RequestMethod.POST,
                    produces = {"application/json;charset=UTF-8"})
    public String insert(TeacherAddReqDTO reqDTO){
        return toJSON(teacherWriteService.addTeacher(reqDTO));
    }
}
