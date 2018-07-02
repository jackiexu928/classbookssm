package com.jackie.classbook.service.read;

import com.jackie.classbook.dto.request.MateQueryReqDTO;
import com.jackie.classbook.dto.response.MateRespDTO;
import com.jackie.classbook.process.Context;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/7/2
 */
public interface MateReadService {
    Context<MateQueryReqDTO, List<MateRespDTO>> getList(MateQueryReqDTO reqDTO);
}
