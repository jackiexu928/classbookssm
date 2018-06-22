package com.jackie.classbook.common;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author liuxl
 * @date 2018/6/21
 */
public enum RoleEnum {
    ADMINER(1, "管理员"), CONSUMER(2, "普通用户");

    private int key;
    private String value;

    RoleEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getKey() {
        return key;
    }
}
