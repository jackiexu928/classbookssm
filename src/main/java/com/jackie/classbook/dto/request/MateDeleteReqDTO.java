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
public class MateDeleteReqDTO extends BaseReqDTO {
    private String ids;      //id，多个用逗号分隔

    @Override
    public void validation() {
        ValidtionUitl.validation(this);
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
