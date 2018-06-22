package com.jackie.classbook.dto.request;

import com.jackie.classbook.common.ClassbookCodeEnum;
import com.jackie.classbook.common.ClassbookException;
import com.jackie.classbook.common.SchoolTypeEnum;
import com.jackie.classbook.dto.BaseReqDTO;
import org.springframework.util.StringUtils;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/21
 */
public class SchoolAddReqDTO extends BaseReqDTO {
    private String schoolName;      //校名
    private Integer type;           //学校类型，1-小学 2-初中 3-高中 4-大学
    private Long provinceCode;      //学校所在省code
    private Long cityCode;          //学校所在市code
    private Long countryCode;       //学校所在县、区code
    private String schoolMotto;     //校训

    @Override
    public void validation() {
        if (StringUtils.isEmpty(schoolName) || type < SchoolTypeEnum.PRIMARTSCHOOL.getKey()){
            throw new ClassbookException(ClassbookCodeEnum.ILLGAL_ARGUMENT);
        }
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public String getSchoolMotto() {
        return schoolMotto;
    }

    public void setSchoolMotto(String schoolMotto) {
        this.schoolMotto = schoolMotto;
    }
}
