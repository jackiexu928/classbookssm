package com.jackie.classbook.common;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author xujj
 * @date 2018/6/21
 */
public enum SchoolTypeEnum {
    PRIMARTSCHOOL(1, "小学"), JUNIORSCHOOL(2, "初中"), SENIORSCHOOL(3, "高中"), UNIVERSITY(4, "大学");

    private int key;
    private String value;

    SchoolTypeEnum(int key, String value) {
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
        if (PRIMARTSCHOOL.getKey() == key){
            return PRIMARTSCHOOL.getValue();
        }else if (JUNIORSCHOOL.getKey() == key){
            return JUNIORSCHOOL.getValue();
        }else if (SENIORSCHOOL.getKey() == key){
            return SENIORSCHOOL.getValue();
        }else if (UNIVERSITY.getKey() == key){
            return UNIVERSITY.getValue();
        }else {
            return "其他";
        }
    }

    public static int getKey(String value){
        if (PRIMARTSCHOOL.getValue().equals(value)){
            return PRIMARTSCHOOL.getKey();
        }else if (JUNIORSCHOOL.getValue().equals(value)){
            return JUNIORSCHOOL.getKey();
        }else if (SENIORSCHOOL.getValue().equals(value)){
            return SENIORSCHOOL.getKey();
        }else if (UNIVERSITY.getValue().equals(value)){
            return UNIVERSITY.getKey();
        }else {
            return 5;
        }
    }
}
