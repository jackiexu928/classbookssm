package com.jackie.classbook.service.write.impl;

import com.alibaba.fastjson.JSON;
import com.jackie.classbook.common.ClassbookCodeEnum;
import com.jackie.classbook.common.ClassbookException;
import com.jackie.classbook.dao.AccountDao;
import com.jackie.classbook.dao.AddressDao;
import com.jackie.classbook.dao.NationDao;
import com.jackie.classbook.dao.SchoolDao;
import com.jackie.classbook.dto.request.AccountRegisterReqDTO;
import com.jackie.classbook.dto.request.AccountUpdateReqDTO;
import com.jackie.classbook.dto.request.LoginReqDTO;
import com.jackie.classbook.dto.response.AccountLoginRespDTO;
import com.jackie.classbook.dto.response.AccountRespDTO;
import com.jackie.classbook.entity.Account;
import com.jackie.classbook.entity.module.AccountFactory;
import com.jackie.classbook.process.AbstractService;
import com.jackie.classbook.process.Context;
import com.jackie.classbook.service.write.AccountWriteService;
import com.jackie.classbook.util.SignUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/19
 */
@Service
public class AccountWriteServiceImpl extends AbstractService implements AccountWriteService {
    private static ExecutorService pool = Executors.newFixedThreadPool(10);//最大线程数10

    @Autowired
    private AccountDao accountDao;
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private NationDao nationDao;
    @Autowired
    private SchoolDao schoolDao;

    @Override
    public Context<LoginReqDTO, AccountLoginRespDTO> login(LoginReqDTO reqDTO) {
        Context<LoginReqDTO, AccountLoginRespDTO> context = new Context<>();
        AccountLoginRespDTO accountLoginRespDTO = new AccountLoginRespDTO();
        AccountRespDTO accountRespDTO = new AccountRespDTO();
        Account account = new Account();
        if (reqDTO.getAccount().contains("@")){
            account.setEmail(reqDTO.getAccount());
        }else{
            account.setMobile(Long.valueOf(reqDTO.getAccount()));
        }
        Account loginAccount = accountDao.findAccount(account);
        String password = null;
        try {
            password = SignUtil.md5Encrypt(reqDTO.getPassword());
        }catch (Exception e){}
        if (loginAccount == null){
            throw new ClassbookException(ClassbookCodeEnum.ACCOUNT_NOT_EXIST);
        }else if (!loginAccount.getPassword().equals(password)){
            throw new ClassbookException(ClassbookCodeEnum.ACCOUNT_OR_PASSWORD);
        }else {
            accountRespDTO = AccountFactory.convertToDTO(loginAccount);
        }
        accountLoginRespDTO.setAccountRespDTO(accountRespDTO);
        context.setResult(accountLoginRespDTO);
        return context;
    }

    @Override
    public Context<AccountRegisterReqDTO, Void> insert(AccountRegisterReqDTO reqDTO) {
        //手机号和邮箱要唯一
        //校验手机号
        Account checkMobile = accountDao.queryAccountByMobile(reqDTO.getMobile());
        if (checkMobile != null){
            throw new ClassbookException(ClassbookCodeEnum.MOBILE_EXIST);
        }
        //校验邮箱
        Account checkEmail = accountDao.queryAccountByEmail(reqDTO.getEmail());
        if (checkEmail != null){
            throw new ClassbookException(ClassbookCodeEnum.EMAIL_EXIST);
        }

        Context<AccountRegisterReqDTO, Void> context = new Context<>();
        Account account = JSON.parseObject(JSON.toJSONString(reqDTO), Account.class);
        Date now = new Date();
        try {
            account.setPassword(SignUtil.md5Encrypt(reqDTO.getPassword()));
        }catch (Exception e){}
        account.setRoleId(2L);
        account.setProvince(getAddress(reqDTO.getProvinceCode()));
        account.setCity(getAddress(reqDTO.getCityCode()));
        account.setCountry(getAddress(reqDTO.getCountryCode()));
        account.setPrimarySchoolName(getSchool(reqDTO.getPrimarySchoolId()));
        account.setJuniorSchoolName(getSchool(reqDTO.getJuniorSchoolId()));
        account.setSeniorSchoolName(getSchool(reqDTO.getSeniorSchoolId()));
        account.setUniversityName(getSchool(reqDTO.getUniversityId()));
        account.setCreateTime(now);
        account.setUpdateTime(now);
        account.setValidFlag((byte)1);
        accountDao.insert(account);
        return context;
    }

    @Override
    public Context<AccountUpdateReqDTO, Void> update(AccountUpdateReqDTO reqDTO) {
        Context<AccountUpdateReqDTO, Void> context = new Context<>();
        Account account = accountDao.queryAccountById(reqDTO.getId());
        account.setName(reqDTO.getName());
        account.setNation(getNation(reqDTO.getNationId()));
        account.setSex(reqDTO.getSex());
        account.setAge(reqDTO.getAge());
        account.setProvince(getAddress(reqDTO.getProvinceCode()));
        account.setCity(getAddress(reqDTO.getCityCode()));
        account.setCountry(getAddress(reqDTO.getCountryCode()));
        account.setTown(reqDTO.getTown());
        account.setVillage(reqDTO.getVillage());
        account.setPrimarySchoolId(reqDTO.getPrimarySchoolId());
        account.setPrimarySchoolName(getSchool(reqDTO.getPrimarySchoolId()));
        account.setJuniorSchoolId(reqDTO.getJuniorSchoolId());
        account.setJuniorSchoolName(getSchool(reqDTO.getJuniorSchoolId()));
        account.setSeniorSchoolId(reqDTO.getSeniorSchoolId());
        account.setSeniorSchoolName(getSchool(reqDTO.getSeniorSchoolId()));
        account.setUniversityId(reqDTO.getUniversityId());
        account.setUniversityName(getSchool(reqDTO.getUniversityId()));
        account.setUpdateTime(new Date());
        accountDao.update(account);
        return context;
    }

    public String getAddress(Long codeId){
        return addressDao.queryAddressByCodeId(codeId).getName();
    }

    public String getNation(Long nationId){
        return nationDao.queryNationById(nationId).getNation();
    }

    public String getSchool(Long schoolId){
        return schoolDao.querySchoolById(schoolId).getSchoolName();
    }
}
