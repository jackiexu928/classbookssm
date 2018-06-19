package com.jackie.classbook.common;

import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/19
 */
public class ClassbookException extends RuntimeException {
    private long serialVersionUID = 3L;
    private String errorCode;

    private String errorMessage;

    private String detailErrorMessage;

    //这个是父类的错误信息
    private String detailMessage;


    public ClassbookException(Throwable e) {
        super(e);
        this.errorCode = e.getMessage();
        this.errorMessage=e.getMessage();
        this.detailErrorMessage=e.getMessage();
    }


    public ClassbookException(ClassbookCodeEnum errorCodeEnum){
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailMessage=errorCodeEnum.getErrMsg();
    }

    public ClassbookException(ClassbookCodeEnum errorCodeEnum, String detailErrorMessage){
        this.errorCode = errorCodeEnum.getErrCode();
        this.errorMessage = errorCodeEnum.getErrMsg();
        this.detailMessage = detailErrorMessage;
    }

    public ClassbookException(String errorCode, String errorMessage, String detailErrorMessage, Throwable e) {
        super(errorCode,e);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.detailMessage =detailErrorMessage;
    }

    public ClassbookException(String errorCode, String errorMessage, String detailErrorMessage) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.detailMessage =detailErrorMessage;
    }

    public ClassbookException(String errorCode, String errorMessage, Throwable e) {
        super(errorCode,e);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.detailMessage=errorMessage;
    }

    public ClassbookException(String errorCode, String errorMessage) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.detailMessage=errorMessage;
    }

    public ClassbookException(String errorCode, Throwable e) {
        super(errorCode,e);
        this.errorCode = errorCode;
    }

    public ClassbookException(String errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getDetailErrorMessage() {
        return detailErrorMessage;
    }

    public String getMessage() {
        if(!StringUtils.isEmpty(errorMessage)){
            return errorMessage;
        }else if(!StringUtils.isEmpty(detailErrorMessage)){
            return detailErrorMessage;
        }else{
            return detailMessage;
        }
    }
}
