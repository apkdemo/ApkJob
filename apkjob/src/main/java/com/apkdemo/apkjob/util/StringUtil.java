package com.apkdemo.apkjob.util;

import java.io.UnsupportedEncodingException;

/**
 * English Notice：
 * Welcome to the code in the world , if you want to modify ApkJob code , then I guess you have a better idea of the ~
 * Then go ApkDemo official (http://apkdemo.com/) talk about your ideas , tens of thousands of programmers will benefit oh ~
 * ------------------------------------------------------------------------------------------------------------------------------
 * 中文须知：
 * 欢迎来到代码世界，如果你想修改ApkJob的代码，那我猜你是有更好的主意了～
 * 那么请到ApkDemo官方（ http://apkdemo.com/ ）说说你的想法，数以万计的程序员会因此受益哦～
 * 同时，你的名字将出现在ApkDemo贡献者名单中，并有一定的积分奖励～
 * 注释和代码同样重要～
 *
 * @author ApkDemo @email admin@apkdemo.com
 *         Created by ApkDemo on 14/12/3.
 */

/**
 * 字符串工具类
 */
public class StringUtil {

    /**
     * 转换编码为UTF-8
     * @param response
     * @return
     */
    public static String getStringToUTF8(byte[] response) {
        String isoString = "";
        try {
            if (response != null) {
                isoString = new String(response, "UTF8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return isoString;
    }
}
