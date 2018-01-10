<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*"%>
    <%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>

<%String citystr = request.getParameter("cityname");
try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	Connection conn = DriverManager.getConnection(url,"system","Sapient123");
    String sql = "select * from city where cname like ?";
	PreparedStatement st = conn.prepareStatement(sql);
	st.setString(1, citystr+"%");
	ResultSet rs = st.executeQuery();
	
	JSONObject jsoncity = null;
	JSONArray arr = new JSONArray();
	
	while(rs.next()){
		jsoncity = new JSONObject();
		jsoncity.put("cid",rs.getInt("cid")  );
		jsoncity.put("cname",rs.getString("cname")  );
		arr.add(jsoncity);
		
		
	}
	JSONObject jcities = new JSONObject();
	jcities.put("cities", arr);
	out.println(jcities);
	conn.close();
}catch(Exception ex){
	System.out.println(ex.getMessage());
}


%>