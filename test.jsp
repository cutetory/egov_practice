<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
</head>
<body>
	<h1>Test중...</h1>
	<h6>Test중...</h6>
	<%
		out.print("success");
	%>
	<%
		Calendar cal = Calendar.getInstance();
		int y = cal.get(Calendar.YEAR);
		int m = cal.get(Calendar.MONTH);
		int d = cal.get(Calendar.DATE);
	%>
	<%=y %>년 <%=m+1 %>월 <%=d %>일
	
	<a href="/deptWrite.do">부서관리로 이동</a>
	<a href="deptList.do">부서관리 리스트 이동</a>
</body>
</html>