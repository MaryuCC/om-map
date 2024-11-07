package com.cola.omlink.repository.vo.common;

import lombok.Getter;

@Getter
public enum RolesEnum {
    USER(0),
    ADMIN(1);

    private final int code;

    RolesEnum(int code) {
        this.code = code;
    }

    public static RolesEnum fromValue(int code) {
        for (RolesEnum role : RolesEnum.values()) {
            if (role.getCode() == code) {
                return role;
            }
        }
        return RolesEnum.USER;
    }
}
