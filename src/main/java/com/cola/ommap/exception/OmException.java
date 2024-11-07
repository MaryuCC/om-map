package com.cola.ommap.exception;



import com.cola.ommap.repository.vo.common.ResultCodeEnum;
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
