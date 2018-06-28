package com.jackie.classbook.controller;

import com.jackie.classbook.dto.request.BaseIdReqDTO;
import com.jackie.classbook.dto.request.ClassAddReqDTO;
import com.jackie.classbook.dto.request.ClassQueryReqDTO;
import com.jackie.classbook.dto.request.ClassSetTeacherReqDTO;
import com.jackie.classbook.service.read.ClassReadService;
import com.jackie.classbook.service.write.ClassWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/25
 */
@RestController
@RequestMapping("class")
public class ClassController extends BaseController {

    @Autowired
    private ClassWriteService classWriteService;
    @Autowired
    private ClassReadService classReadService;

    /**
     * 添加班级
     * @param reqDTO
     * @return
     */
    @RequestMapping(value = "/insert",
                    method = RequestMethod.POST,
                    produces = {"application/json;charset=UTF-8"})
    public String addClass(ClassAddReqDTO reqDTO){
        return toJSON(classWriteService.insert(reqDTO));
    }

    /**
     * 根据条件查询班级列表
     * @param reqDTO    中文乱码
     * @return
     */
    @RequestMapping(value = "/list",
                    method = RequestMethod.GET,
                    produces = {"application/json;charset=UTF-8"})
    public String getClasses(ClassQueryReqDTO reqDTO){
        return toJSON(classReadService.getClasses(reqDTO));
    }

    /**
     * 添加班主任/任课老师
     * @param reqDTO
     * @return
     */
    @RequestMapping(value = "/setTeacher",
                    method = RequestMethod.POST,
                    produces = {"application/json;charset=UTF-8"})
    public String setTeacher(ClassSetTeacherReqDTO reqDTO){
        return toJSON(classWriteService.setTeacher(reqDTO));
    }

    /**
     * 查看班级详情
     * @param reqDTO
     * @return
     */
    @RequestMapping(value = "/detail",
                    method = RequestMethod.GET,
                    produces = {"application/json;charset=UTF-8"})
    public String getDetail(BaseIdReqDTO reqDTO){
        return toJSON(classReadService.getClassDetail(reqDTO));
    }
}
