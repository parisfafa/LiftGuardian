package com.dahua.openapi.util;

import java.util.*;

import org.apache.commons.codec.digest.DigestUtils;

import com.alibaba.fastjson.JSONObject;

public class PublicControllerTest {

    private static long signTime;

    private static String test_parm;

    public String getTest_parm() {
        return test_parm;
    }

    public void setTest_parm(String test_parm) {
        this.test_parm = test_parm;
    }

    public static Map<String, Object> paramsInit(Map<String, Object> paramsMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        long time = System.currentTimeMillis() / 1000;
        if (signTime > 0) {
            time = signTime;
        }

        StringBuilder paramString = new StringBuilder();
        List<String> paramList = new ArrayList<String>();
        for (Iterator<String> it = paramsMap.keySet().iterator(); it.hasNext();) {
            String key1 = it.next();
            String param = key1 + ":" + paramsMap.get(key1);
            paramList.add(param);
        }
        String[] params = paramList.toArray(new String[paramList.size()]);
        Arrays.sort(params);
        for (String param : params) {
            paramString.append(param).append(",");
        }
        UUID uuids = UUID.randomUUID();
        //System.out.println(uuids.toString().replace("-", ""));
        String uuid = uuids.toString().replace("-", "");
        paramString.append("time").append(":").append(time).append(",");
        paramString.append("nonce").append(":").append(uuid).append(",");
        paramString.append("appSecret").append(":").append(CONST.SECRET);
        //System.out.println(paramString.toString().trim());

        String sign = null;
        try {
            System.err.println(String.format("sign string = [%s]", paramString.toString().trim()));
            sign = DigestUtils.md5Hex(paramString.toString().trim().getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> systemMap = new HashMap<String, Object>();
        systemMap.put("ver", "1.0");
        systemMap.put("sign", sign);
        systemMap.put("appId", CONST.APPID);
        systemMap.put("time", time);
        systemMap.put("nonce", uuid);

        if (systemMap.containsKey(test_parm))
            systemMap.remove(test_parm);

        map.put("system", systemMap);
        map.put("params", paramsMap);
        map.put("id", "123456");

        if (map.containsKey(test_parm))
            map.remove(test_parm);

        return map;
    }

    // protected static JSONObject doPost(String strMethod, Map<String, Object> map) {
    // String json = JSON.toJSONString(map);
    // ProtocolSocketFactory fcty = new MySecureProtocolSocketFactory();
    // Protocol.registerProtocol("https", new Protocol("https", fcty, 8080));
    // HttpClient client = new HttpClient();
    // // 使用POST方法
    // // PostMethod method = new PostMethod(CONST.HOST + ":" + CONST.PORT + "/" + strMethod);
    // // System.out.println("请求URl:"+CONST.HOST + ":" + CONST.PORT + "/" + strMethod);
    // String restult = "";
    // JSONObject jsonObject = new JSONObject();
    // try {
    // RequestEntity entity = new StringRequestEntity(json, "application/json", "UTF-8");
    // method.setRequestEntity(entity);
    // client.executeMethod(method);
    //
    // InputStream inputStream = method.getResponseBodyAsStream();
    // restult = IOUtils.toString(inputStream);
    // jsonObject = JSONObject.parseObject(restult);
    // } catch (Exception e) {
    // e.printStackTrace();
    // } finally {
    // // 释放连接
    // method.releaseConnection();
    // }
    // return jsonObject;
    // }

    protected JSONObject getRspRsult(JSONObject jsonObj) {
        return jsonObj.getJSONObject("result");
    }

    /**
     * <p>
     * key列表在Json对象中存在
     * </p>
     * 
     * @author lidongqi 2016年6月7日 下午1:36:01
     * @param jsonObject
     * @param keyList
     */
    protected void AssertParamsExist(JSONObject jsonObject, List<String> keyList) {
        for (String key : keyList) {
            System.out.println(String.format("%s = %s", key, jsonObject.getString(key)));
        }
    }

    public long getSignTime() {
        return signTime;
    }

    public void setSignTime(long signTime) {
        this.signTime = signTime;
    }
}
