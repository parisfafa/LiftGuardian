package com.dahua.openapi.main;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.dahua.openapi.business.DeviceManager;
import com.dahua.openapi.business.impl.DeviceManageImpl;
import com.dahua.openapi.business.impl.UserManagerImpl;
import com.dahua.openapi.util.CONST;

public class TestMain {

    public static void main(String[] args)
    {

        // 注：执行main函数前请先将CONST.java文件中的APPID、SECRET以及PHONE填全，不然程序执行将会报错。

        // 获取管理员token
        UserManagerImpl userManager = new UserManagerImpl();
        HashMap<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("phone", CONST.PHONE);// 管理员账号
        JSONObject json = userManager.accessToken(paramsMap);
        JSONObject jsonResult = json.getJSONObject("result");
        JSONObject jsonData = jsonResult.getJSONObject("data");
        String token = jsonData.getString("accessToken");
        System.out.println(token);
//        HashMap<String, Object> bparamsMap = new HashMap<String, Object>();
//        bparamsMap.put("deviceId", "3G00ED7PAA00019");// 设备号
//        //bparamsMap.put("code",null);
//        //bparamsMap.put("queryRange","1-30");
//        bparamsMap.put("token",token);
//        userManager.bindDevice(bparamsMap);
        bindDevice("3F05D18PAA00217",token);
        bindDeviceLive("3F05D18PAA00217",token);

    }

    public static String getToken()
    {

        // 注：执行main函数前请先将CONST.java文件中的APPID、SECRET以及PHONE填全，不然程序执行将会报错。

        // 获取管理员token
        UserManagerImpl userManager = new UserManagerImpl();
        HashMap<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("phone", CONST.PHONE);// 管理员账号
        JSONObject json = userManager.accessToken(paramsMap);
        JSONObject jsonResult = json.getJSONObject("result");
        JSONObject jsonData = jsonResult.getJSONObject("data");
        String token = jsonData.getString("accessToken");
        System.out.println(token);
        return token;
    }

    public static int bindDevice(String deviceId,String token)
    {

        UserManagerImpl userManager = new UserManagerImpl();
        HashMap<String, Object> bparamsMap = new HashMap<String, Object>();
        bparamsMap.put("deviceId", deviceId);// 设备号
        //bparamsMap.put("code",null);
        //bparamsMap.put("queryRange","1-30");
        bparamsMap.put("token",token);
        JSONObject json =userManager.bindDevice(bparamsMap);
        JSONObject jsonResult = json.getJSONObject("result");
        String code = jsonResult.getString("code");
        return Integer.parseInt(code);
    }

    public static String bindDeviceLive(String deviceId,String token)
    {

        DeviceManager deviceManager = new DeviceManageImpl();
        HashMap<String, Object> bparamsMap = new HashMap<String, Object>();
        bparamsMap.put("deviceId", deviceId);// 设备号
        bparamsMap.put("channelId",0);
        bparamsMap.put("streamId","1");
        bparamsMap.put("token",token);
        JSONObject json =deviceManager.bindDeviceLive(bparamsMap);
        JSONObject jsonResult = json.getJSONObject("result");
        JSONObject jsonData = jsonResult.getJSONObject("data");
        JSONObject streams = jsonData.getJSONObject("streams");
        String hls = jsonData.getString("hls");
        return hls;
    }
}
