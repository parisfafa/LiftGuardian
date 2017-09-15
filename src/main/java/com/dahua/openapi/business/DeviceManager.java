package com.dahua.openapi.business;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

public interface DeviceManager {
	
	//��ȡָ��LiveToken��ֱ����ַ��Ϣ
	public JSONObject liveInfo(HashMap<String, Object> paramMap);

	//��ȡֱ��״̬
	public JSONObject queryLiveStatus(HashMap<String, Object> paramMap);

	//�޸�ֱ��״̬
	public JSONObject modifyLiveStatus(HashMap<String, Object> paramMap);

	//����ֱ���ƻ�����
	public JSONObject modifyLivePlanStatus(HashMap<String, Object> paramMap);

	//�޸�ֱ���ƻ�ʱ��
	public JSONObject modifyLivePlan(HashMap<String, Object> paramMap);

   //
	public JSONObject bindDeviceLive(HashMap<String, Object> paramMap);
}
