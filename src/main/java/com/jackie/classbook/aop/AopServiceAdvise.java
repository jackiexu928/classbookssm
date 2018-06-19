package com.jackie.classbook.aop;

import com.jackie.classbook.process.CommonInterface;
import com.jackie.classbook.process.Context;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by Administrator on 2018/3/9 0009.
 * 增强类
 */
public class AopServiceAdvise implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object targetObject=invocation.getThis();
        String className=targetObject.getClass().getName();
        String methodName=invocation.getMethod().getName();
        Object[] params=invocation.getArguments();

        //记录单个接口耗时
        long startTime= System.currentTimeMillis();
        long endTime=0L;

        //如果接口不属于公共接口，报错
        Context context=new Context();
        if(targetObject instanceof CommonInterface){
            CommonInterface commonInterface= (CommonInterface) targetObject;
            context.setParam(params[0]);

            try{
                commonInterface.onStarted(context);
                //执行目标的方法
                Object result=invocation.proceed();
                context=(Context) result;
                commonInterface.onSuccess(context);
            }catch (Exception e){
                commonInterface.onError(context,e);
            }finally {
                context.setParam(params[0]);
                context.setClassName(className);
                context.setMethodName(methodName);
                commonInterface.onEnd(context);
            }
            endTime= System.currentTimeMillis();
        //    CollectionLog.getLogger().info(className+"-"+methodName+"耗时："+(endTime-startTime)+"ms");
            return context;
        }else{
            //如果不继承公共类，那么自己实现校验
            endTime= System.currentTimeMillis();
        //    CollectionLog.getLogger().info(className+"-"+methodName+"耗时："+(endTime-startTime)+"ms");
            return invocation.proceed();
        }

    }
}
