package com.jackie.classbook.dto.request;

import com.jackie.classbook.dto.BaseReqDTO;
import com.jackie.classbook.util.ValidtionUitl;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/25
 */
public class ClassAddReqDTO extends BaseReqDTO {
    private Long schoolId;      //学校id
    private String className;   //班级名

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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
