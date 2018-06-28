package com.jackie.classbook.service.read;

import com.jackie.classbook.dto.request.BaseIdReqDTO;
import com.jackie.classbook.dto.request.TeacherQueryReqDTO;
import com.jackie.classbook.dto.response.TeacherDetailRespDTO;
import com.jackie.classbook.dto.response.TeacherRespDTO;
import com.jackie.classbook.process.Context;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/28
 */
public interface TeacherReadService {
    Context<TeacherQueryReqDTO, List<TeacherRespDTO>> queryTeachers(TeacherQueryReqDTO reqDTO);

    Context<BaseIdReqDTO, TeacherDetailRespDTO> getTeacherDetail(BaseIdReqDTO reqDTO);
}
