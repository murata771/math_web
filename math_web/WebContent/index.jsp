<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>デフォルトページ</title>
<link rel="stylesheet" type="text/css" href="login.css" >
</head>
<body>
<div id="main">
<h2>四則演算webアプリ（低学年向け）</h2>
<h3 >ようこそ</h3>

<form action="/math_web/Login1Servlet" method="get">
<input type="submit" value="ログイン画面へ" style="color : red">
<input type="hidden" name="hoge" value="back">
</form>

<form action="/math_web/RegisterServlet" method="get">
<h3><input type="submit" value="ユーザ登録"></h3><br>
<input type="hidden" name="noerror" value="no">
</form>
<div id="footer">
<jsp:include page="/WEB-INF/jsp/footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>