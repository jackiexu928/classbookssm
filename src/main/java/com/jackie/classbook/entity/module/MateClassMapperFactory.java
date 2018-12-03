package com.jackie.classbook.entity.module;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.common.MateTypeEnum;
import com.jackie.classbook.dto.response.ClassExportRespDTO;
import com.jackie.classbook.dto.response.MateClassMapperRespDTO;
import com.jackie.classbook.entity.MateClassMapper;
import com.jackie.classbook.entity.TeacherClassMapper;

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

    public static List<ClassExportRespDTO> getClassExportRespDTO(List<MateClassMapper> list, Map<String, String> map){
        List<ClassExportRespDTO> resultList = new ArrayList<>();
        int serialNum = 1;
        for (MateClassMapper mateClassMapper : list){
            ClassExportRespDTO classExportRespDTO = new ClassExportRespDTO();
            classExportRespDTO.setSchoolName(mateClassMapper.getSchoolName());
            classExportRespDTO.setYear(Integer.parseInt(map.get(mateClassMapper.getClassId() + "")));
            classExportRespDTO.setClassName(mateClassMapper.getClassName());
            if (map.containsKey(mateClassMapper.getClassId() + "-classTeacher")){
                classExportRespDTO.setClassTeacher(map.get(mateClassMapper.getClassId() + "-classTeacher"));
            }
            if (map.containsKey(mateClassMapper.getClassId() + "-subjectTeacher")){
                classExportRespDTO.setSubjectTeacher(map.get(mateClassMapper.getClassId() + "-subjectTeacher"));
            }
            //根据年份进行排序
            if (resultList.size() > 0) {
                for (int i = 0; i < resultList.size(); i ++){
                    if (classExportRespDTO.getYear() >= resultList.get(i - 1).getYear() &&
                            classExportRespDTO.getYear() < resultList.get(i).getYear()){
                        List<ClassExportRespDTO> respList = resultList.subList(i, resultList.size());
                        resultList = resultList.subList(0, i);
                        resultList.add(classExportRespDTO);
                        resultList.addAll(respList);
                    }
                }
            }
        }
        for (ClassExportRespDTO classExportRespDTO : resultList){
            classExportRespDTO.setSerialNum(serialNum);
            serialNum ++;
        }
        return resultList;
    }
}
