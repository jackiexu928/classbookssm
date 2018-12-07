package com.jackie.classbook.common;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/5/31
 */
public enum ClassbookCodeEnum {
    NO_PRIVILEGE("NO_PRIVILEGE","无权限操作"),

    ILLGAL_ARGUMENT("ILLGAL_ARGUMENT","非法参数"),

    REPEAT_SUBMIT("REPEAT_SUBMIT","重复提交"),

    IDEMPOTENT_INVOKE("IDEMPOTENT_INVOKE","幂等调用"),

    PARAM_ISNULL("PARAM_ISNULL","参数为空"),

    CALL_DAO_ERROR("CALL_DAO_ERROR","网络异常"),

    SYSTEM_ERROR("SYSTEM_ERROR","系统异常"),

    NOT_EXTENDS_COMMON_SERVICE("NOT_EXTENDS_COMMON_SERVICE","接口未继承抽象类"),

    TYPE_NOT_NULL("TYPE_NOT_NULL","类型不能为空"),

    CREATE_BY_NOT_NULL("CREATE_BY_NOT_NULL","创建人不能为空"),

    PAGE_PARAM_ILLEGAL("PAGE_PARAM_NOT_NULL","分页参数非法"),

    NO_RECORD("NO_RECORD","无此记录"),

    USER_NOT_LOGIN("USER_NOT_LOGIN","用户未登录"),

    FORMAT_NOT_RIGHT("FORMAT_NOT_RIGHT","格式不正确"),

    DOWNLOAD_URL_IS_EMPTY("DOWNLOAD_URL_IS_EMPTY","下载链接不存在，请稍后重试"),

    CHECK_PASSWORD_IS_WRONG("CHECK_PASSWORD_IS_WRONG","两次输入密码不一致"),

    OPERATION_TOO_MANY("OPERATION_TOO_MANY","操作过于频繁，请稍后尝试"),

    VERIFY_CODE_EXPIRE("VERIFY_CODE_EXPIRE","验证码已过期，请重新获取"),

    VERIFY_CODE_NOT_RIGHT("VERIFY_CODE_NOT_RIGHT","验证码不正确"),

    RESET_PASSWORD_FAIL("RESET_PASSWORD_FAIL","重置密码失败"),

    ACCOUNT_NOT_EXIST("ACCOUNT_NOT_EXIST","用户不存在"),

    MOBILE_EXIST("MOBILE_EXIST","手机号已被使用"),

    EMAIL_EXIST("EMAIL_EXIST","邮箱已被使用"),

    QQ_EXIST("QQ_EXIST","QQ已被使用"),

    ACCOUNT_OR_PASSWORD("ACCOUNT_OR_PASSWORD","账户或密码错误"),

    ILLGAL_MOBILE("ILLGAL_MOBILE","手机号错误"),

    ILLGAL_EMAIL("ILLGAL_EMAIL","邮箱格式错误"),

    SCHOOL_NOT_EXIST("SCHOOL_NOT_EXIST","学校不存在")

    ;

    private String errMsg;

    private String errCode;

    private ClassbookCodeEnum(String errCode, String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private ClassbookCodeEnum(String errCode){
        this.errCode = errCode;
    }

    public static ClassbookCodeEnum getTbcpErrorCodeEnum(String code) {
        for(ClassbookCodeEnum x: ClassbookCodeEnum.values()) {
            if(x.getErrCode().equals(code)) {
                return x;
            }
        }
        return null;
    }

    public String getErrCode(){
        return this.errCode;
    }

    public String getErrMsg(){
        return this.errMsg;
    }
}
