package com.jackie.classbook.dao;

import com.jackie.classbook.entity.School;

import java.util.List;

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

    List<School> querySchools(School school);

    List<School> querySchoolByIdList(List<Long> idList);
}
