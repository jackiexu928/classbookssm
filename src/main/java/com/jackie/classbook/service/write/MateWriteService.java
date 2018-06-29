package com.jackie.classbook.service.write;

import com.jackie.classbook.dto.request.MateAddReqDTO;
import com.jackie.classbook.process.Context;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/29
 */
public interface MateWriteService {
    Context<MateAddReqDTO, Void> addMate(MateAddReqDTO reqDTO);
}
