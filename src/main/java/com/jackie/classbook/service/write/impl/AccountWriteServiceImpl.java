package com.jackie.classbook.service.write.impl;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.dao.AccountDao;
import com.jackie.classbook.dto.request.AccountRegisterReqDTO;
import com.jackie.classbook.entity.Account;
import com.jackie.classbook.process.AbstractService;
import com.jackie.classbook.process.Context;
import com.jackie.classbook.service.write.AccountWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/19
 */
@Service
public class AccountWriteServiceImpl extends AbstractService implements AccountWriteService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Context<AccountRegisterReqDTO, Void> insert(AccountRegisterReqDTO reqDTO) {
        Context<AccountRegisterReqDTO, Void> context = new Context<>();
        Account account = JSON.parseObject(JSON.toJSONString(reqDTO), Account.class);
        Date now = new Date();
        account.setCreateTime(now);
        account.setUpdateTime(now);
        account.setValidFlag((byte)1);
        accountDao.insert(account);
        return context;
    }
}
