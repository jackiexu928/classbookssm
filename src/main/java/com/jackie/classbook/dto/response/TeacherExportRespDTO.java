package com.jackie.classbook.dto.response;

import com.jackie.classbook.dto.BaseRespDTO;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/12/6
 */
public class TeacherExportRespDTO extends BaseRespDTO {
    private Integer serialNum;  //序号
    private String schoolName;  //校名
    private String name;        //名字
    private String sex;         //性别
    private Long mobile;        //手机
    private String email;       //邮箱
    private String subjects;    //所教科目

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
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

    @Override
    public String toString() {
        return serialNum +
                "," + (schoolName == null ? "-" : schoolName) +
                "," + (name == null ? "-" : name) +
                "," + (StringUtils.isEmpty(sex) ? "-" : sex) +
                "," + (mobile == null ? "-" : mobile) +
                "," + (StringUtils.isEmpty(email) ? "-" : email) +
                "," + (StringUtils.isEmpty(subjects) ? "-" : subjects);
    }
}
