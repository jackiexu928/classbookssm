package com.jackie.classbook.entity.module;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.dto.response.AddressRespDTO;
import com.jackie.classbook.entity.Address;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/21
 */
public class AddressFactory {
    public static AddressRespDTO convertToDTO(Address address){
        if (address == null){
            return null;
        }
        String str = JSON.toJSONString(address);
        AddressRespDTO addressRespDTO = JSON.parseObject(str, AddressRespDTO.class);
        return addressRespDTO;
    }

    public static List<AddressRespDTO> convertToDTO(List<Address> list){
        if (list == null){
            return null;
        }
        List<AddressRespDTO> resultList = new ArrayList<>();
        for (Address address : list){
            resultList.add(convertToDTO(address));
        }
        return resultList;
    }
}
