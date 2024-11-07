package com.atguigu.spzx.manager.constant;

public interface Information {
    String getText();



    default int getCode(){
        return -1;
    }

    default public String getEnText() {return  "";}

    default public String getRatioLabel() {return  "";}
}
