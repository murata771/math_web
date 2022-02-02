<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>隠しパラメータの実験</title>
</head>
<body>
<form action="/math_web/Hiddenzikken?hoge=back" method="get">
<input type="submit" value="戻る" style="background-color:skyblue">
</form>

<form action="/math_web/Hiddenzikken" method="get">
<input type="submit" value="戻る_input" style="background-color:skyblue">
<input type="hidden" name="hoge" value="back">
</form>

<form action="/math_web/Hiddenzikken?hoge=back" method="post">
<input type="submit" value="post" style="background-color:skyblue">
</form>
</body>
</html>