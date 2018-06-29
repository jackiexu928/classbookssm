package com.jackie.classbook.service.write;

import com.jackie.classbook.dto.request.TeacherAddReqDTO;
import com.jackie.classbook.dto.request.TeacherUpdateReqDTO;
import com.jackie.classbook.process.Context;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/28
 */
public interface TeacherWriteService {
    Context<TeacherAddReqDTO, Void> addTeacher(TeacherAddReqDTO reqDTO);

    Context<TeacherUpdateReqDTO, Void> updateTeacher(TeacherUpdateReqDTO reqDTO);
}
