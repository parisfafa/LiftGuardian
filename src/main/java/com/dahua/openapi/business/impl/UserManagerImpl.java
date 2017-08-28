package com.dahua.openapi.business.impl;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.dahua.openapi.business.UserManager;
import com.dahua.openapi.util.HttpSendSetParam;

public class UserManagerImpl implements UserManager   {

	@Override
	public JSONObject accessToken(HashMap<String, Object> paramMap) {
		String	method = "accessToken";
		return (JSONObject) HttpSendSetParam.sent(paramMap,method);
	}

	@Override
	public JSONObject userToken(HashMap<String, Object> paramMap) {
		String	method = "userToken";
		return (JSONObject) HttpSendSetParam.sent(paramMap,method);
	}

	@Override
	public JSONObject userBindSms(HashMap<String, Object> paramMap) {
		String	method = "userBindSms";
		return (JSONObject) HttpSendSetParam.sent(paramMap,method);
	}

	@Override
	public JSONObject userBind(HashMap<String, Object> paramMap) {
		String	method = "userBind";
		return (JSONObject) HttpSendSetParam.sent(paramMap,method);
	}



}
