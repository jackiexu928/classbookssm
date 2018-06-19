package com.jackie.classbook.dao;

import com.jackie.classbook.entity.Account;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/15
 */
public interface AccountDao {
    int insert(Account account);

    Account getAll(Long id);
}
