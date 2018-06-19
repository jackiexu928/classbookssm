package com.jackie.classbook.process;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.dto.BaseReqDTO;
import com.jackie.classbook.util.TrackHolder;
//import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

/**
 * Created by Administrator on 2018/3/12 0012.
 * 查询类操作抽象类
 */
public abstract class AbstractQueryService<P extends BaseReqDTO, M> implements CommonInterface<P, M> {

    //protected final static Logger logger = Logger.getLogger("classbooksLog");

    @Override
    public void onStarted(Context<P, M> context) {
        //数据校验
        context.getParam().validation();
    }

    @Override
    public void onSuccess(Context<P, M> context) {
        //如果有业务错误，需要抛出异常
        context.setSuccess(true);
    }

    @Override
    public void onError(Context<P, M> context, Throwable e) {
        /*logger.error("[param]:" + context.getParam() +
                "，[class]:" + context.getClassName() +
                ",[method]:" + context.getMethodName(), e);*/
        if(StringUtils.isEmpty(context.getErrorMsg())){
            context.setErrorMsg(e.getMessage());
        }
        context.setSuccess(false);
    }

    @Override
    public void onEnd(Context<P, M> context) {
        //打印入参和出参
    //    record(context.getClassName(), context.getMethodName(), context.getResult(), context.getParam(), logger);
        TrackHolder.remove();
    }
    /*public static void record(String className, String methodName, Object result, Object param, Logger logger){
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("**********className: "+className+"**********\n");
        sb.append("**********methodName: "+methodName+"**********\n");
        sb.append("param:\n");
        sb.append("    "+ JSON.toJSONString(param)+"\n" );
        sb.append("result:\n");
        sb.append("    "+JSON.toJSONString(result)+"\n" );
        sb.append("**********");
        logger.info(sb);
    }*/
}
