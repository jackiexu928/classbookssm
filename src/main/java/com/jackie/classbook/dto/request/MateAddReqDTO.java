package com.jackie.classbook.dto.request;

import com.jackie.classbook.common.ClassbookCodeEnum;
import com.jackie.classbook.common.ClassbookException;
import com.jackie.classbook.dto.BaseReqDTO;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/29
 */
public class MateAddReqDTO extends BaseReqDTO {
    //private Long accountId;         //用户id
    private String name;            //同学姓名
    private Long mobile;            //手机号
    private Long qq;                //QQ
    private String email;           //邮箱
    private Long nationId;          //民族
    private Integer age;            //年龄
    private Byte sex;               //性别
    private Long provinceCode;      //省code
    private Long cityCode;          //市code
    private Long countryCode;       //县、区code
    private String town;            //街道、镇
    private String village;         //村
    private String liveCity;        //现居城市（可能是国外，所以不传code）
    private String impression;      //印象
    @Override
    public void validation() {
        /*if (accountId == null || accountId == 0L){
            throw new ClassbookException(ClassbookCodeEnum.ILLGAL_ARGUMENT);
        }*/
        if (mobile != null && String.valueOf(mobile).length() != 11){
            throw new ClassbookException(ClassbookCodeEnum.ILLGAL_MOBILE);
        }
        if (email != null && !email.contains("@")){
            throw new ClassbookException(ClassbookCodeEnum.ILLGAL_EMAIL);
        }
    }

    /*public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public Long getQq() {
        return qq;
    }

    public void setQq(Long qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getNationId() {
        return nationId;
    }

    public void setNationId(Long nationId) {
        this.nationId = nationId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Long getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(Long provinceCode) {
        this.provinceCode = provinceCode;
    }

    public Long getCityCode() {
        return cityCode;
    }

    public void setCityCode(Long cityCode) {
        this.cityCode = cityCode;
    }

    public Long getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(Long countryCode) {
        this.countryCode = countryCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getLiveCity() {
        return liveCity;
    }

    public void setLiveCity(String liveCity) {
        this.liveCity = liveCity;
    }

    public String getImpression() {
        return impression;
    }

    public void setImpression(String impression) {
        this.impression = impression;
    }
}
