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
public class TeacherDetailRespDTO extends BaseRespDTO {
    private Long teacherId;     //教师id
    private Long schoolId;      //学校id
    private String schoolName;  //校名
    private String name;        //姓名
    private Byte sex;           //性别
    private Long mobile;        //手机
    private String email;       //邮箱
    private String subjects;    //所教科目
    private List<TeacherClassMapperRespDTO> classList;  //所教班级list

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public List<TeacherClassMapperRespDTO> getClassList() {
        return classList;
    }

    public void setClassList(List<TeacherClassMapperRespDTO> classList) {
        this.classList = classList;
    }
}
