package com.jackie.classbook.controller;

import com.jackie.classbook.dto.request.BaseIdReqDTO;
import com.jackie.classbook.dto.request.TeacherAddReqDTO;
import com.jackie.classbook.dto.request.TeacherQueryReqDTO;
import com.jackie.classbook.service.read.TeacherReadService;
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
    @Autowired
    private TeacherReadService teacherReadService;

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

    /**
     * 获取教师列表
     * @param reqDTO
     * @return
     */
    @RequestMapping(value = "/list",
                    method = RequestMethod.GET,
                    produces = {"application/json;charset=UTF-8"})
    public String queryTeacher(TeacherQueryReqDTO reqDTO){
        return toJSON(teacherReadService.queryTeachers(reqDTO));
    }

    @RequestMapping(value = "/detail",
                    method = RequestMethod.GET,
                    produces = {"application/json;charset=UTF-8"})
    public String getTeacherDetail(BaseIdReqDTO reqDTO){
        return toJSON(teacherReadService.getTeacherDetail(reqDTO));
    }
}
