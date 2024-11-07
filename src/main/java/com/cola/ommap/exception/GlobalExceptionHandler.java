package com.cola.omlink.common.exception;

import com.cola.omlink.repository.vo.common.Result;
import com.cola.omlink.repository.vo.common.ResultCodeEnum;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    //全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        e.printStackTrace();
        return Result.build(null, ResultCodeEnum.SYSTEM_ERROR);
    }

    //自定义异常处理
    @ExceptionHandler(OmException.class)
    @ResponseBody
    public Result error(OmException e){
        return Result.build(null, e.getResultCodeEnum());
    }




}
