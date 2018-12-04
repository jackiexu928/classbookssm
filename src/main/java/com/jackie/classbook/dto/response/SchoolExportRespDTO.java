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
public class SchoolExportRespDTO extends BaseRespDTO {
    private Integer serialNum;  //序号
    private String schoolName;  //校名
    private String type;        //类型
    private String province;    //学校所在省
    private String city;        //学校所在城市
    private String country;     //县、区
    private String schoolMotto; //校训

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getSchoolMotto() {
        return schoolMotto;
    }

    public void setSchoolMotto(String schoolMotto) {
        this.schoolMotto = schoolMotto;
    }

    @Override
    public String toString() {
        return serialNum +
                "," + (schoolName == null ? "-" : schoolName) +
                "," + (type == null ? "-" : type) +
                "," + (StringUtils.isEmpty(province) ? "-" : province) +
                "," + (StringUtils.isEmpty(city) ? "-" : city) +
                "," + (StringUtils.isEmpty(country) ? "-" : country) +
                "," + (StringUtils.isEmpty(schoolMotto) ? "-" : schoolMotto);
    }
}
