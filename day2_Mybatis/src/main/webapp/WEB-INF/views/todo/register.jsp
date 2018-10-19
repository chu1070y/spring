<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<img alt="" src="/resources/aaa.jpg">

<!-- action을 넣어야하지만 생략할수 있다. 생략하면 todo/register의 post가 경로가 된다. -->
<form method="post">
	<input type="text" name="title" value="한글테스트">
	<br/>
	<input type='date' name='regdate'>
	<button>save</button>
</form>

</body>
</html>