<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ情報消去確認</title>
</head>
<body>
<div id="main">
<h2 style="color:#660099;">四則演算webアプリ（低学年向け）</h2>

<h3 style="color:#881111">以下のユーザ情報を消去します。<br>よろしいですか？</h3>
<section id="delitenaiyou">
<h3>ユーザID : <c:out value="${userInfo.userID }"/></h3><h3>年齢 : <c:out value="${userInfo.age }"/></h3><br>
<p>パスワード : ********      ニックネーム : <c:out value="${userInfo.nickname }"/></p>
<p>好きな物 :<c:out value="${userInfo.likeThing }"/>     学年 : <c:out value="${userInfo.grade }"/></p>
</section>

<form  action="/math_web/DeliteServlet" method="post">
<input type="submit" value="はい" style="background-color:#0088BB;">

</form><%--ボタンにする予定 --%>
<form  action="/math_web/Login2Servlet" method="post">
<input type="hidden" name="deliteno" value="back">
<input type="submit" value="いいえ" style="background-color:#0088BB;">

</form><br>
<div id="footer">
<jsp:include page="./footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>