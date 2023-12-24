package com.example.vo;

import lombok.Data;

//企业开发中定义的所有请求返回的固定格式
@Data //lombok 直接帮忙生成所有的get和set方法
public class ResponseResult {

    private Integer code;//操作的状态码
    private String message;//操作的信息
    private Object data;//数据

    public ResponseResult() {
    }

    public ResponseResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResponseResult okResult(Object data){
        return new ResponseResult(200,"success",data);
    }
}
