package com.jackie.classbook.dao;

import com.jackie.classbook.dto.request.MateQueryReqDTO;
import com.jackie.classbook.entity.Mate;

import java.util.List;
import java.util.Map;

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

    List<Mate> queryMates(Map map);

    int deleteByIdList(List<Long> idList);
}
