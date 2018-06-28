package com.jackie.classbook.entity.module;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.common.TeacherTypeEnum;
import com.jackie.classbook.dto.response.TeacherClassMapperRespDTO;
import com.jackie.classbook.entity.TeacherClassMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/28
 */
public class TeacherClassMapperFactory {
    public static TeacherClassMapperRespDTO convertToDTO(TeacherClassMapper teacherClassMapper){
        if (teacherClassMapper == null){
            return null;
        }
        String str = JSON.toJSONString(teacherClassMapper);
        TeacherClassMapperRespDTO teacherClassMapperRespDTO = JSON.parseObject(str, TeacherClassMapperRespDTO.class);
        teacherClassMapperRespDTO.setTeacherType(TeacherTypeEnum.getValue((teacherClassMapper.getTeacherType())));
        return teacherClassMapperRespDTO;
    }

    public static List<TeacherClassMapperRespDTO> convertToDTO(List<TeacherClassMapper> list){
        if (list == null){
            return null;
        }
        List<TeacherClassMapperRespDTO> resultList = new ArrayList<>();
        for (TeacherClassMapper teacherClassMapper : list){
            resultList.add(convertToDTO(teacherClassMapper));
        }
        return resultList;
    }

    public static TeacherClassMapperRespDTO getTeachers(TeacherClassMapper teacherClassMapper){
        if (teacherClassMapper == null){
            return null;
        }
        TeacherClassMapperRespDTO teacherClassMapperRespDTO = new TeacherClassMapperRespDTO();
        teacherClassMapperRespDTO.setTeacherId(teacherClassMapper.getTeacherId());
        teacherClassMapperRespDTO.setTeacherName(teacherClassMapper.getTeacherName());
        teacherClassMapperRespDTO.setTeacherType(TeacherTypeEnum.getValue((teacherClassMapper.getTeacherType())));
        teacherClassMapperRespDTO.setSubjects(teacherClassMapper.getSubjects());
        return teacherClassMapperRespDTO;
    }

    public static List<TeacherClassMapperRespDTO> getTeachers(List<TeacherClassMapper> list){
        if (list == null){
            return null;
        }
        List<TeacherClassMapperRespDTO> resultList = new ArrayList<>();
        for (TeacherClassMapper teacherClassMapper : list){
            resultList.add(getTeachers(teacherClassMapper));
        }
        return resultList;
    }

}
