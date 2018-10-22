<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">자유게시판</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">자유게시판 목록</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>등록시간</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${list}" var="board">
									<tr>
										<td>${board.bno}</td>
										<td>${board.title}</td>
										<td>${board.writer}</td>
										<td><fmt:formatDate value="${board.regdate}"
                                 pattern="yyyy-MM-dd HH:mm:ss " /></td>
									</tr>
								</c:forEach>

							</tbody>
						</table>
					</div>
					<!-- /.table-responsive -->
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<div class="col-sm-7">
			<div class="dataTables_paginate paging_simple_numbers"
				id="dataTables-example_paginate">
				<ul class="pagination">
				
				<c:if test="${page.prev}">
					<li class="paginate_button previous disabled"
						aria-controls="dataTables-example" tabindex="0"
						id="dataTables-example_previous"><a href="${page.start-1}">Previous</a></li>
				</c:if>
				
				<c:forEach begin="${page.start}" end="${page.end}" var="num">
					<li class="paginate_button" data-page="${num}"
						aria-controls="dataTables-example" tabindex="0">
						<a href="${num}"><c:out value="${num}"/></a></li>
				</c:forEach>

				<c:if test="${page.next}">
					<li class="paginate_button next" aria-controls="dataTables-example"
						tabindex="0" id="dataTables-example_next"><a href="${page.end +1}">Next</a></li>
				</c:if>
				
				</ul>
			</div>
		</div>
	</div>
	<!-- /.row -->

</div>
<!-- /#page-wrapper -->

<form id='actionForm'>
   <input type='hidden' name='page' id='page' value='${page.page}'>
   <input type='hidden' name='display' id='display' value='${page.display}'>
</form>

</div>
<!-- /#wrapper -->


<%@include file="../includes/footer.jsp"%>

<script>
$(document).ready(function() {
	
	var actionForm = $("#actionForm");
	var pageNum = ${page.page};
	
	console.log($(".pagination li[data-page="+pageNum+"]"));
	
	$(".pagination li[data-page="+pageNum+"]").addClass("active");
	
	$(".pagination li a").on("click",function(e){
		
		e.preventDefault();
		var target = $(this).attr("href");
		$("#page").val(target);
		
		actionForm.attr("action","/board/list").attr("method","get").submit();
		
	});
	
});

</script>

