package com.jackie.classbook.dto.request;

import com.jackie.classbook.common.ClassbookCodeEnum;
import com.jackie.classbook.common.ClassbookException;
import com.jackie.classbook.dto.BaseReqDTO;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/28
 */
public class TeacherAddReqDTO extends BaseReqDTO {

    private Long schoolId;      //学校id
    private String name;        //姓名
    private Byte sex;           //性别
    private Long mobile;        //手机
    private String email;       //邮箱
    private String subjects;    //所教科目

    @Override
    public void validation() {
        if (schoolId == null || schoolId == 0L || sex == null){
            throw new ClassbookException(ClassbookCodeEnum.ILLGAL_ARGUMENT);
        }
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
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
}
