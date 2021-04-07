package test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Test {

	private final static String APPID = "Mgl7CcNQ2EzQEIjK4QGFAVvMolbodPj9";
	private final static String SECRET = "pRXOadwG9OjYxWeaH7AcG3AVptmEoG2P";
	private final static String URL = "https://account.adream.org/account/restful/queryUserByUid";

	public static void main(String[] args) throws ParseException, IOException {
		String userId = "20201582165326168101";
		JSONArray result = new JSONArray();
		Map<String, Object> param = new HashMap<>();
		param.put("uid", userId);
		String jsonString = JSONObject.toJSON(param).toString();
		System.out.println(jsonString);
		String timestamp = new Date().getTime() + "";
		System.out.println(timestamp);

		String signature = DigestUtils.md5Hex(SECRET + timestamp + jsonString);
		System.out.println("signature:" + signature);
		// 创建HttpClient对象
		CloseableHttpClient closeHttpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		// 发送Post请求
		HttpPost httpPost = new HttpPost(URL);
		// 设置Post参数
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("appid", APPID));
		params.add(new BasicNameValuePair("timestamp", timestamp));
		params.add(new BasicNameValuePair("signature", signature));
		params.add(new BasicNameValuePair("body", jsonString));

		try {
			// 转换参数并设置编码格式
			httpPost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
			// 执行Post请求 得到Response对象
			response = closeHttpClient.execute(httpPost);
			// 返回对象 向上造型
			HttpEntity httpEntity = response.getEntity();
			if (httpEntity != null) {
				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					String reString = EntityUtils.toString(response.getEntity());
					// JSONObject responseObject = JSONObject.parseObject("{\"returnCode\":
					// \"0000\",\"returnMessage\": \"获取verify列表成功\",\"returnObject\": [{\"state\":
					// \"2\"}]}");
					System.out.println(reString);
					JSONObject responseObject = JSONObject.parseObject(reString);
					JSONObject temp = (JSONObject) responseObject.get("returnObject");
					// if (temp == null || temp.size() == 0)
					// return result;
					// JSONArray resIdsArray = (JSONArray) temp.get("resIds");
					// if (resIdsArray == null || resIdsArray.size() == 0)
					// return result;

					// result = resIdsArray;

				}
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {

		}
	}
}
