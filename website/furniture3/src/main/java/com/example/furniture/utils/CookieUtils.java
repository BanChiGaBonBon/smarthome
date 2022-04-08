package com.example.furniture.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
    private static final String domain = "localhost";
    private static final int defaule_age = 259200000;//30天

    /**
     * 设置Cookie值
     *
     * @param response
     * @param key
     * @param value
     */
    public static void setCookie(HttpServletResponse response, String key, String value) {
        setCookie(response, key, value, defaule_age);
    }

    public static void setCookie(HttpServletResponse response, String key, String value, int age) {
        Cookie cookie = new Cookie(key, value);
        cookie.setPath("/");
        cookie.setMaxAge(age);
        cookie.setDomain(domain);//默认返回当前服务器的ip
        response.addCookie(cookie);
    }

    /**
     * 删除Cookie值
     *
     * @param response
     * @param cookieKey
     */
    public static void deleteCookie(HttpServletResponse response, String cookieKey) {
        setCookie(response, cookieKey, null, 0);
    }

    /**
     * 获取Cookie值
     *
     * @param request
     * @param cookieKey
     * @return 对应的tokenKey值
     */
    public static String getCookie(HttpServletRequest request, String cookieKey) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookieKey.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
