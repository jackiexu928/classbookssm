package com.jackie.classbook.dto.request;

import com.jackie.classbook.common.ClassbookCodeEnum;
import com.jackie.classbook.common.ClassbookException;
import com.jackie.classbook.dto.BaseReqDTO;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/19
 */
public class LoginReqDTO extends BaseReqDTO {

    private String account;     //邮箱或者手机号
    private String password;    //密码

    @Override
    public void validation() {
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(password)){
            throw new ClassbookException(ClassbookCodeEnum.ILLGAL_ARGUMENT);
        }
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
