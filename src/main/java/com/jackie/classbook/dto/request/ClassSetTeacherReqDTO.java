package com.jackie.classbook.dto.request;

import com.jackie.classbook.dto.BaseReqDTO;
import com.jackie.classbook.util.ValidtionUitl;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/28
 */
public class ClassSetTeacherReqDTO extends BaseReqDTO {
    private Long classId;           //班级id
    private Long teacherId;         //教师id
    private Integer teacherType;    //老师类型 1-班主任，2-任课老师'
    @Override
    public void validation() {
        ValidtionUitl.validation(this);
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getTeacherType() {
        return teacherType;
    }

    public void setTeacherType(Integer teacherType) {
        this.teacherType = teacherType;
    }
}
