package com.jackie.classbook.dto.response;

import com.jackie.classbook.dto.BaseRespDTO;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/5/30
 */
public class AccountLoginRespDTO extends BaseRespDTO {
    private AccountRespDTO accountRespDTO;

    public AccountRespDTO getAccountRespDTO() {
        return accountRespDTO;
    }

    public void setAccountRespDTO(AccountRespDTO accountRespDTO) {
        this.accountRespDTO = accountRespDTO;
    }
}
