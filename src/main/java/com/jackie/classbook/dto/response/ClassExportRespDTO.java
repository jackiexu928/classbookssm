package com.jackie.classbook.dto.response;

import com.jackie.classbook.dto.BaseRespDTO;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/12/3
 */
public class ClassExportRespDTO extends BaseRespDTO {
    private Integer serialNum;      //序号
    private String schoolName;      //校名
    private Integer year;           //届
    private String className;       //班级名
    private String classTeacher;    //班主任
    private String subjectTeacher;  //任课老师

    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
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

    public String getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher;
    }

    public String getSubjectTeacher() {
        return subjectTeacher;
    }

    public void setSubjectTeacher(String subjectTeacher) {
        this.subjectTeacher = subjectTeacher;
    }

    @Override
    public String toString() {
        return serialNum +
                "," + (schoolName == null ? "-" : schoolName) +
                "," + (year == null ? "-" : year) +
                "," + (className == null ? "-" : className) +
                "," + (classTeacher == null ? "-" : classTeacher) +
                "," + (subjectTeacher == null ? "-" : subjectTeacher);
    }
}
