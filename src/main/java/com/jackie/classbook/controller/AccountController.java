package com.jackie.classbook.controller;

import com.jackie.classbook.dto.request.AccountRegisterReqDTO;
import com.jackie.classbook.dto.request.BaseIdReqDTO;
import com.jackie.classbook.entity.Account;
import com.jackie.classbook.service.read.AccountReadService;
import com.jackie.classbook.service.write.AccountWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/15
 */
@RestController
@RequestMapping("account")
public class AccountController extends BaseController{
    @Autowired
    private AccountReadService accountReadService;
    @Autowired
    private AccountWriteService accountWriteService;

    /**
     * 测试
     * @return
     */
    @RequestMapping("hello")
    public String index(){
        return "Hello World!!";
    }

    /**
     * 注册
     * @param reqDTO
     * @return
     */
    @RequestMapping(value = "/register",
                    method = RequestMethod.POST,
                    produces = {"application/json;charset=UTF-8"})
    public String register(AccountRegisterReqDTO reqDTO){
        return toJSON( accountWriteService.insert(reqDTO));
    }

    /**
     * 获取所有用户
     * @param reqDTO
     * @return
     */
    @RequestMapping(value = "/getAll",
                    method = RequestMethod.GET,
                    produces = {"application/json;charset=UTF-8"})
    public String getAll(BaseIdReqDTO reqDTO){
        return toJSON(accountReadService.getAll(reqDTO));
    }

}
