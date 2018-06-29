package com.jackie.classbook.dto.request;

import com.jackie.classbook.dto.BaseReqDTO;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/29
 */
public class ClassUpdateReqDTO extends BaseReqDTO {

    private Long id;            //id
    private String className;   //班级名
    @Override
    public void validation() {

    }

}
