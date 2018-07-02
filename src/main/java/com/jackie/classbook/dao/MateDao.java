package com.jackie.classbook.dao;

import com.jackie.classbook.entity.Mate;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/29
 */
public interface MateDao {
    int insert(Mate mate);

    Mate queryMateByMobile(Long mobile);

    Mate queryMateByQq(Long qq);

    Mate queryMateByEmail(String email);

    Mate queryById(Long id);

    int update(Mate mate);
}
