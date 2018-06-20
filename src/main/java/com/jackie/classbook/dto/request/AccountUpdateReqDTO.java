package com.jackie.classbook.dto.request;

import com.jackie.classbook.common.ClassbookCodeEnum;
import com.jackie.classbook.common.ClassbookException;
import com.jackie.classbook.dto.BaseReqDTO;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/19
 */
public class AccountUpdateReqDTO extends BaseReqDTO {
    private Long id;                    //用户id
    private String name;                //用户姓名
    private Long nationId;              //民族id
    private Byte sex;                   //性别
    private Integer age;                //年龄
    private Long provinceCode;          //省code
    private Long cityCode;              //城市code
    private Long countryCode;           //县、区code
    private String town;                //镇、街道
    private String village;             //村
    private Long primarySchoolId;       //小学id
    private Long juniorSchoolId;        //初中id
    private Long seniorSchoolId;        //高中id
    private Long universityId;          //大学id
    @Override
    public void validation() {
        if (id == null || id == 0L){
            throw new ClassbookException(ClassbookCodeEnum.ILLGAL_ARGUMENT);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNationId() {
        return nationId;
    }

    public void setNationId(Long nationId) {
        this.nationId = nationId;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public Long getPrimarySchoolId() {
        return primarySchoolId;
    }

    public void setPrimarySchoolId(Long primarySchoolId) {
        this.primarySchoolId = primarySchoolId;
    }

    public Long getJuniorSchoolId() {
        return juniorSchoolId;
    }

    public void setJuniorSchoolId(Long juniorSchoolId) {
        this.juniorSchoolId = juniorSchoolId;
    }

    public Long getSeniorSchoolId() {
        return seniorSchoolId;
    }

    public void setSeniorSchoolId(Long seniorSchoolId) {
        this.seniorSchoolId = seniorSchoolId;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }
}
