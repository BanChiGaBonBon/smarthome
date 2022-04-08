package com.example.furniture.utils;

import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class TextUtils {

    public static String regEx = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    public static boolean isEmpty(String text) {
        return text == null || text.length() == 0;
    }

    public static boolean isEmailAddresOk(String emailAddress) {
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(emailAddress);
        return m.matches();
    }

    public static String getDomain(HttpServletRequest request) {
        String servletPath = request.getServletPath();
        StringBuffer requestURL = request.getRequestURL();
        String originalDomain = requestURL.toString().replace(servletPath, "");
        return originalDomain;
    }


}
