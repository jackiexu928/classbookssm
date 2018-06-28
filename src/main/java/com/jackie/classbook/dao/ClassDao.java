package com.jackie.classbook.dao;

import com.jackie.classbook.entity.Class;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/25
 */
public interface ClassDao {
    int insert(Class clazz);

    List<Class> getClasses(Class clazz);

    Class queryById(Long id);
}
