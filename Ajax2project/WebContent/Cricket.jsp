<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>

<%
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@10.151.60.215:1521:xe";
		Connection conn = DriverManager.getConnection(url, "system", "sapient123");
		String sql = "select * from cricket where ctry=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, "india");
		ResultSet rs = st.executeQuery();

		JSONObject json = null;

		while (rs.next()) {
			json = new JSONObject();
			json.put("cname", rs.getString("ctry"));
			json.put("cruns", rs.getInt("runs"));

		}
		out.println(json);
		conn.close();
	} catch (Exception ex) {
		System.out.println(ex.getMessage());
	}
%>