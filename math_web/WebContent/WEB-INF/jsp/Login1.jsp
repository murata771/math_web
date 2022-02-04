<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面1</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/haikei.css" > 
</head>
<body>
<div id="main">
<h2>四則演算webアプリ（低学年向け）</h2>
<c:if test="${ermesse.errorflag==1}">
<p style="font-size:15px;color:red"><c:out value="${ermesse.errormessage}"/></p>
</c:if>
<form action="/math_web/Login1Servlet" method="post">
<p>ニックネーム:<input type="text" name="nickname"><br></p>

<p>パスワード:<input type="password" name="password"></p>
<%--ログインカウント回数が入る --%>
<input type="submit" value="次へ" style="text-aligin:center">
</form>
<h3><c:out value="${logincounter}"/>/3</h3>
<form action="/math_web/indexServlet" method="get">
<input type="submit" value="戻る" style="background-color:skyblue">
<input type="hidden" name="hoge" value="back">
</form>
<div id="footer">
<jsp:include page="./footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>