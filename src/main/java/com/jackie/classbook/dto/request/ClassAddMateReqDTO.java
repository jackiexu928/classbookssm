package com.jackie.classbook.dto.request;

import com.jackie.classbook.dto.BaseReqDTO;
import com.jackie.classbook.util.ValidtionUitl;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/7/2
 */
public class ClassAddMateReqDTO extends BaseReqDTO {
    private Long schoolId;          //学校id
    private Long classId;           //班级id
    private Long mateId;            //同学id
    private Integer mateType;       //同学类型，1-同桌，2-室友，3-其他
    @Override
    public void validation() {
        ValidtionUitl.validation(this);
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getMateId() {
        return mateId;
    }

    public void setMateId(Long mateId) {
        this.mateId = mateId;
    }

    public Integer getMateType() {
        return mateType;
    }

    public void setMateType(Integer mateType) {
        this.mateType = mateType;
    }
}
