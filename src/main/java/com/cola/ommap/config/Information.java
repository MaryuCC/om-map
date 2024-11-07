package com.cola.ommap.config;

public interface Information {
    String getText();

    default int getCode(){
        return -1;
    }


}
