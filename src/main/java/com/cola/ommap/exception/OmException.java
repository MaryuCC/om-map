package com.cola.omlink.common.exception;


import com.cola.omlink.repository.vo.common.ResultCodeEnum;
import lombok.Data;

@Data
public class OmException extends RuntimeException{

    private Integer code;
    private String message;
    private ResultCodeEnum resultCodeEnum;

    public OmException(ResultCodeEnum resultCodeEnum){
        this.resultCodeEnum = resultCodeEnum;
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }


}
