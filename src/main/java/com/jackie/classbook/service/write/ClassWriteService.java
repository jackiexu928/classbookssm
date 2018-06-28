package com.jackie.classbook.service.write;

import com.jackie.classbook.dto.request.ClassAddReqDTO;
import com.jackie.classbook.dto.request.ClassSetTeacherReqDTO;
import com.jackie.classbook.process.Context;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/25
 */
public interface ClassWriteService {
    Context<ClassAddReqDTO, Void> insert(ClassAddReqDTO reqDTO);

    Context<ClassSetTeacherReqDTO, Void> setTeacher(ClassSetTeacherReqDTO reqDTO);
}
