package com.jackie.classbook.dto.response;

import com.jackie.classbook.dto.BaseRespDTO;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/12/4
 */
public class MateExportRespDTO extends BaseRespDTO {
    private Integer serialNum;      //序号
    private String schoolName;      //校名
    private String className;       //班级名
    private String name;            //姓名
    private String type;            //类型
    private Long mobile;            //手机号
    private Long qq;                //qq号
    private String email;           //邮箱
    private String nation;          //民族
    private Integer age;            //年龄
    private String sex;               //性别
    private String province;        //省
    private String city;            //市
    private String country;         //县、区
    private String town;            //街道、镇
    private String village;         //村
    private String liveCity;        //现居城市
    private String impression;      //印象

    public Integer getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(Integer serialNum) {
        this.serialNum = serialNum;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    @Override
    public String toString() {
        return serialNum +
                "," + (schoolName == null ? "-" : schoolName) +
                "," + (className == null ? "-" : className) +
                "," + (name == null ? "-" : name) +
                "," + (type == null ? "-" : type) +
                "," + (mobile == null ? "-" : mobile) +
                "," + (qq == null ? "-" : qq) +
                "," + (StringUtils.isEmpty(email) ? "-" : email) +
                "," + (StringUtils.isEmpty(nation) ? "-" : nation) +
                "," + (age == null ? "-" : age) +
                "," + (sex == null ? "-" : sex) +
                "," + (StringUtils.isEmpty(province) ? "-" : province) +
                "," + (StringUtils.isEmpty(city) ? "-" : city) +
                "," + (StringUtils.isEmpty(country) ? "-" : country) +
                "," + (StringUtils.isEmpty(town) ? "-" : town) +
                "," + (StringUtils.isEmpty(village) ? "-" : village) +
                "," + (StringUtils.isEmpty(liveCity) ? "-" : liveCity) +
                "," + (StringUtils.isEmpty(impression) ? "-" : impression);
    }
}
