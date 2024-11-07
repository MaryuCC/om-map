package com.cola.ommap.repository.vo.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "response result entity class")
public class Result<T> {

    //return code
    @Schema(description = "business status code")
    private Integer code;

    //return message
    @Schema(description = "response message")
    private String message;

    //return data
    @Schema(description = "business data")
    private T data;

    // private construction
    private Result() {}

    // return data
    public static <T> Result<T> build(T body, Integer code, String message) {
        Result<T> result = new Result<>();
        result.setData(body);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    // construct Result object by enum
    public static <T> Result build(T body , ResultCodeEnum resultCodeEnum) {
        return build(body , resultCodeEnum.getCode() , resultCodeEnum.getMessage()) ;
    }

}
