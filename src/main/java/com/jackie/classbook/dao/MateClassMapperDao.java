package com.jackie.classbook.dao;

import com.jackie.classbook.entity.MateClassMapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/7/2
 */
public interface MateClassMapperDao {
    int insert(MateClassMapper mateClassMapper);

    int update(MateClassMapper mateClassMapper);

    List<MateClassMapper> queryList(MateClassMapper mateClassMapper);
}
