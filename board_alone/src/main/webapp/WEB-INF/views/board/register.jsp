<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../includes/header.jsp"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">자유롭게 글을 써주세요</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">등록하기</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-12">
							<form role="form" method="post" action="register">

								<div class="form-group">
									<label>Title</label> <input name="title"
										class="form-control" placeholder="Enter text">
								</div>

								<div class="form-group">
									<label>Writer</label> <input name="writer"
										class="form-control" placeholder="Enter text">
								</div>

								<div class="form-group">
									<label>Content</label>
									<textarea name="content" class="form-control" rows="3"></textarea>
								</div>
								<button class="btn btn-default btn-lg btn-block" >등록하기</button>
							</form>
							<a class="btn btn-default btn-lg btn-block" target="_blank" href="list">목록으로</a>

						</div>
					</div>
					<!-- /.row (nested) -->
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
</div>
<!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->

<%@include file="../includes/footer.jsp"%>