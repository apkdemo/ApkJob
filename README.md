# ApkJob 安卓集成架构开发框架

![ApkJob icon](http://apkdemo.com/wp-content/uploads/2014/11/cropped-75_7511-06-20-28-07.png)

## 简介
*** 
> ApkJob 一个轻松实现android架构的集成框架，主要定位快速、规范和后期维护  ——  来自于[@ApkDemo](http://apkdemo.com)


## 为什么使用ApkJob？
***
程序猿能够快速的创建复杂的初始化架构。

* ApkJob诞生于巨人的肩膀上。

* ApkJob配置好了复杂的配置文件。

* ApkJob下载后改个包名就是一个企业级app框架。

* ApkJob拥有一个4年Android开发者收集的工具库整理，再也不怕没积分找工具了

* ApkJob规范了Http异步请求写法，虽然比匿名类麻烦，但是后期维护相当有序、简单、不乱。

* ApkJob中采用了模板设计模式，结构清晰、易理解，开发者在写代码中只需照着葫芦画瓢。

* ApkJob采用封装的方式将多种第三方类库融合，并且使用一条线串联在一起使用。

* ApkJob是[@ApkDemo](http://apkdemo.com)站长 开发必用，即便是在企业级APP开放上也没问题。

* ApkJob开发过天翼彩票、彩票大赢家、摇摇招车打车软件、隐私保险箱、蓝牙spp对接单片机传输等多种大中小型应用
* ApkJob将来还要更多...

## 核心类库表
*** 

类库名称 			|    类库地址 	 | 说明
:----------- 	| :----------- | :-----------
 AA 			| `compile 'org.androidannotations:androidannotations:3.2+'`  | AA框架
AA-api 			| `compile 'org.androidannotations:androidannotations-api:3.2+'` | AA框架依赖
async-http 	| `compile 'com.loopj.android:android-async-http:1.4.5+'` | Http异步请求
fastjson| ` compile 'com.alibaba:fastjson:+'    ` | Json解析类库

## 导入方法
*** 

* 下载ApkJob，找个地方永存
* 打开AndroidStudio1.0RC2 (最新稳定版)
* 选择第二项 Open an existing Android Studio Porject
* 在ApkJob上创作属于你的App

## Http异步请求封装使用
*** 
####第一步，建立请求ID “DEMOAPI_ID”：

**在继承JobConstants的类中创建ID常量：**
`public final static int DEMOAPI_ID = 100003;//获取北京天气`
####第二步，使用“DEMOAPI_ID”发送请求：
```
AsyncHttpClient client = new AsyncHttpClient();  //创建请求对象
RequestParams params = new RequestParams();	     //创建请求参数对象
params.put("key", "value");						 //加入参数
params.put("more", "data");
client.get(DEMOAPI, params, new JobHttp("请稍候...", getActivity(), DEMOAPI_ID, this));

//“请稍候”参数可以填，不填则不显示通用等待框。
//DEMOAPI 为请求连接。
//this为回调，每个activity都有继承JobHttpCallBack基类，在UI类实现了onRequest 回调方法。
```

####第三步，实现JobHttpDateTranslator.java解析器中dataTranslator解析方法：
```
public Object dataTranslator(int id,String json) {
…
	case DEMOAPI_ID:	 //测试接口
	return parsDemo(json);
…
}
private Object parsDemo(String json) {
	Object mDemoApi = JSON.parseObject(json, DemoApi.class);//这里使用了fastjson来解析。
	return mDemoApi;
}
```
####第四步，对象自动返回UI层，找到发送请求的Activity onRequest()方法处理解析后的对象：
```
 @Override
    public void onRequest(int requestId, Object result) {//result属性参数为Json解析后出过来的对象
        switch (requestId) {
            case DEMOAPI_ID://根据ID处理不同的对象
                DemoApi demo = (DemoApi) result;
                LogUtil.e(demo.getWeatherinfo().getCity());
                return;
        }
}
```

## 更新记录
*** 
2014年12月3日 ApkJob1.0诞生

