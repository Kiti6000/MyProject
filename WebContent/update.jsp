<%@page import="test.dto.friendDTO"%>
<%@page import="test.dao.friendDAO"%>
<%@ page pageEncoding="UTF-8"%>
<%
	//Post Encoding
	request.setCharacterEncoding("utf-8");
	//넘어온 인자 받기
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	int number = Integer.parseInt(request.getParameter("num"));
	
	out.println(name + "/" + phone + "/" + number);
	
	int num=24;
	//자동생성 인자 빈값 채우기
	String regdate = null;
	//DAO 객체 얻어오기
	friendDAO dao = friendDAO.getInstance();
	
	//DTO 에 담아 저장하기
	friendDTO dto = new friendDTO(num, name, phone, regdate);
	boolean isSuccess = dao.update(dto);
	//성공실패 여부를 알려주고 리스트 페이지로 넘어가기
	response.sendRedirect("list.jsp");
%>
