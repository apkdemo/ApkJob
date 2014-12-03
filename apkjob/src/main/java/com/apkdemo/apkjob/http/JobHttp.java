package com.apkdemo.apkjob.http;

import android.app.ProgressDialog;
import android.content.Context;

import com.apkdemo.apkjob.JobApplication;
import com.apkdemo.apkjob.JobConstants;
import com.apkdemo.apkjob.util.LogUtil;
import com.apkdemo.apkjob.util.StringUtil;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

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
public class JobHttp extends AsyncHttpResponseHandler implements JobConstants {

    private Context context;                            //上下文
    private JobApplication app;                        //Application 对象
    private JobHttpDateTranslator dateTranslator;     //Json解析器
    private JobHttpCallback jobHttpCallback;         //请求回调，在UI线程
    private ProgressDialog dialog;                  //所有请求弹出的对话框
    private int requestID;                         //请求ID
    private String dialogStr;                     //对话框显示文案


    /**
     * 构造方法
     *
     * @param context         上下文ob
     * @param requestID       请求ID
     * @param jobHttpCallback 请求回调
     * @param dateTranslator  解析器
     */
    public JobHttp(Context context, int requestID, JobHttpCallback jobHttpCallback, JobHttpDateTranslator dateTranslator) {
        super();
        this.requestID = requestID;
        this.context = context;
        this.jobHttpCallback = jobHttpCallback;
        this.app = JobApplication.getInstance();
        this.dateTranslator = dateTranslator;
    }

    /**
     * 请求开始之前调用
     */
    @Override
    public void onStart() {
    }

    /**
     * 请求成功时调用（HTTP 状态 返回200 才算成功）
     *
     * @param statusCode 响应的状态码
     * @param headers    返回请求头
     * @param response   HTTP响应主体
     */
    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] response) {
        String json = byteToString(response);        //转换成字符串
        Object obj = null;                          //解析成对象

        LogUtil.set("id=" + requestID + "====" + StringUtil.getStringToUTF8(response));//打印输出

        try {
            obj = this.dateTranslator.dataTranslator(requestID, json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        jobHttpCallback.onRequest(requestID, obj);
    }


    /**
     * 请求失败时调用（比如返回：eg. 401, 403, 404...... 4xx等）
     *
     * @param statusCode    响应的状态码
     * @param headers       返回请求头
     * @param errorResponse HTTP响应主体
     * @param e
     */
    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
        if (399 < statusCode && statusCode < 500) {// 请求无响应拒绝等
            //这里可以自定义
        } else if (500 <= statusCode && statusCode < 600) {// 服务器出错出现异常
            //这里可以自定义
        } else {// 其它异常
            //这里可以自定义
        }

        LogUtil.set(statusCode+"");

        jobHttpCallback.onFailure(requestID, statusCode, e);
    }

    /**
     * 请求重试时调用
     *
     * @param retryNo 重试次数
     */
    @Override
    public void onRetry(int retryNo) {
    }

    /**
     * 请求取消时调用
     */
    @Override
    public void onCancel() {
    }

    /**
     * 请求结束时调用（不管成功失败）
     */
    @Override
    public void onFinish() {
    }

    /**
     * 请求进度（显示请求的进度，比如下载文件）
     *
     * @param bytesWritten 当前
     * @param totalSize    总大小
     */
    @Override
    public void onProgress(int bytesWritten, int totalSize) {

    }

    /**
     * byte转换成String
     *
     * @param response
     * @return
     */
    public String byteToString(byte[] response) {
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
