<%@page import="test.dao.friendDAO"%>
<%@page import="test.dto.friendDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Frinds Information</h2>
<table  border="1" cellspacing="1" width="500" height="50" align="center">
   <tr align="center">
   		<td  colspan="6" >친구정보를 추가로 입력하세요. 
	 	<button onclick="location.href='insert.html'">친구추가</button> 
	 	</td>
   </tr>
   <tr align="center">
       <td>번호</td>
       <td>이름</td>
       <td>전화</td>
       <td>등록일</td>
       <td>삭제</td>
       <td>수정</td>
     </tr>
<%
	//DAO 객체 만들기
	friendDAO dao = friendDAO.getInstance();
	//전체 리스트 가져오기	
	ArrayList<friendDTO> list = dao.getListArrayList();
	//For Loop 돌면서 테이블에 뿌려주기
	for(friendDTO tmp : list){
%>
     <tr align="center">     
       <td><%=tmp.getNum() %></td>
       <td><%=tmp.getName() %></td>
       <td><%=tmp.getPhone() %></td>
       <td><%=tmp.getRegdate() %></td>
       <td>
       <%String arg = "num=" + tmp.getNum(); %>
       <button onclick="location.href='delete.jsp?<%=arg%>'">삭제</button></td>
       <td><button onclick="location.href='updateview.jsp?<%=arg%>'">수정</button></td>
     </tr>
<%} %>	 
   </tbody>
</table>
</body>
</html>