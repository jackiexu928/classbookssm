package com.jackie.classbook.entity.module;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.dto.response.SchoolRespDTO;
import com.jackie.classbook.entity.School;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/25
 */
public class SchoolFactory {
    public static SchoolRespDTO convertToDTO(School school){
        if (school == null){
            return null;
        }
        String str = JSON.toJSONString(school);
        SchoolRespDTO schoolRespDTO = JSON.parseObject(str, SchoolRespDTO.class);
        return schoolRespDTO;
    }

    public static List<SchoolRespDTO> convertToDTO(List<School> list){
        if (list == null){
            return null;
        }
        List<SchoolRespDTO> resultList = new ArrayList<>();
        for (School school : list){
            resultList.add(convertToDTO(school));
        }
        return resultList;
    }
}
