package com.apkdemo.apkjob.util;


import android.util.Log;

import com.apkdemo.apkjob.JobConstants;

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
 * 负责打日志
 */
public class LogUtil {

    /**
     * 检查是否开启了DeBug模式
     * @return Boolean
     */
    public static boolean isDEBUG() {
        return JobConstants.DEBUG;
    }

    /**
     * 直接输出打印Log(我这里用错误模式 e ，因为是红色比较看得清晰)
     * @param msg 文本内容
     */
    public static void set(String msg) {
        if (JobConstants.DEBUG) {
            LogUtil.e(JobConstants.LOG_TAG, msg);
        }
    }

    /**
     * 输出信息Log
     * @param msg 文本内容
     */
    public static void i(String msg) {
        if (JobConstants.DEBUG) {
            Log.i(JobConstants.LOG_TAG, msg);
        }
    }

    /**
     * 输出信息Log
     * @param tag 筛选标记
     * @param msg 文本内容
     */
    public static void i(String tag, String msg) {
        if (JobConstants.DEBUG) {
            Log.i(tag, msg);
        }
    }

    /**
     * 输出信息Log
     * @param msg 文本内容
     */
    public static void v(String msg) {
        if (JobConstants.DEBUG) {
            Log.v(JobConstants.LOG_TAG, msg);
        }
    }

    /**
     * 输出信息Log
     * @param tag 筛选标记
     * @param msg 文本内容
     */
    public static void v(String tag, String msg) {
        if (JobConstants.DEBUG) {
            Log.v(tag, msg);
        }
    }

    /**
     * 输出信息Log
     * @param tag 筛选标记
     * @param msg 文本内容
     * @param tr  异常对象
     */
    public static void v(String tag, String msg, Throwable tr) {
        if (JobConstants.DEBUG) {
            Log.e(tag, msg, tr);
        }
    }

    /**
     * 输出信息Log
     * @param msg 文本内容
     */
    public static void e(String msg) {
        if (JobConstants.DEBUG) {
            Log.e(JobConstants.LOG_TAG, msg);
        }
    }

    /**
     * 输出信息Log
     * @param tag 筛选标记
     * @param msg 文本内容
     */
    public static void e(String tag, String msg) {
        if (JobConstants.DEBUG) {
            Log.e(tag, msg);
        }
    }

    /**
     * 输出信息Log
     * @param tag 筛选标记
     * @param msg 文本内容
     * @param tr  异常对象
     */
    public static void e(String tag, String msg, Throwable tr) {
        if (JobConstants.DEBUG) {
            Log.e(tag, msg, tr);
        }
    }


}
