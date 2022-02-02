<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ情報登録入力画面</title>
</head>
<body>
<div id="main">
<h2 style="color:#660099;">四則演算webアプリ（低学年向け）</h2><br>

<h3 style="color:#FF1111">ユーザ登録を行います。</h3><br>
<%-- scope_errormessageからエラーメッセージを取得して表示--%>
<c:if test="${ermesse.errorflag==1 }"><h3 style="color : red;"><c:out value="${ermesse.errormessage }" /></h3>
</c:if><br>

<form action="/math_web/RegisterkakuninServlet" method="post">
<p>ニックネーム:<input type="text" name="nickname">   年齢 :  <input type="text" name="age">  </p>
<p>パスワード:<input type="password" name="password">
 学年: <select name="grade">
  <option value="1年">1年</option>
  <option value="2年">2年</option>
  <option value="3年">3年</option>
  <option value="other">それ以外の学年</option>
  </select></p>
<p>好きな物:<input type="text" name="likething">  </p>
<input type="submit" value="登録" style="background-color:#770088">
</form>
<form action="/math_web/indexServlet" method="get">
<input type="submit" value="戻る" style="background-color:skyblue">
<input type="hidden" name="hoge" value="back">
</form>
<div id="footer">
<jsp:include page="./footer.jsp"></jsp:include>
</div>
</div>
</body>
</body>
</body>
</html>