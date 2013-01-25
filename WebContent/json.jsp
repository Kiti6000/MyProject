<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="test.dao.friendDAO"%>
<%@ page pageEncoding="UTF-8"%>
<%
	//DAO 객체 정의 하고 데이터 얻어오기
	friendDAO dao = friendDAO.getInstance();
	
	//ArrayList 정의하고 객체 얻어오기
	ArrayList<HashMap> list = dao.getListHashMap();
	
	//HashMap 객체에 list 담기
	HashMap map = new HashMap();
	map.put("friend", list);
	//라이브러리를 이용해서 JSON 형식으로 출력한다.
	JSONObject.writeJSONString(map, out);
%>