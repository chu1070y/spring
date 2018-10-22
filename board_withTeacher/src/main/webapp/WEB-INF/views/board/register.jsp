<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="../includes/header.jsp"%>
<div id="page-wrapper">
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Register</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>

<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Register</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
			
				<div class="col-lg-12">
					<form role="form" action="/board/register" method="post">
						<div class="form-group">
							<label>Title</label> <input class="form-control" name="title" value="sample title">
							<p class="help-block">Example block-level help text here.</p>
						</div>
						<div class="form-group">
							<label>Writer</label> <input class="form-control" name="writer" value="sample writer">
							<p class="help-block">Example block-level help text here.</p>
						</div>

						<div class="form-group">
							<label>Text area</label>
							<textarea class="form-control" rows="3" name="content">Sample text</textarea>
						</div>
						<button type="submit" class="btn btn-default">등록하기
							Button</button>
					</form>
					<form action="/board/list" method="get">
						<button type="submit" class="btn btn-default">목록으로/button>
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
