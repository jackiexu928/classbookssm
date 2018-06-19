package com.jackie.classbook.dto.response;

import com.jackie.classbook.dto.BaseRespDTO;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/5/31
 */
public class AccountRespDTO extends BaseRespDTO {
    private Long id;                    //用户id
    private String name;                //用户姓名
    private Long roleId;                //权限id
    private Long mobile;                //手机号
    private String email;               //邮箱
    private String password;            //登录密码
    private String nation;              //民族
    private Byte sex;                   //性别
    private Integer age;                //年龄
    private String province;            //省
    private String city;                //城市
    private String town;                //镇、街道
    private String village;             //村
    private Long primarySchoolId;       //小学id
    private String primarySchoolName;   //小学校名
    private Long juniorSchoolId;        //初中id
    private String juniorSchoolName;    //初中校名
    private Long seniorSchoolId;        //高中id
    private String seniorSchoolName;    //高中校名
    private Long universityId;          //大学id
    private String universityName;      //大学校名
    private String validFlag;           //标志位
    private String token;               //口令

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

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

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

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
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

    public String getPrimarySchoolName() {
        return primarySchoolName;
    }

    public void setPrimarySchoolName(String primarySchoolName) {
        this.primarySchoolName = primarySchoolName;
    }

    public Long getJuniorSchoolId() {
        return juniorSchoolId;
    }

    public void setJuniorSchoolId(Long juniorSchoolId) {
        this.juniorSchoolId = juniorSchoolId;
    }

    public String getJuniorSchoolName() {
        return juniorSchoolName;
    }

    public void setJuniorSchoolName(String juniorSchoolName) {
        this.juniorSchoolName = juniorSchoolName;
    }

    public Long getSeniorSchoolId() {
        return seniorSchoolId;
    }

    public void setSeniorSchoolId(Long seniorSchoolId) {
        this.seniorSchoolId = seniorSchoolId;
    }

    public String getSeniorSchoolName() {
        return seniorSchoolName;
    }

    public void setSeniorSchoolName(String seniorSchoolName) {
        this.seniorSchoolName = seniorSchoolName;
    }

    public Long getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
