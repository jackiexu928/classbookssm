package com.jackie.classbook.service.write.impl;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.dao.AddressDao;
import com.jackie.classbook.dao.SchoolDao;
import com.jackie.classbook.dto.request.SchoolAddReqDTO;
import com.jackie.classbook.entity.School;
import com.jackie.classbook.process.AbstractService;
import com.jackie.classbook.process.Context;
import com.jackie.classbook.service.write.SchoolWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/21
 */
@Service
public class SchoolWriteServiceImpl extends AbstractService implements SchoolWriteService{

    @Autowired
    private SchoolDao schoolDao;
    @Autowired
    private AddressDao addressDao;

    @Override
    public Context<SchoolAddReqDTO, Void> addSchool(SchoolAddReqDTO reqDTO) {
        School school = JSON.parseObject(JSON.toJSONString(reqDTO), School.class);
        school.setProvince(getAddress(reqDTO.getProvinceCode()));
        school.setCity(getAddress(reqDTO.getCityCode()));
        school.setCountry(getAddress(reqDTO.getCountryCode()));
        school.setValidFlag((byte)1);
        schoolDao.insert(school);
        Context<SchoolAddReqDTO, Void> context = new Context<>();
        return context;
    }

    public String getAddress(Long codeId){
        return addressDao.queryAddressByCodeId(codeId).getName();
    }
}
