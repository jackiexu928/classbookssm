package com.jackie.classbook.entity.module;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.dto.response.AccountRespDTO;
import com.jackie.classbook.entity.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/19
 */
public class AccountFactory {

    public static AccountRespDTO convertToDTO(Account account){
        if (account == null){
            return null;
        }
        String str = JSON.toJSONString(account);
        AccountRespDTO accountRespDTO = JSON.parseObject(str, AccountRespDTO.class);
        return accountRespDTO;
    }

    public static List<AccountRespDTO> convertToDTO(List<Account> list){
        if (list == null){
            return null;
        }
        List<AccountRespDTO> resultList = new ArrayList<>();
        for (Account account : list){
            resultList.add(convertToDTO(account));
        }
        return resultList;
    }
}
