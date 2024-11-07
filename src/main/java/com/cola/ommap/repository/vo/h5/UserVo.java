package com.cola.omlink.repository.vo.h5;

import com.cola.omlink.repository.vo.common.RolesEnum;
import lombok.Data;

@Data
public class UserVo {

    private String nickName;

    private RolesEnum role;
}
