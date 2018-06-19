package com.jackie.classbook.service.read;

import com.jackie.classbook.dto.request.BaseIdReqDTO;
import com.jackie.classbook.entity.Account;
import com.jackie.classbook.process.Context;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/15
 */
public interface AccountReadService {

    Context<BaseIdReqDTO, Account> getAccountById(BaseIdReqDTO reqDTO);
}
