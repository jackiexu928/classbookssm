package com.jackie.classbook.dao;

import com.jackie.classbook.entity.Teacher;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/26
 */
public interface TeacherDao {
    int insert(Teacher teacher);

    List<Teacher> queryTeachers(Teacher teacher);

    Teacher queryById(Long id);
}
