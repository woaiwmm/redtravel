package com.mushroom.redtravel.result;


/**
 * 状态码和信息的封装
 * @author Administrator
 * @date 2019-12-27 16:04
 */
public class CodeMsg {
    private int code;
    private String msg;

    public CodeMsg(int code, String msg) {
        this.code=code;
        this.msg=msg;
    }



    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
