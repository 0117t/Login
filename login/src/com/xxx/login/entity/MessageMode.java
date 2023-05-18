package com.xxx.login.entity;

/**
 * 消息模型对象（数据响应）
 *  状态码
 *      1=成功，0=失败
 *  提示信息
 *      字符串
 *  回显数据
 *      object对象
 */
public class MessageMode {
    private Integer code = 1;  //状态码  1=成功，0=失败
    private String msg = "成功！";  //提示信息
    private Object object;   //回显数据

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "MessageMode{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", object=" + object +
                '}';
    }
}
