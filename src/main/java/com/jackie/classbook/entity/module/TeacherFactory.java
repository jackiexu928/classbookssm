package com.jackie.classbook.entity.module;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.common.SexEnum;
import com.jackie.classbook.dto.response.TeacherExportRespDTO;
import com.jackie.classbook.dto.response.TeacherRespDTO;
import com.jackie.classbook.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/28
 */
public class TeacherFactory {
    public static TeacherRespDTO convertToDTO(Teacher teacher){
        if (teacher == null){
            return null;
        }
        String str = JSON.toJSONString(teacher);
        TeacherRespDTO teacherRespDTO = JSON.parseObject(str, TeacherRespDTO.class);
        return teacherRespDTO;
    }

    public static List<TeacherRespDTO> convertToDTO(List<Teacher> list){
        if (list == null){
            return null;
        }
        List<TeacherRespDTO> resultList = new ArrayList<>();
        for (Teacher teacher : list){
            resultList.add(convertToDTO(teacher));
        }
        return resultList;
    }

    public static List<TeacherExportRespDTO> getTeacherExportRespDTO(List<Teacher> list){
        List<TeacherExportRespDTO> resultList = new ArrayList<>();
        int serialNum = 1;
        for (Teacher teacher : list){
            TeacherExportRespDTO teacherExportRespDTO = new TeacherExportRespDTO();
            teacherExportRespDTO.setSerialNum(serialNum);
            teacherExportRespDTO.setSchoolName(teacher.getSchoolName());
            teacherExportRespDTO.setName(teacher.getName());
            teacherExportRespDTO.setSex(SexEnum.getValue(teacher.getSex()));
            teacherExportRespDTO.setMobile(teacher.getMobile());
            teacherExportRespDTO.setEmail(teacher.getEmail());
            teacherExportRespDTO.setSubjects(teacher.getSubjects());
            resultList.add(teacherExportRespDTO);
            serialNum ++;
        }
        return resultList;
    }
}
