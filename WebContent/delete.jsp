<%@page import="test.dao.friendDAO"%>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	//Post Encoding
	request.setCharacterEncoding("utf-8");
	//삭제할 번호 담기
	int num = Integer.parseInt(request.getParameter("num"));

	//DAO 객체 가져오고 삭제하기
	friendDAO dao = friendDAO.getInstance();
	dao.delete(num);
	response.sendRedirect("list.jsp");
%>