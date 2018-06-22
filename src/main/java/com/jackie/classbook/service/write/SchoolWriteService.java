package com.jackie.classbook.service.write;

import com.jackie.classbook.dto.request.SchoolAddReqDTO;
import com.jackie.classbook.process.Context;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/21
 */
public interface SchoolWriteService {
    Context<SchoolAddReqDTO, Void> addSchool(SchoolAddReqDTO reqDTO);
}
