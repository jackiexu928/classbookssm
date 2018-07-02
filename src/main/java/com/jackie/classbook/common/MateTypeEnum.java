package com.jackie.classbook.common;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuxl
 * @date 2018/7/2
 */
public enum MateTypeEnum {
    DESKMATE(1, "同桌"),ROOMMATE(2, "室友");

    private int key;
    private String value;

    MateTypeEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getKey() {
        return key;
    }

    public static String getValue(int key){
        if (DESKMATE.getKey() == key){
            return DESKMATE.getValue();
        }else if (ROOMMATE.getKey() == key){
            return ROOMMATE.getValue();
        }else {
            return "其他";
        }
    }

    public static int getKey(String value){
        if (DESKMATE.getValue().equals(value)){
            return DESKMATE.getKey();
        }else if (ROOMMATE.getValue().equals(value)){
            return ROOMMATE.getKey();
        }else {
            return 3;
        }
    }
}
