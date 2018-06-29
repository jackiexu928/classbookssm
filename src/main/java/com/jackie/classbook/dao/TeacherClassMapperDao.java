package com.jackie.classbook.dao;

import com.jackie.classbook.entity.TeacherClassMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/28
 */
public interface TeacherClassMapperDao {
    int insert(TeacherClassMapper teacherClassMapper);

    List<TeacherClassMapper> queryList(TeacherClassMapper teacherClassMapper);

    int update(TeacherClassMapper teacherClassMapper);

    int delete(@Param("classId")Long classId, @Param("teacherId")Long teacherId);
}
