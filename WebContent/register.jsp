<%@page import="com.persistance_class_Dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register</title>
</head>
<body>
	<jsp:useBean id="user_obj" class="com.persistance_class.User"></jsp:useBean>
	<jsp:setProperty property="*" name="user_obj" />

	<%
		int status = UserDao.registerUser(user_obj);
		if (status > 0) {
			response.sendRedirect("success.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
	%>
</body>
</html>