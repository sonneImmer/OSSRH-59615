package com.ustb.util;

/**
 * Created by admin on 2018/7/11 0011.
 */
public enum ChainType {
    SUBJECT(0),
    OBJECT(1);

    private int value;

    ChainType(int value) {
        this.value = value;
    }
    public static ChainType getChainType(String type){
        switch (type){
            case "0":return SUBJECT;
            case "1":return OBJECT;
            default:return null;
        }
    }
    public static ChainType getChainType(Integer type){
        switch (type){
            case 0:return SUBJECT;
            case 1:return OBJECT;
            default:return null;
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
