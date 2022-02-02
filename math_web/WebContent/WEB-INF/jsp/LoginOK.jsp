<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン成功画面</title>
</head>
<body>
<div id="main">
<h2 style="color:#660099;">四則演算webアプリ（低学年向け）</h2>
<div id="logoutform">
<form action="/math_web/LogoutServlet" method="get">
<input type="submit" value="ログアウト" style="color:#009900;background-color:#007700">
</form>
</div>
<br>
<h3>ログインに成功しました。</h3>
<h3>ようこそ<c:out value="${nickname.nickname }"/>さん</h3><%--セッションスコープからニックネームを取る --%>
<p style="font-size:20px">四則演算メインメニューへ</p><%--リンクにする予定 --%>

<form  action="/math_web/UserdeliteServlet" method="get"><%--backは隠しパラメータ --%>
<input type="submit" value="ユーザ登録削除" style="background-color:#0088BB;">

</form><%--ボタンにする予定 --%>
<p>このアプリでは小学生低学年向けに簡単な計算練習を行うことができます</p>
<div id="footer">
<jsp:include page="./footer.jsp"></jsp:include>
</div>

</div>
</body>
</html>