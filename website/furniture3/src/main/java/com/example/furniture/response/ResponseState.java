package com.example.furniture.response;


public enum ResponseState {

    /*
     * 1000系列表示成功
     * 2000系列表示失败
     * */
    SUCCESS(true, 1000, "请求成功！"),
    LOGIN_SUCCESS(true, 1010, "欢迎使用墨风博客！"),
    REGISTER_SUCCESS(true, 1020, "注册成功！"),
    FAILED(false, 2000, "请求失败，请重试。"),
    LOGIN_DISABLE(false, 2011, "该用户已被管理员禁用，详情请联系管理员。"),
    NOT_LOGIN(false, 2012, "未登录，请登录后重试。"),
    PERMISSION_DENIED(false, 2030, "权限不足，禁止访问。"),
    REGISTER_FAILED(false, 2020, "注册失败，请重试。"),
    GET_RESOURCE_FAILED(false, 2031, "获取资源失败，请重试。"),
    SQL_OPERATION_ERROR(false, 2040, "操作失败！请重试，或者联系管理员。"),
    WAiTING_FOR_SCAN(false, 2008, "等待扫描"),
    QR_CODE_DEPRECATE(false, 2009, "二维码已过期"),
    LOGIN_FAILED(false, 29999, "登录失败"),

    //错误码系列
    ERROR_403(false, 403, "权限不足，禁止访问"),
    ERROR_404(false, 404, "页面丢失！"),
    ERROR_504(false, 504, "系统繁忙，请稍后重试！"),
    ERROR_505(false, 505, "请求错误，请检查所提交数据");

    private boolean success;
    private int code;
    private String message;

    ResponseState(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
