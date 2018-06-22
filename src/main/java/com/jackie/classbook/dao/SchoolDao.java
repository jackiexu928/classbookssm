package com.jackie.classbook.dao;

import com.jackie.classbook.entity.School;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/20
 */
public interface SchoolDao {
    School querySchoolById(Long id);

    int insert(School school);
}
