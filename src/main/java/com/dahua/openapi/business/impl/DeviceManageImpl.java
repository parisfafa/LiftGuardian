package com.dahua.openapi.business.impl;



import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import com.dahua.openapi.business.DeviceManager;
import com.dahua.openapi.util.HttpSendSetParam;

public class DeviceManageImpl implements DeviceManager {

	@Override
	public JSONObject liveInfo(HashMap<String, Object> paramMap) {
		String	method = "liveInfo";
		return (JSONObject) HttpSendSetParam.sent(paramMap,method);
	}

	@Override
	public JSONObject queryLiveStatus(HashMap<String, Object> paramMap) {
		String	method = "queryLiveStatus";
		return (JSONObject) HttpSendSetParam.sent(paramMap,method);
	}

	@Override
	public JSONObject modifyLiveStatus(HashMap<String, Object> paramMap) {
		String	method = "modifyLiveStatus";
		return (JSONObject) HttpSendSetParam.sent(paramMap,method);
	}

	@Override
	public JSONObject modifyLivePlanStatus(HashMap<String, Object> paramMap) {
		String	method = "modifyLivePlanStatus";
		return (JSONObject) HttpSendSetParam.sent(paramMap,method);
	}

	@Override
	public JSONObject modifyLivePlan(HashMap<String, Object> paramMap) {
		String	method = "modifyLivePlan";
		return (JSONObject) HttpSendSetParam.sent(paramMap,method);
	}

}
