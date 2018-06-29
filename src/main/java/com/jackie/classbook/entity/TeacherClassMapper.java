package com.jackie.classbook.entity;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/28
 */
public class TeacherClassMapper {
    private Long id;                //id
    private Long classId;           //班级id
    private Integer year;           //届
    private String className;       //班级名
    private Long teacherId;         //老师id
    private String teacherName;     //老师姓名
    private Integer teacherType;    //老师类型 1-班主任，2-任课老师'
    private String subjects;        //所教科目
    private Byte validFlag;         //标志位

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
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

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getTeacherType() {
        return teacherType;
    }

    public void setTeacherType(Integer teacherType) {
        this.teacherType = teacherType;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public Byte getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(Byte validFlag) {
        this.validFlag = validFlag;
    }
}
