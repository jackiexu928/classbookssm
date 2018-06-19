package com.jackie.classbook.service.read.impl;

import com.jackie.classbook.dao.AccountDao;
import com.jackie.classbook.dto.request.BaseIdReqDTO;
import com.jackie.classbook.entity.Account;
import com.jackie.classbook.process.AbstractQueryService;
import com.jackie.classbook.process.Context;
import com.jackie.classbook.service.read.AccountReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/15
 */
@Service
public class AccountReadServiceImpl extends AbstractQueryService implements AccountReadService {
    @Autowired
    AccountDao accountDao;

   /* @Override
    public int insert(Account account) {
        return accountDao.insert(account);
    }*/

    @Override
    public Context<BaseIdReqDTO, Account> getAll(BaseIdReqDTO reqDTO) {
        Context<BaseIdReqDTO, Account> context = new Context<>();
        Account account = accountDao.getAll(reqDTO.getId());
        context.setResult(account);
        return context;
    }
}
