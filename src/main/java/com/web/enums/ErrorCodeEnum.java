package com.web.enums;

/**
 * @Date Created on 2017/3/23.
 * @Author SongJiuHua.
 * @description
 */
public enum ErrorCodeEnum {

    NO_PRIVILEGE(100, "无权限");

    private Integer code;

    private String name;

    ErrorCodeEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
