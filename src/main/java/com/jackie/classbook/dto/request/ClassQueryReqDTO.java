package com.jackie.classbook.dto.request;

import com.jackie.classbook.common.ClassbookCodeEnum;
import com.jackie.classbook.common.ClassbookException;
import com.jackie.classbook.dto.BaseReqDTO;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/25
 */
public class ClassQueryReqDTO extends BaseReqDTO {
    private Long schoolId;      //学校id
    private Integer year;       //届
    private String className;   //班级名

    @Override
    public void validation() {
        if (schoolId == null || schoolId < 1L){
            throw new ClassbookException(ClassbookCodeEnum.ILLGAL_ARGUMENT);
        }
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
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
}
