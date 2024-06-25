<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Header Example</title>

</head>
<%@include file="./header.jsp" %>
<body>

	<div style="min-height: 500px;">${sessionScope.loginVo }</div>

</body>
<%@include file="./footer.jsp" %>
</html>
