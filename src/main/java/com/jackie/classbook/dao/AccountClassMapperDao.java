package com.jackie.classbook.dao;

import com.jackie.classbook.entity.AccountClassMapper;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/12/7
 */
public interface AccountClassMapperDao {
    List<AccountClassMapper> queryList(AccountClassMapper accountClassMapper);
}
