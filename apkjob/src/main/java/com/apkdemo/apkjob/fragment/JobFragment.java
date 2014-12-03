package com.apkdemo.apkjob.fragment;

import android.app.Fragment;
import android.view.View;

import com.apkdemo.apkjob.JobConstants;
import com.apkdemo.apkjob.http.JobHttpCallback;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

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
@EFragment
public abstract class JobFragment extends Fragment implements JobHttpCallback, JobConstants {


    /**
     * View初始化之前自动运行
     */
    @AfterInject
    abstract void iniViewsOne();

    /**
     * View初始化之后自动运行
     */
    @AfterViews
    abstract void iniViewsTow();

    /**
     * 处理当前界面所有的点击监听
     *
     * @param view
     */
    abstract void onClick(View view);

    /**
     * @param requestId  请求ID（需要在Constants.java中自定义一个常量）
     * @param result     Json解析完返回的对象
     */
    @Override
    public abstract void onRequest(int requestId, Object result);

}
