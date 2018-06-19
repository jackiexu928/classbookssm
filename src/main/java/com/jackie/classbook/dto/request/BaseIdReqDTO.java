package com.jackie.classbook.dto.request;

import com.jackie.classbook.dto.BaseReqDTO;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/15
 */
public class BaseIdReqDTO extends BaseReqDTO {
    private Long id;
    @Override
    public void validation() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
