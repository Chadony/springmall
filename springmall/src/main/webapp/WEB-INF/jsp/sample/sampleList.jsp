<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>sampleList</title>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<!-- 제이쿼리 -->
</head>
<body>
	<h1 class="text-danger text-center">리스트</h1>
	<table class="table">
		<thead class="table-primary">
			<tr>
				<td>Sample NO</td>
				<td>Sample ID</td>
				<td>Sample PW</td>
				<td>DELETE</td>
				<td>UPDATE</td>
			</tr>
		</thead>
		<tbody  class="table-success">
			<c:forEach var="sample" items="${sampleList}">
				<tr>
					<td>${sample.sampleNo}</td>
					<td>${sample.sampleId}</td>
					<td>${sample.samplePw}</td>
					<td><button type="button" class="btn btn-info" onclick="location.href='/sample/removeSample?sampleNo=${sample.sampleNo}'">DELETE</button></td>
					<td><button type="button" class="btn btn-info" onclick="location.href='/sample/modifySample?sampleNo=${sample.sampleNo}'">UPDATE</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${currentPage > 1}">
		<a href="<%=request.getContextPath()%>/sample/sampleList?currentPage=${currentPage-1}">
			<button type="button" class="btn btn-danger">이전</button></a>
	</c:if>
	<c:if test="${currentPage < lastPage}">
		<a href="<%=request.getContextPath()%>/sample/sampleList?currentPage=${currentPage+1}">
			<button type="button" class="btn btn-danger">다음</button></a>
	</c:if>
</body>
</html>