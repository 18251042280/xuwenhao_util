package com.bawei.xuwenhao_util;


/**
 * Created by Android Studio.
 * User: 小徐
 * Date: 2021/11/10
 * Time: 10:53
 */
public class StringUtils {
    //判断字符串
    public static boolean isEmpty(String string){
        if (string.trim().equals("")||null==string){
            return true;
        }
        return false;
    }
}