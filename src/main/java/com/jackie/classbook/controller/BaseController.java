package com.jackie.classbook.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jackie.classbook.process.Context;
import com.jackie.classbook.util.ResultMessageBuilder;

public class BaseController {

    private static final String DEFAULE_DATA_FOMATE = "yyyy-MM-dd HH:mm:ss";

    protected String toJSON(Context context) {
        if (!context.isSuccess()) {
            return ResultMessageBuilder.build(false, context.getErrorCode(), context.getErrorMsg()).toJSONString();
        } else {
            return ResultMessageBuilder.build(context.getResult()).toJSONString();
        }
    }

    protected String toJSONByWriteNullStringAsEmpty(Context context) {
        if (!context.isSuccess()) {
            return ResultMessageBuilder.build(false, context.getErrorCode(), context.getErrorMsg()).toJSONString();
        } else {

            return JSON.toJSONString(ResultMessageBuilder.build(context.getResult()),
                    new SerializerFeature[]{SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteMapNullValue});
        }
    }
    protected String toJSONByWriteNullStringAsEmptyAndDateFormat(Context context, String dateFormat) {
        if (!context.isSuccess()) {
            return ResultMessageBuilder.build(false, context.getErrorCode(), context.getErrorMsg()).toJSONString();
        } else {
            return JSON.toJSONStringWithDateFormat(ResultMessageBuilder.build(context.getResult()),dateFormat,
                    new SerializerFeature[]{SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteMapNullValue});
        }
    }

    /**
     * 根据日期格式格式化返回数据
     * * @return
     */
    protected String toJSONByDateFormat(Context context, String dateFormat) {
        if (!context.isSuccess()) {
            return ResultMessageBuilder.build(false, context.getErrorCode(), context.getErrorMsg()).toJSONString();
        } else {
            return ResultMessageBuilder.build(context.getResult()).toJSONString(dateFormat);
        }
    }

    /**
     * 根据日期格式格式化返回数据
     *
     * @param context
     * @return
     */
    protected String toJSONByDateFormat(Context context) {
        return toJSONByDateFormat(context, DEFAULE_DATA_FOMATE);
    }

    public static void main(String[] args) {
        /*Context context = new Context();
        HospitalInfosRespDTO respDTO = new HospitalInfosRespDTO();
        respDTO.setAuditStatus(1);
        respDTO.setCreateTime(new Date());
        context.setResult(respDTO);

        ResultMessageBuilder.ResultMessage resultMessage = ResultMessageBuilder.build(context.getResult());
        String str = resultMessage.toJSONString();
        String str1 = JSON.toJSONString(resultMessage, new SerializerFeature[]{SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteMapNullValue});
        String str2 = JSON.toJSONStringWithDateFormat(respDTO,"yyyy-MM-dd", new SerializerFeature[]{SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteMapNullValue});

        System.out.println(str1);*/
    }
}
