package com.jackie.classbook.service.read.impl;

import com.jackie.classbook.dao.AddressDao;
import com.jackie.classbook.dto.request.BaseIdReqDTO;
import com.jackie.classbook.dto.response.AddressRespDTO;
import com.jackie.classbook.entity.Address;
import com.jackie.classbook.entity.module.AddressFactory;
import com.jackie.classbook.process.AbstractQueryService;
import com.jackie.classbook.process.Context;
import com.jackie.classbook.service.read.AddressReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/21
 */
@Service
public class AddressReadServiceImpl extends AbstractQueryService implements AddressReadService{

    @Autowired
    private AddressDao addressDao;

    @Override
    public Context<BaseIdReqDTO, List<AddressRespDTO>> getAddressListByParentId(BaseIdReqDTO reqDTO) {
        List<Address> list = addressDao.queryAddressByParentId(reqDTO.getId());
        List<AddressRespDTO> resultList = AddressFactory.convertToDTO(list);
        Context<BaseIdReqDTO, List<AddressRespDTO>> context = new Context<>();
        context.setResult(resultList);
        return context;
    }
}
