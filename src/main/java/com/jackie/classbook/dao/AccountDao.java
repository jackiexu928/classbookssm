package com.jackie.classbook.dao;

import com.jackie.classbook.entity.Account;


/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/15
 */
public interface AccountDao {
    int insert(Account account);

    Account queryAccountById(Long id);

    Account findAccount(Account account);

    Account queryAccountByMobile(Long mobile);

    Account queryAccountByEmail(String email);

    void update(Account account);
}
