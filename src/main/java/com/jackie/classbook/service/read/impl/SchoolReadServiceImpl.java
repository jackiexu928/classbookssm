package com.jackie.classbook.service.read.impl;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.dao.AddressDao;
import com.jackie.classbook.dao.SchoolDao;
import com.jackie.classbook.dto.request.SchoolQueryReqDTO;
import com.jackie.classbook.dto.response.SchoolRespDTO;
import com.jackie.classbook.entity.School;
import com.jackie.classbook.entity.module.SchoolFactory;
import com.jackie.classbook.process.AbstractQueryService;
import com.jackie.classbook.process.Context;
import com.jackie.classbook.service.read.SchoolReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/25
 */
@Service
public class SchoolReadServiceImpl extends AbstractQueryService implements SchoolReadService{

    @Autowired
    private SchoolDao schoolDao;
    @Autowired
    private AddressDao addressDao;

    @Override
    public Context<SchoolQueryReqDTO, List<SchoolRespDTO>> getSchools(SchoolQueryReqDTO reqDTO) {
        School school = new School();
        school.setSchoolName(reqDTO.getSchoolName());
        school.setType(reqDTO.getType());
        school.setProvince(getAddress(reqDTO.getProvinceCode()));
        school.setCity(getAddress(reqDTO.getCityCode()));
        school.setCountry(getAddress(reqDTO.getCountryCode()));
        List<School> list = schoolDao.querySchools(school);
        List<SchoolRespDTO> resultList = SchoolFactory.convertToDTO(list);
        Context<SchoolQueryReqDTO, List<SchoolRespDTO>> context = new Context<>();
        context.setResult(resultList);
        return context;
    }

    public String getAddress(Long codeId){
        if (codeId == null){
            return null;
        }
        return addressDao.queryAddressByCodeId(codeId).getName();
    }
}
