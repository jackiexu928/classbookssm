package com.jackie.classbook.entity.module;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.common.MateTypeEnum;
import com.jackie.classbook.common.SexEnum;
import com.jackie.classbook.dto.response.MateExportRespDTO;
import com.jackie.classbook.dto.response.MateRespDTO;
import com.jackie.classbook.entity.Mate;
import com.jackie.classbook.entity.MateClassMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public static List<MateExportRespDTO> getMateExportRespDTO(List<MateClassMapper> mateClassList, Map<Long, Mate> mateMap){
        List<MateExportRespDTO> resultList = new ArrayList<>();
        int serialNum = 1;
        for (MateClassMapper mateClassMapper : mateClassList){
            Mate mate = mateMap.get(mateClassMapper.getMateId());
            MateExportRespDTO mateExportRespDTO = new MateExportRespDTO();
            mateExportRespDTO.setSerialNum(serialNum);
            mateExportRespDTO.setSchoolName(mateClassMapper.getSchoolName());
            mateExportRespDTO.setClassName(mateClassMapper.getClassName());
            mateExportRespDTO.setName(mateClassMapper.getMateName());
            mateExportRespDTO.setType(MateTypeEnum.getValue(mateClassMapper.getMateType()));
            mateExportRespDTO.setMobile(mate.getMobile());
            mateExportRespDTO.setQq(mate.getQq());
            mateExportRespDTO.setEmail(mate.getEmail());
            mateExportRespDTO.setNation(mate.getNation());
            mateExportRespDTO.setAge(mate.getAge());
            mateExportRespDTO.setSex(SexEnum.getValue(mate.getSex()));
            mateExportRespDTO.setProvince(mate.getProvince());
            mateExportRespDTO.setCity(mate.getCity());
            mateExportRespDTO.setCountry(mate.getCountry());
            mateExportRespDTO.setTown(mate.getTown());
            mateExportRespDTO.setVillage(mate.getVillage());
            mateExportRespDTO.setLiveCity(mate.getLiveCity());
            mateExportRespDTO.setImpression(mate.getImpression());
            resultList.add(mateExportRespDTO);
            serialNum ++;
        }
        return resultList;
    }
}
