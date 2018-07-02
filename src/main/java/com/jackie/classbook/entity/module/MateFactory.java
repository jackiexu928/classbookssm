package com.jackie.classbook.entity.module;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.dto.response.MateRespDTO;
import com.jackie.classbook.entity.Mate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/7/2
 */
public class MateFactory {
    public static MateRespDTO convertToDTO(Mate mate){
        if (mate == null){
            return null;
        }
        String str = JSON.toJSONString(mate);
        MateRespDTO mateRespDTO = JSON.parseObject(str, MateRespDTO.class);
        return mateRespDTO;
    }

    public static List<MateRespDTO> convertToDTO(List<Mate> list){
        if (list == null){
            return null;
        }
        List<MateRespDTO> resultList = new ArrayList<>();
        for (Mate mate : list){
            resultList.add(convertToDTO(mate));
        }
        return resultList;
    }

}
