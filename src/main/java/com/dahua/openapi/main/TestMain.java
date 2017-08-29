package com.dahua.openapi.main;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.dahua.openapi.business.DeviceManager;
import com.dahua.openapi.business.impl.DeviceManageImpl;
import com.dahua.openapi.business.impl.UserManagerImpl;
import com.dahua.openapi.util.CONST;

public class TestMain {

    public static void main(String[] args) {

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
        HashMap<String, Object> bparamsMap = new HashMap<String, Object>();
        bparamsMap.put("deviceId", "3G00ED7PAA00019");// 设备号
        bparamsMap.put("code",null);
        //bparamsMap.put("queryRange","1-30");
        bparamsMap.put("token",token);
        userManager.bindDevice(bparamsMap);

        /*
         * DeviceManageImpl device = new DeviceManageImpl(); HashMap<String, Object> paramsMap = new
         * HashMap<String, Object>(); paramsMap.put("appId", CONST.APPID); paramsMap.put("phone",
         * CONST.PHONE); // paramsMap.put("type", "device"); paramsMap.put("filter",
         * "dev_20160820142214_9t9h0rc4zi8m89m2"); JSONObject json = device.liveInfo(paramsMap);
         * JSONObject jsonResult = json.getJSONObject("result"); JSONObject jsonData =
         * jsonResult.getJSONObject("data"); String token = jsonData.getString("accessToken");
         */

    }

}
