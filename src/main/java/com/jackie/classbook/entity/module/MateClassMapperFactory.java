package com.jackie.classbook.entity.module;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.common.MateTypeEnum;
import com.jackie.classbook.dto.response.MateClassMapperRespDTO;
import com.jackie.classbook.entity.MateClassMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/7/2
 */
public class MateClassMapperFactory {
    public static MateClassMapperRespDTO convertToDTO(MateClassMapper mateClassMapper){
        if (mateClassMapper == null){
            return null;
        }
        String str = JSON.toJSONString(mateClassMapper);
        MateClassMapperRespDTO mateClassMapperRespDTO = JSON.parseObject(str, MateClassMapperRespDTO.class);
        mateClassMapperRespDTO.setMateType(MateTypeEnum.getValue(mateClassMapper.getMateType()));
        return mateClassMapperRespDTO;
    }

    public static List<MateClassMapperRespDTO> convertToDTO(List<MateClassMapper> list){
        if (list == null){
            return null;
        }
        List<MateClassMapperRespDTO> resultList = new ArrayList<>();
        for (MateClassMapper mateClassMapper : list){
            resultList.add(convertToDTO(mateClassMapper));
        }
        return resultList;
    }

    public static MateClassMapperRespDTO getMates(MateClassMapper mateClassMapper){
        if (mateClassMapper == null){
            return null;
        }
        MateClassMapperRespDTO mateClassMapperRespDTO = new MateClassMapperRespDTO();
        mateClassMapperRespDTO.setMateId(mateClassMapper.getMateId());
        mateClassMapperRespDTO.setMateName(mateClassMapper.getMateName());
        mateClassMapperRespDTO.setMateType(MateTypeEnum.getValue(mateClassMapper.getMateType()));
        return mateClassMapperRespDTO;
    }
    public static List<MateClassMapperRespDTO> getMates(List<MateClassMapper> list){
        if (list == null){
            return null;
        }
        List<MateClassMapperRespDTO> resultList = new ArrayList<>();
        for (MateClassMapper mateClassMapper : list){
            resultList.add(getMates(mateClassMapper));
        }
        return resultList;
    }

    public static MateClassMapperRespDTO getClasses(MateClassMapper mateClassMapper){
        if (mateClassMapper == null){
            return null;
        }
        MateClassMapperRespDTO mateClassMapperRespDTO = new MateClassMapperRespDTO();
        mateClassMapperRespDTO.setSchoolId(mateClassMapper.getSchoolId());
        mateClassMapperRespDTO.setSchoolName(mateClassMapper.getSchoolName());
        mateClassMapperRespDTO.setClassId(mateClassMapper.getClassId());
        mateClassMapperRespDTO.setClassName(mateClassMapper.getClassName());
        mateClassMapperRespDTO.setMateType(MateTypeEnum.getValue(mateClassMapper.getMateType()));
        return mateClassMapperRespDTO;
    }

    public static List<MateClassMapperRespDTO> getClasses(List<MateClassMapper> list){
        if (list == null){
            return null;
        }
        List<MateClassMapperRespDTO> resultList = new ArrayList<>();
        for (MateClassMapper mateClassMapper : list){
            resultList.add(getClasses(mateClassMapper));
        }
        return resultList;
    }
}
