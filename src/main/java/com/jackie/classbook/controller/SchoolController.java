package com.jackie.classbook.controller;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.dto.request.SchoolAddReqDTO;
import com.jackie.classbook.dto.request.SchoolQueryReqDTO;
import com.jackie.classbook.service.read.SchoolReadService;
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
    @Autowired
    private SchoolReadService schoolReadService;

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

    /**
     * 根据条件查询学校列表
     * @param reqDTO
     * @return
     */
    @RequestMapping(value = "/list",
                    method = RequestMethod.GET,
                    produces = {"application/json;charset=UTF-8"})
    public String getSchool(SchoolQueryReqDTO reqDTO){
        return toJSON(schoolReadService.getSchools(reqDTO));
    }
}
