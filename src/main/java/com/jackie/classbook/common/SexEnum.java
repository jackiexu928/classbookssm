package com.jackie.classbook.common;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/12/4
 */
public enum  SexEnum {
    MALE((byte)1, "男"), FEMALE((byte)0, "女");

    private byte key;
    private String value;

    SexEnum(byte key, String value){
        this.key = key;
        this.value = value;
    }

    public byte getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static String getValue(byte key){
        if (MALE.getKey() == key){
            return MALE.getValue();
        }else if (FEMALE.getKey() == key){
            return FEMALE.getValue();
        }else {
            return "不明";
        }
    }
}
