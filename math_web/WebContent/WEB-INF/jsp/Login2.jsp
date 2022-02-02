<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面2</title>
</head>
<body>
<div id="main">
<h2>四則演算webアプリ（低学年向け）</h2>
<c:if test="${ermesse.errorflag==1}">
<p style="font-size:15px;color:red"><c:out value="${ermesse.errormessage}"/></p>
</c:if>
<form action="/math_web/Login2Servlet" method="post">
<h3>登録した好きな物を入れてください</h3><br>

<p><input type="text" name="likething"></p>
<%--ログインカウント回数が入る --%>
<input type="submit" value="ログイン" style="color:white; background-color:skyblue">
</form>
<h3><c:out value="${logincounter}"/>/3</h3>
<form action="/math_web/Login1Servlet" method="get"><%--backは隠しパラメータ --%>
<input type="submit" value="戻る" style="background-color:skyblue">
<input type="hidden" name="hoge" value="back">
</form>
<div id="footer">
<jsp:include page="./footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>