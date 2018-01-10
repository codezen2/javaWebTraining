<%@page import="org.json.simple.JSONObject" %>
	<%
		
		double amt = Double.parseDouble(request.getParameter("tamt"));
		int year = Integer.parseInt(request.getParameter("tyear"));
		double rate = 0.15;
		double ci = amt * Math.pow((1 + rate), year);
		ci = Math.round(ci * 100) / 100.0;
		double emi = ci / (year * 12.0);
		emi = Math.round(emi * 100) / 100.0;
		
		JSONObject obj1 = new JSONObject();
		obj1.put("ci", ci);
		obj1.put("emi", emi);
		out.println(obj1);
	%>







