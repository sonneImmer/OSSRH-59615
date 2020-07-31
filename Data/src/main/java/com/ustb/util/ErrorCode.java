package com.ustb.util;

/**
 * Created by admin on 2018/7/4 0004.
 */
public enum ErrorCode {
    //编号命名规则，异常以字母序进行排序，除了NO_ERROR之外，普通业务异常以4开头
    //系统异常以5开头，中间两位为首字母序号，最后两位为该首字母开头的异常序号
    No_ERROR("000","no error"),
    ADMIN_USER_NOT_FOUND("40101","admin_user_not_found"),
    CHAIN_ALREAD_EXSIT("40302","chain already exsit"),
    CHAIN_CONNECT_FAILED("40303","server connect failed"),
    CHAIN_NOT_EXSIT("40304","chain not exsit"),
    CHAIN_HAS_MORE_MAINNODES("40305","a chain can only have one main node"),
    FREQUENT_REQUEST("40601","too frequent requests"),
    MAIN_NODE_ERROR("41301","can't delete main node"),
    NO_APP_ID("41401","no such appid"),
    NOTHING_CHANGED("41402","nothing changed"),
    NODE_GRANT_FAILED("41403","grant node failed"),
    OBJECT_ALREADY_EXSIT("41501","object hash already exsit in blockchain"),
    OBJECT_NOT_FOUND("41502","object not found"),
    OBJECT_UPDATE_FAILED("41503","object update failed"),
    RELATION_ALREADY_ESTABLISHED("41801","relationship has been established"),
    SAME_NODE_TYPE("41901","already exist node with same type"),
    SELECT_ENTITY_FALURE("41902","select entity failure"),
    TIMESTAMP_EXPIRE("42001","timestamp expired"),
    TOKEN_CHECK_FAILED("42002","token is not correspond to server's"),
    TOKEN_GEN_FAILED("42003","check value is not correct"),
    TOKEN_NOT_EXSIT("42004","token is not exist"),
    TOKEN_TIME_OUT("42005","token is expired"),
    TORT_OBJECT_NOT_FOUND("42006","tort object not found"),
    TRANSACTION_NOT_FOUND("42007","transaction not found"),
    USER_ALREADY_EXSIT("42101","user already exsit in blockchain"),
    USER_NOT_FOUND("42102","user not found"),

    CALLING_PARAMS_INVALID("50301","method params are invalid"),
    CALLING_PARAMS_MISMATCH("50302","method params is mismatched"),
    REDIS_SERVER_ERROR("51801","redis server connect failed"),
    SERVER_INTERNAL_ERROR("51901","server internal error"),
    UNKNOW_ERROR("52101","unknown error");


    private String value;
    private String desc;

    ErrorCode(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
