package com.jackie.classbook.common;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuxl
 * @date 2018/6/28
 */
public enum TeacherTypeEnum {
    CLASSTEACHER(1, "班主任"),SUBJECTSTEACHER(2, "任课老师");

    private int key;
    private String value;

    TeacherTypeEnum(int key, String value) {
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
        if (CLASSTEACHER.getKey() == key){
            return CLASSTEACHER.getValue();
        }else if (SUBJECTSTEACHER.getKey() == key){
            return SUBJECTSTEACHER.getValue();
        }else {
            return "其他";
        }
    }

    public static int getKey(String value){
        if (CLASSTEACHER.getValue().equals(value)){
            return CLASSTEACHER.getKey();
        }else if (SUBJECTSTEACHER.getValue().equals(value)){
            return SUBJECTSTEACHER.getKey();
        }else {
            return 3;
        }
    }
}
