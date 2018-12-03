package com.jackie.classbook.dao;

import com.jackie.classbook.entity.MateClassMapper;

import java.util.List;
import java.util.Map;

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

    int deleteByIdList(Map map);

    List<MateClassMapper> queryClassListByAccountId(MateClassMapper mateClassMapper);
}
