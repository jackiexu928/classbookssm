package com.jackie.classbook.service.write;

import com.jackie.classbook.dto.request.AccountRegisterReqDTO;
import com.jackie.classbook.dto.request.LoginReqDTO;
import com.jackie.classbook.dto.response.AccountLoginRespDTO;
import com.jackie.classbook.entity.Account;
import com.jackie.classbook.process.Context;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/19
 */
public interface AccountWriteService {
    Context<LoginReqDTO, AccountLoginRespDTO> login(LoginReqDTO reqDTO);

    Context<AccountRegisterReqDTO, Void> insert(AccountRegisterReqDTO reqDTO);
}
