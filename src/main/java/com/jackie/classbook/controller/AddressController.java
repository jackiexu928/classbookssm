package com.jackie.classbook.controller;

import com.jackie.classbook.dto.request.BaseIdReqDTO;
import com.jackie.classbook.service.read.AddressReadService;
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
@RequestMapping("address")
public class AddressController extends BaseController {

    @Autowired
    private AddressReadService addressReadService;

    /**
     * 根据上级地址id查询下级地址列表
     * @param reqDTO
     * @return
     */
    @RequestMapping(value = "/getAddressList",
                    method = RequestMethod.GET,
                    produces = {"application/json;charset=UTF-8"})
    public String getAddressList(BaseIdReqDTO reqDTO){
        return toJSON(addressReadService.getAddressListByParentId(reqDTO));
    }
}
