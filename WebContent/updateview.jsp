<%@page import="test.dto.friendDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="test.dao.friendDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	//DAO 객체 얻어오기
	friendDAO dao = friendDAO.getInstance();
	
	//업데이트 할 Num 얻어오기
	int num = Integer.parseInt(request.getParameter("num"));
	
	//한개의 객체 얻어오기
	ArrayList<friendDTO> list = new ArrayList<friendDTO>();
	
	list = dao.getOneList(num);
	friendDTO dto = list.get(0);
%>
<body>
<h2>친구정보 수정 하기</h2>
	<form method="post" action="update.jsp">
	번       호: <%=dto.getNum() %><br/>
	이       름:<input type="text" name="name" value="<%=dto.getName() %>"/><br/>
	전화번호 :<input type="text" name="phone" value="<%=dto.getPhone()%>"/><br/>
	<input type="hidden" name="num" value="<%=dto.getNum() %>"/>
	<input type="submit" value="수정"/>
	</form>
</body>
</html>