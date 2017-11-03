package com.hxg.girl.exception;


import com.hxg.girl.enums.ResultEnum;

public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();

        this.printStackTrace();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
