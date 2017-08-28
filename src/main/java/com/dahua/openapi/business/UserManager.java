package com.dahua.openapi.business;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

public interface UserManager {

    public JSONObject accessToken(HashMap<String, Object> paramMap);

    public JSONObject userToken(HashMap<String, Object> paramMap);

    public JSONObject userBindSms(HashMap<String, Object> paramMap);

    public JSONObject userBind(HashMap<String, Object> paramMap);

}
