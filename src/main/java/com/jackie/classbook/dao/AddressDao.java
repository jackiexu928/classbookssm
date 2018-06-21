package com.jackie.classbook.dao;

import com.jackie.classbook.entity.Address;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/20
 */
public interface AddressDao {
    /**
     * 根据地址id查询地址
     * @param codeId
     * @return
     */
    Address queryAddressByCodeId(Long codeId);

    /**
     * 根据上级地址id查询地址列表
     * @param parentId
     * @return
     */
    List<Address> queryAddressByParentId(Long parentId);
}
