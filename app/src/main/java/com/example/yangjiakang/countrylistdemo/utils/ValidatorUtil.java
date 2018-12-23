package com.example.yangjiakang.countrylistdemo.utils;

import android.text.TextUtils;

import java.util.regex.Pattern;

/**
 * Created by yangjiakang on 2018/12/2.
 */

public class ValidatorUtil {

    public static final Pattern EMAIL = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[\\w-]+(\\.[\\w-]+)+$");

    public ValidatorUtil() {
    }

    public static boolean isEmail(String str) {
        return TextUtils.isEmpty(str)?false:check(str, EMAIL);
    }

    public static boolean check(String str, Pattern regex) {
        boolean flag = false;

        try {
            flag = regex.matcher(str).matches();
        } catch (Exception var4) {
            ;
        }

        return flag;
    }
}
