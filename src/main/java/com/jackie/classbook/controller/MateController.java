package com.jackie.classbook.controller;

import com.jackie.classbook.dto.request.MateAddReqDTO;
import com.jackie.classbook.dto.request.MateUpdateReqDTO;
import com.jackie.classbook.service.write.MateWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/29
 */
@RestController
@RequestMapping("mate")
public class MateController extends BaseController {

    @Autowired
    private MateWriteService mateWriteService;

    /**
     * 添加同学
     * @param reqDTO
     * @return
     */
    @RequestMapping(value = "/insert",
                    method = RequestMethod.POST,
                    produces = {"application/json;charset=UTF-8"})
    public String addMate(MateAddReqDTO reqDTO){
        return toJSON(mateWriteService.addMate(reqDTO));
    }

    /**
     * 修改同学信息
     * @param reqDTO
     * @return
     */
    @RequestMapping(value = "/update",
                    method = RequestMethod.POST,
                    produces = {"application/json;charset=UTF-8"})
    public String updateMate(MateUpdateReqDTO reqDTO){
        return toJSON(mateWriteService.updateMate(reqDTO));
    }
}
