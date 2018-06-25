package com.jackie.classbook.entity.module;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.dto.response.ClassRespDTO;
import com.jackie.classbook.entity.Class;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/25
 */
public class ClassFactory {
    public static ClassRespDTO convertToDTO(Class clazz){
        if (clazz == null){
            return null;
        }
        String str = JSON.toJSONString(clazz);
        ClassRespDTO classRespDTO = JSON.parseObject(str, ClassRespDTO.class);
        return classRespDTO;
    }

    public static List<ClassRespDTO> convertToDTO(List<Class> list){
        if (list == null){
            return null;
        }
        List<ClassRespDTO> resultList = new ArrayList<>();
        for (Class clazz : list){
            resultList.add(convertToDTO(clazz));
        }
        return resultList;
    }
}
