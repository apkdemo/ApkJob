package com.apkdemo.apkjob;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;

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
public class JobApplication extends Application {
    public static JobApplication instance;                              // 实例化一个Application
    private static ArrayList<Activity> activitystack;                  // activity启动栈，记录栈中的activity实例

    @Override
    public void onCreate() {
        instance = this;
    }

    @Override
    public void onTerminate() {
        // 程序安全退出
        for (Activity activity : activitystack) {
            activity.finish();
        }
        activitystack.clear();
        super.onTerminate();
    }

    /**
     * 单例模式
     * 获取APP对象
     * @return instance 返回自己Application对象
     */
    public static JobApplication getInstance() {
        return instance;
    }


    /**
     * 将应用程序的任务栈中的一activity实例添加到activitystack中
     * @param activity 一个activity实例
     */
    public static void addActivityFromStack(Activity activity) {
        instance.activitystack.add(activity);
    }

    /**
     * 将应用程序的任务栈中的一activity实例移除
     *
     * @param activity 一个activity实例
     */
    public static void removeActivityFromStack(Activity activity) {
        instance.activitystack.remove(activity);
    }

}
