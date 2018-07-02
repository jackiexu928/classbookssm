package com.jackie.classbook.service.write.impl;

import com.jackie.classbook.common.ClassbookCodeEnum;
import com.jackie.classbook.common.ClassbookException;
import com.jackie.classbook.dao.AddressDao;
import com.jackie.classbook.dao.MateClassMapperDao;
import com.jackie.classbook.dao.MateDao;
import com.jackie.classbook.dao.NationDao;
import com.jackie.classbook.dto.request.MateAddReqDTO;
import com.jackie.classbook.dto.request.MateUpdateReqDTO;
import com.jackie.classbook.entity.Mate;
import com.jackie.classbook.entity.MateClassMapper;
import com.jackie.classbook.process.AbstractService;
import com.jackie.classbook.process.Context;
import com.jackie.classbook.service.write.MateWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/29
 */
@Service
public class MateWriteServiceImpl extends AbstractService implements MateWriteService{

    @Autowired
    private MateDao mateDao;
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private NationDao nationDao;
    @Autowired
    private MateClassMapperDao mateClassMapperDao;

    @Override
    public Context<MateAddReqDTO, Void> addMate(MateAddReqDTO reqDTO) {
        //校验手机号、QQ、邮箱，三者不能重复
        if (reqDTO.getMobile() != null){
            Mate checkMobile = mateDao.queryMateByMobile(reqDTO.getMobile());
            if (checkMobile != null){
                throw new ClassbookException(ClassbookCodeEnum.MOBILE_EXIST);
            }
        }
        if (reqDTO.getQq() != null){
            Mate checkQq = mateDao.queryMateByQq(reqDTO.getQq());
            if (checkQq != null){
                throw new ClassbookException(ClassbookCodeEnum.QQ_EXIST);
            }
        }
        if (!StringUtils.isEmpty(reqDTO.getEmail())){
            Mate checkEmail = mateDao.queryMateByEmail(reqDTO.getEmail());
            if (checkEmail != null){
                throw new ClassbookException(ClassbookCodeEnum.EMAIL_EXIST);
            }
        }

        Mate mate = new Mate();
        //TODO 获取登录用户的id
        mate.setAccountId(7L);
        mate.setName(reqDTO.getName());
        mate.setMobile(reqDTO.getMobile());
        mate.setQq(reqDTO.getQq());
        mate.setEmail(reqDTO.getEmail());
        mate.setNation(getNation(reqDTO.getNationId()));
        mate.setAge(reqDTO.getAge());
        mate.setSex(reqDTO.getSex());
        mate.setProvince(getAddress(reqDTO.getProvinceCode()));
        mate.setCity(getAddress(reqDTO.getCityCode()));
        mate.setCountry(getAddress(reqDTO.getCountryCode()));
        mate.setTown(reqDTO.getTown());
        mate.setVillage(reqDTO.getVillage());
        mate.setLiveCity(reqDTO.getLiveCity());
        mate.setImpression(reqDTO.getImpression());
        mate.setValidFlag((byte)1);
        mateDao.insert(mate);
        Context<MateAddReqDTO, Void> context = new Context<>();
        return context;
    }

    @Override
    public Context<MateUpdateReqDTO, Void> updateMate(MateUpdateReqDTO reqDTO) {
        if (reqDTO.getMobile() != null){
            Mate checkMobile = mateDao.queryMateByMobile(reqDTO.getMobile());
            if (checkMobile != null && !checkMobile.getId().equals(reqDTO.getId())){
                throw new ClassbookException(ClassbookCodeEnum.MOBILE_EXIST);
            }
        }
        if (reqDTO.getQq() != null){
            Mate checkQq = mateDao.queryMateByQq(reqDTO.getQq());
            if (checkQq != null && !checkQq.getId().equals(reqDTO.getId())){
                throw new ClassbookException(ClassbookCodeEnum.QQ_EXIST);
            }
        }
        if (!StringUtils.isEmpty(reqDTO.getEmail())){
            Mate checkEmail = mateDao.queryMateByEmail(reqDTO.getEmail());
            if (checkEmail != null && !checkEmail.getId().equals(reqDTO.getId())){
                throw new ClassbookException(ClassbookCodeEnum.EMAIL_EXIST);
            }
        }

        Mate mate = mateDao.queryById(reqDTO.getId());
        mate.setName(reqDTO.getName());
        mate.setMobile(reqDTO.getMobile());
        mate.setQq(reqDTO.getQq());
        mate.setEmail(reqDTO.getEmail());
        mate.setNation(getNation(reqDTO.getNationId()));
        mate.setAge(reqDTO.getAge());
        mate.setSex(reqDTO.getSex());
        mate.setProvince(getAddress(reqDTO.getProvinceCode()));
        mate.setCity(getAddress(reqDTO.getCityCode()));
        mate.setCountry(getAddress(reqDTO.getCountryCode()));
        mate.setTown(reqDTO.getTown());
        mate.setVillage(reqDTO.getVillage());
        mate.setLiveCity(reqDTO.getLiveCity());
        mate.setImpression(reqDTO.getImpression());
        mateDao.update(mate);

        //修改班级同学映射表
        MateClassMapper mateClassMapper = new MateClassMapper();
        mateClassMapper.setMateId(reqDTO.getId());
        mateClassMapper.setMateName(reqDTO.getName());
        mateClassMapper.setMateType(reqDTO.getAge());
        mateClassMapperDao.update(mateClassMapper);

        Context<MateUpdateReqDTO, Void> context = new Context<>();
        return context;
    }

    public String getAddress(Long codeId){
        if (codeId == null){
            return null;
        }
        return addressDao.queryAddressByCodeId(codeId).getName();
    }

    public String getNation(Long nationId){
        if (nationId == null){
            return null;
        }
        return nationDao.queryNationById(nationId).getNation();
    }
}
