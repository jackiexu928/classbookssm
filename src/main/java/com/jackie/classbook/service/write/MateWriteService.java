package com.jackie.classbook.service.write;

import com.jackie.classbook.dto.request.BaseIdReqDTO;
import com.jackie.classbook.dto.request.MateAddReqDTO;
import com.jackie.classbook.dto.request.MateDeleteReqDTO;
import com.jackie.classbook.dto.request.MateUpdateReqDTO;
import com.jackie.classbook.process.Context;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/29
 */
public interface MateWriteService {
    Context<MateAddReqDTO, Void> addMate(MateAddReqDTO reqDTO);

    Context<MateUpdateReqDTO, Void> updateMate(MateUpdateReqDTO reqDTO);

    Context<MateDeleteReqDTO, Void> deleteMate(MateDeleteReqDTO reqDTO);
}
