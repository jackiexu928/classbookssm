package com.jackie.classbook.dto.request;

import com.jackie.classbook.dto.BaseReqDTO;
import com.jackie.classbook.util.ValidtionUitl;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/7/3
 */
public class ClassRemoveMateReqDTO extends BaseReqDTO {
    private Long classId;
    private String mateIds;

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

    public String getMateIds() {
        return mateIds;
    }

    public void setMateIds(String mateIds) {
        this.mateIds = mateIds;
    }
}
