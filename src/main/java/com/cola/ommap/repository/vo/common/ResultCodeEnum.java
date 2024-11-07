package com.cola.ommap.repository.vo.base;

import lombok.Getter;

@Getter // getter method
public enum ResultCodeEnum {

    SUCCESS(200 , "success") ,
    LOGIN_ERROR(201 , "user does not exist"),
    PWD_ERROR(2011,"wrong password"),
    VALIDATECODE_ERROR(202 , "wrong validate code") ,
    VALIDATECODE_TIMEOUT(203 , "validate code timeout") ,

    CLASS_ERROR(204 , "class not found"),
    CLASS_REPEAT(205 , "class name already exist"),
    SESSION_ERROR(205 , "session not found"),
    REPORT_TRANSFER_ERROR(206 , "data transfer error"),

    LOGIN_AUTH(208 , "The user is not logged in."),
    USER_NAME_IS_EXISTS(209 , "The username already exists"),
    SYSTEM_ERROR(9999 , "There seems to be a network issue. Please try again later."),
    NODE_ERROR( 217, "This node has child nodes and cannot be deleted."),
    DATA_ERROR(204, "Data error"),
    ACCOUNT_STOP( 216, "The account is inactive."),
    ORDER_ERROR(218,"cannot accept your own order"),

    EXERCISE_LESS( 219, "At least one graded exercise is required to proceed"),
    NOT_FOUND(404,"Not Found"),

    GPT_ERROR(501,"Ai service not available"),


    ;

    private Integer code ;      // business status code
    private String message ;    // response message

    private ResultCodeEnum(Integer code , String message) {
        this.code = code ;
        this.message = message ;
    }

}
