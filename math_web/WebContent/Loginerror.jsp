<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン回数上限</title>
</head>
<body>
<div id="main">
<h2>四則演算webアプリ（低学年向け）</h2>

<p>ログイン試行回数が3回に達しました。</p>
<p>再びログインするためには30分待つ必要があります。</p>
<a href="/math_web/indexServlet">トップメニューへ</a>

<div id="footer">
<jsp:include page="./WEB-INF/jsp/footer.jsp"></jsp:include>
</div>
</div>
</body>
</html>