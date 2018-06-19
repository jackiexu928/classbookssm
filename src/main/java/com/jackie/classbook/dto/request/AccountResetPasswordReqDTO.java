package com.jackie.classbook.dto.request;

import com.jackie.classbook.dto.BaseReqDTO;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/19
 */
public class AccountResetPasswordReqDTO extends BaseReqDTO {
    private String Account;     //手机号或邮箱

    @Override
    public void validation() {

    }
}
