package com.jackie.classbook.service.read;

import com.jackie.classbook.dto.request.SchoolQueryReqDTO;
import com.jackie.classbook.dto.response.SchoolRespDTO;
import com.jackie.classbook.process.Context;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/25
 */
public interface SchoolReadService {
    Context<SchoolQueryReqDTO, List<SchoolRespDTO>> getSchools(SchoolQueryReqDTO reqDTO);
}
