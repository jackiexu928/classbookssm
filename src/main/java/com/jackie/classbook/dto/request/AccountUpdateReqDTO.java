package com.jackie.classbook.dto.request;

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
    private Long mobile;                //手机号
    private String email;               //邮箱
    private String nationId;            //民族id
    private Byte sex;                   //性别
    private Integer age;                //年龄
    private String province;            //省
    private String city;                //城市
    private String country;             //县、区
    private String town;                //镇、街道
    private String village;             //村
    private Long primarySchoolId;       //小学id
    private Long juniorSchoolId;        //初中id
    private Long seniorSchoolId;        //高中id
    private Long universityId;          //大学id
    @Override
    public void validation() {

    }
}
