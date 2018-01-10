package com.sapient;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Demo2 {

	public static void main(String[] args) {
		JSONObject json1 = new JSONObject();
		json1.put("eid", 1001);
		json1.put("ename", "ram");
		json1.put("sal", 16000.00);

		JSONObject json2 = new JSONObject();
		json2.put("eid", 1001);
		json2.put("ename", "ram");
		json2.put("sal", 16000.00);

		JSONObject json3 = new JSONObject();
		json3.put("eid", 1001);
		json3.put("ename", "ram");
		json3.put("sal", 16000.00);

		JSONArray arr = new JSONArray();
		arr.add(json1);
		arr.add(json2);
		arr.add(json3);
		System.out.println(arr);

	}

}
