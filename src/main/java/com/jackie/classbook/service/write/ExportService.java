package com.jackie.classbook.service.write;

import com.jackie.classbook.dto.request.BaseIdReqDTO;
import com.jackie.classbook.process.Context;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/12/3
 */
public interface ExportService {
    Context<BaseIdReqDTO, Void> exportClass(BaseIdReqDTO reqDTO);
}
