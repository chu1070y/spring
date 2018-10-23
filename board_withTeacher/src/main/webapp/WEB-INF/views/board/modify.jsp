<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="../includes/header.jsp"%>
<div id="page-wrapper">
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Modify/delete</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>

<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Modify</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
			
				
				
				<div class="col-lg-12">
				<form role="form" action="modify" method="post">
				
					<input type="hidden" name="bno" value="${board.bno}">
					<input type='hidden' name='display' id='display' value='${pageObj.display}'>
 					<input type='hidden' name='keyword' id='keyword' value='${pageObj.keyword}'>
 					<input type='hidden' name='types' id='types' value='${pageObj.types}'>
 					<input type="hidden" name="page" value="${pageObj.page}">
				
						<div class="form-group">
							<label>Title</label> <input class="form-control" name="title" value="<c:out value='${board.title}'/>" >
							<p class="help-block">Example block-level help text here.</p>
						</div>
						<div class="form-group">
							<label>Writer</label> <input class="form-control" readonly="readonly" name="writer" value="<c:out value='${board.writer}'/>" >
							<p class="help-block">Example block-level help text here.</p>
						</div>

						<div class="form-group">
							<label>Text area</label>
							<textarea class="form-control" rows="3" name="content">"<c:out value='${board.content}'/>"</textarea>
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-default">Modify</button>
						</div>
						</form>
						
					<form role="form" action="/board/list" method="get">
					<input type="hidden" name="page" value="${pageObj.page}">
					<input type='hidden' name='display' id='display' value='${pageObj.display}'>
 					<input type='hidden' name='keyword' id='keyword' value='${pageObj.keyword}'>
 					<input type='hidden' name='types' id='types' value='${pageObj.types}'>
						<button type="submit" class="btn btn-default">Go List</button>
					</form>
					
					<form role="form" action="/board/remove" method="post">
					<input type="hidden" name="page" value="${pageObj.page}">
					<input type="hidden" name="bno" value="${pageObj.bno}">
					<input type='hidden' name='display' id='display' value='${pageObj.display}'>
 					<input type='hidden' name='keyword' id='keyword' value='${pageObj.keyword}'>
 					<input type='hidden' name='types' id='types' value='${pageObj.types}'>
						<button type="submit" class="btn btn-default">Remove</button>
					</form>
					
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
	</div>
</div>
<!-- /.row -->
</div>


<%@include file="../includes/footer.jsp"%>


</body>

</html>
