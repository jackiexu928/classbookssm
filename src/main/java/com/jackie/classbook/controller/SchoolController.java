package com.jackie.classbook.controller;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.dto.request.SchoolAddReqDTO;
import com.jackie.classbook.service.write.SchoolWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/21
 */
@RestController
@RequestMapping("school")
public class SchoolController extends BaseController {

    @Autowired
    private SchoolWriteService schoolWriteService;

    /**
     * 添加学校
     * @return
     */
    @RequestMapping(value = "/insert",
                    method = RequestMethod.POST,
                    produces = {"application/json;charset=UTF-8"})
    public String addSchool(SchoolAddReqDTO reqDTO){
        return toJSON(schoolWriteService.addSchool(reqDTO));
    }
}
