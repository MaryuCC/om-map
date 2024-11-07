package com.example.teachplatform.utils;


import com.example.teachplatform.repository.entity.User;

public class AuthContextUtil {
    private static final ThreadLocal<User> userInfoThreadLocal = new ThreadLocal<>() ;


    // 定义存储数据的静态方法
    public static void setUserInfo(User user) {
        userInfoThreadLocal.set(user);
    }

    // 定义获取数据的方法
    public static User getUserInfo() {
        return userInfoThreadLocal.get() ;
    }

    // 删除数据的方法
    public static void removeUserInfo() {
        userInfoThreadLocal.remove();
    }
}
