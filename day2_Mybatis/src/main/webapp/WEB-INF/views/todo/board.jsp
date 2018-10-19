<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>게시판</h1>

	<div class="title"></div>

	<div class="btn"></div>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
	
	$.getJSON("/todo/list2",function(data){
		
		console.log(data);
		
		var str = "";
		
		$(data).each(function(idx,obj){
			str += "<li>" + obj.title + "</li>";
		});
		
		$(".title").html(str);
	});
	
	console.log($(".btn"))
	
	var page = ""
	
	for(i = 0 ; i < ${count} ; i++){
		
		page += "<button id='page' value = " + (i+1) +  " >" + (i+1) + "</button>";
	}
	
	$(".btn").html(page);
	
	
	
	
	</script>

</body>
</html>