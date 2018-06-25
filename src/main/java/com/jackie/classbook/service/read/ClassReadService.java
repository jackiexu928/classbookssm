package com.jackie.classbook.service.read;

import com.jackie.classbook.dto.request.ClassQueryReqDTO;
import com.jackie.classbook.dto.response.ClassRespDTO;
import com.jackie.classbook.process.Context;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/25
 */
public interface ClassReadService {
    Context<ClassQueryReqDTO, List<ClassRespDTO>> getClasses(ClassQueryReqDTO reqDTO);
}
