/**
 * 
 */
package com.cdhotel.common;

import java.util.UUID;

import org.springframework.boot.jackson.JsonObjectDeserializer;

import net.sf.json.JSONObject;

/**
 * @author 
 *	系统通用方法
 */
public class SystemCommon {

	
	/**
	 * TODO	标准化返回json
	 * @param status 返回状态  TRUE:成功  FALSE:失败 
	 * @param msg	返回信息
	 * @param data	返回数据
	 * @return
	 * String
	 * @CREATE_TIME:2019年4月20日
	 */
	public static String returnJson(String status,String msg,String data) {
		JSONObject json = new JSONObject();
		json.put("STATUS", status);
		json.put("MSG", msg);
		json.put("DATA", data);
		return json.toString();
	}
	
	/**
	 * TODO	数据获取UUID
	 * @return
	 * String
	 * @CREATE_TIME:2019年4月20日
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replaceAll("-", "");
	}
	
	public static void main(String[] args) {
		System.out.println(getUUID());
	}
}
