package com.jackie.classbook.process;


import java.io.Serializable;

/**
 * Created by Administrator on 2018/3/12 0012.
 */
public class Context<P,M> implements Serializable {
    //入参
    private P param;
    //出参
    private M result;
    //类名
    private String className;
    //方法名
    private String methodName;

    //是否成功
    private boolean success;

    //错误码
    private String errorCode;
    //错误信息
    private String errorMsg;

    public Context(){

    }

    public Context(P param, M result, String className, String methodName){
        this.param=param;
        this.result=result;
        this.className=className;
        this.methodName=methodName;
    }

    public P getParam() {
        return param;
    }

    public void setParam(P param) {
        this.param = param;
    }

    public M getResult() {
        return result;
    }

    public void setResult(M result) {
        this.result = result;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
