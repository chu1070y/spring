<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>리스트 페이지입니다 ~~~ ㅎㅎ</h1>

	<select name="cat" id="cat">
	<option value="">--</option>
		<option value="kor">한식</option>
		<option value="jp">일식</option>
		<option value="ws">양식</option>
	</select>
	
	<select name="sub" id="sub">
	</select>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
		
	<script>
	
	$("#cat").change(function(){
		var val = $("#cat option:selected").val();
		console.log(val);
		
		$.getJSON("/todo/stores",{cat:val},function(data){
			
			console.log(data);
			
			var str = "";
			
			$(data).each(function(idx,obj){
				str += "<option>" + obj.sname + "</option>";
			});
			
			$("#sub").html(str);
		});
		
	});

	
	</script>
	

	<h2>${result}</h2>

	<script>
		var result = '${result}';

		if (result === '성공') {
			alert("등록 성공");
		}
	</script>

</body>
</html>