package com.example.furniture.response;

import lombok.Data;

@Data
public class ResponseResult {
    private boolean success;
    private int code;
    private String message;
    private Object data;

    public static ResponseResult SUCCESS() {
        return new ResponseResult(ResponseState.SUCCESS);
    }

    public static ResponseResult SUCCESS(String message) {
        ResponseResult responseResult = new ResponseResult(ResponseState.SUCCESS);
        responseResult.setMessage(message);
        return responseResult;
    }

    public static ResponseResult FAILED() {
        return new ResponseResult(ResponseState.FAILED);
    }

    public static ResponseResult FAILED(String message) {
        ResponseResult responseResult = new ResponseResult(ResponseState.FAILED);
        responseResult.setMessage(message);
        return responseResult;
    }

    public static ResponseResult REGISTER_SUCCESS() {
        return new ResponseResult(ResponseState.REGISTER_SUCCESS);
    }

    public static ResponseResult REGISTER_FAILED() {
        return new ResponseResult(ResponseState.REGISTER_FAILED);
    }

    public static ResponseResult LOGIN_SUCCESS() {
        return new ResponseResult(ResponseState.LOGIN_SUCCESS);
    }

    public static ResponseResult GET_RESOURCE_FAILED() {
        return new ResponseResult(ResponseState.GET_RESOURCE_FAILED);
    }

    public static ResponseResult NOT_LOGIN() {
        return new ResponseResult(ResponseState.NOT_LOGIN);
    }

    public static ResponseResult ERROR_403() {
        return new ResponseResult(ResponseState.ERROR_403);
    }

    public static ResponseResult ERROR_404() {
        return new ResponseResult(ResponseState.ERROR_404);
    }

    public static ResponseResult ERROR_504() {
        return new ResponseResult(ResponseState.ERROR_504);
    }

    public static ResponseResult ERROR_505() {
        return new ResponseResult(ResponseState.ERROR_505);
    }

    /**
     * 权限不足，禁止访问
     *
     * @return
     */
    public static ResponseResult PERMISSION_DENIED() {
        return new ResponseResult(ResponseState.PERMISSION_DENIED);
    }

    public static ResponseResult SQL_OPERATION_ERROR() {
        return new ResponseResult(ResponseState.SQL_OPERATION_ERROR);
    }

    public static ResponseResult LOGIN_DISABLE() {
        return new ResponseResult(ResponseState.LOGIN_DISABLE);
    }

    public static ResponseResult WAiTING_FOR_SCAN() {
        return new ResponseResult(ResponseState.WAiTING_FOR_SCAN);
    }

    public static ResponseResult QR_CODE_DEPRECATE() {
        return new ResponseResult(ResponseState.QR_CODE_DEPRECATE);
    }

    public static ResponseResult LOGIN_FAILED() {
        return new ResponseResult(ResponseState.LOGIN_FAILED);
    }

    public ResponseResult(ResponseState responseState) {
        this.success = responseState.isSuccess();
        this.code = responseState.getCode();
        this.message = responseState.getMessage();
    }

    public ResponseResult setData(Object data) {
        this.data = data;
        return this;
    }
}
