<?xml version="1.0" encoding="utf-8"?>
<%@page import="test.dto.friendDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="test.dao.friendDAO"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//DAO 객체 얻어오기
	friendDAO dao = friendDAO.getInstance();
	
	//ArrayList 선언 후 Friend Table 정보 얻어도기
	ArrayList<friendDTO> list = dao.getListArrayList();
	
	//xml로 뿌려주기
%>
<friend>
	<%for(friendDTO tmp : list){%>
	<item>
		<num><%=tmp.getNum()%></num>
		<name><%=tmp.getName()%></name>
		<phone><%=tmp.getPhone()%></phone>
		<regdate><%=tmp.getRegdate()%></regdate>		
	</item>	
	<%}%>
</friend>
