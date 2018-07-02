package com.jackie.classbook.dto.response;

import com.jackie.classbook.dto.BaseRespDTO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/28
 */
public class ClassDetailRespDTO extends BaseRespDTO {
    private Long classId;       //班级id
    private Long schoolId;      //学校id
    private String schoolName;  //校名
    private Integer year;       //届
    private String className;   //班级名
    private List<TeacherClassMapperRespDTO> teachersList;   //老师list
    private List<MateClassMapperRespDTO> matesList;         //同学list

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<TeacherClassMapperRespDTO> getTeachersList() {
        return teachersList;
    }

    public void setTeachersList(List<TeacherClassMapperRespDTO> teachersList) {
        this.teachersList = teachersList;
    }

    public List<MateClassMapperRespDTO> getMatesList() {
        return matesList;
    }

    public void setMatesList(List<MateClassMapperRespDTO> matesList) {
        this.matesList = matesList;
    }
}
