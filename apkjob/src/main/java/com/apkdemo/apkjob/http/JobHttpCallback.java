package com.apkdemo.apkjob.http;

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
 * Http请求回调接口（这个回调根据请求ID解析Json后返回的对象）
 * Http异步请求后调用，用于UI线程调用解析后的对象。
 */
public interface JobHttpCallback {
    /**
     * Http异步请求成功后调用
     * @param requestId  请求ID（需要在Constants.java中自定义一个常量）
     * @param result     Json解析完返回的对象
     */
    void onRequest(int requestId, Object result);

    /**
     * Http异步请求成功，但服务器返回失败时调用
     * @param requestId  请求ID（需要在Constants.java中自定义一个常量）
     * @param statusCode 请求成功，服务器却返回失败状态码
     * @param e          异常对象
     */
    void onFailure(int requestId, int statusCode, Throwable e);
}
