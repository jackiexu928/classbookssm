package com.jackie.classbook.service.read.impl;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.dao.AddressDao;
import com.jackie.classbook.dao.MateClassMapperDao;
import com.jackie.classbook.dao.MateDao;
import com.jackie.classbook.dto.request.BaseIdReqDTO;
import com.jackie.classbook.dto.request.MateQueryReqDTO;
import com.jackie.classbook.dto.response.MateClassMapperRespDTO;
import com.jackie.classbook.dto.response.MateDetailRespDTO;
import com.jackie.classbook.dto.response.MateRespDTO;
import com.jackie.classbook.entity.Mate;
import com.jackie.classbook.entity.MateClassMapper;
import com.jackie.classbook.entity.module.MateClassMapperFactory;
import com.jackie.classbook.entity.module.MateFactory;
import com.jackie.classbook.process.AbstractQueryService;
import com.jackie.classbook.process.Context;
import com.jackie.classbook.service.read.MateReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/7/2
 */
@Service
public class MateReadServiceImpl extends AbstractQueryService implements MateReadService {
    @Autowired
    private MateDao mateDao;
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private MateClassMapperDao mateClassMapperDao;

    @Override
    public Context<MateQueryReqDTO, List<MateRespDTO>> getList(MateQueryReqDTO reqDTO) {
        Map filters = new HashMap();
        //TODO 获取登录用户的id
        filters.put("accountId", 7L);
        filters.put("keyword", reqDTO.getKeyword());
        filters.put("sex", reqDTO.getSex());
        filters.put("province", getAddress(reqDTO.getProvinceCode()));
        filters.put("city", getAddress(reqDTO.getCityCode()));
        filters.put("country", getAddress(reqDTO.getCountryCode()));
        filters.put("liveCity", reqDTO.getLiveCity());
        List<Mate> list = mateDao.queryMates(filters);
        List<MateRespDTO> resultList = MateFactory.convertToDTO(list);
        Context<MateQueryReqDTO, List<MateRespDTO>> context = new Context<>();
        context.setResult(resultList);
        return context;
    }

    @Override
    public Context<BaseIdReqDTO, MateDetailRespDTO> getDetail(BaseIdReqDTO reqDTO) {
        Mate mate = mateDao.queryById(reqDTO.getId());
        MateClassMapper mateClassMapper = new MateClassMapper();
        mateClassMapper.setAccountId(mate.getAccountId());
        mateClassMapper.setMateId(reqDTO.getId());
        List<MateClassMapper> list = mateClassMapperDao.queryList(mateClassMapper);
        List<MateClassMapperRespDTO> respList = MateClassMapperFactory.getClasses(list);
        MateDetailRespDTO mateDetailRespDTO = JSON.parseObject(JSON.toJSONString(mate), MateDetailRespDTO.class);
        mateDetailRespDTO.setClassList(respList);
        Context<BaseIdReqDTO, MateDetailRespDTO> context = new Context<>();
        context.setResult(mateDetailRespDTO);
        return context;
    }

    public String getAddress(Long codeId){
        if (codeId == null){
            return null;
        }
        return addressDao.queryAddressByCodeId(codeId).getName();
    }
}
