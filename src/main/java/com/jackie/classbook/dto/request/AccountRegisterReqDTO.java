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
public class AccountRegisterReqDTO extends BaseReqDTO {

    private String name;                //用户姓名
//    private Long roleId;                //权限id，1-管理员，2-普通用户  //xxx 默认为2
    private Long mobile;                //手机号
    private String email;               //邮箱
    private String password;            //登录密码
    private Long nationId;              //民族id  //xxx 查表
    private Byte sex;                   //性别
    private Integer age;                //年龄
    private Long provinceCode;          //省编码
    private Long cityCode;              //城市编码
    private Long countryCode;           //县、区编码
    private String town;                //镇、街道
    private String village;             //村
    private Long primarySchoolId;       //小学id    //xxx 学校名查表获得
    private Long juniorSchoolId;        //初中id
    private Long seniorSchoolId;        //高中id
    private Long universityId;          //大学id

    @Override
    public void validation() {
        /*if (roleId == null || roleId.equals("")){
            throw new ClassbookException(ClassbookCodeEnum.PARAM_ISNULL);
        }*/
        if ((mobile == null || mobile.equals("")) && (email == null || email.equals(""))){
            throw new ClassbookException(ClassbookCodeEnum.PARAM_ISNULL);
        }
        if (password == null || password.equals("")){
            throw new ClassbookException(ClassbookCodeEnum.PARAM_ISNULL);
        }
        if (String.valueOf(mobile).length() != 11){
            throw new ClassbookException(ClassbookCodeEnum.ILLGAL_MOBILE);
        }
        if (!email.contains("@")){
            throw new ClassbookException(ClassbookCodeEnum.ILLGAL_EMAIL);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }*/

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
