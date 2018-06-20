package com.jackie.classbook.dao;

import com.jackie.classbook.entity.Nation;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/20
 */
public interface NationDao {
    Nation queryNationById(Long id);
}
