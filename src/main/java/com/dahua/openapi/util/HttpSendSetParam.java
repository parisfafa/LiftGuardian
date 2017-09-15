package com.dahua.openapi.util;

import java.util.HashMap;
import java.util.UUID;

public class HttpSendSetParam extends HttpSend {

    public static Object sent(HashMap<String, Object> paramMap, String method) {

        HttpSend.setHost(CONST.HOST + ":" + CONST.PORT);
        // super.setTime(time);
        HttpSend.setAppId(CONST.APPID);
        HttpSend.setAppSecret(CONST.SECRET);
        HttpSend.setPhone(CONST.PHONE);
        HttpSend.setVer("1.0");
        HttpSend.setNonce(UUID.randomUUID().toString().replace("-",""));
        HttpSend.setId("12345");

        return HttpSendMethod(paramMap, method);
    }
}
