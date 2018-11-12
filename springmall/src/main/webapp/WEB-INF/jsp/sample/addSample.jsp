<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>addSample</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<h1 class="text-danger text-center">샘플 추가</h1>
	<form action="<%=request.getContextPath()%>/sample/addSample" method="post" enctype="multipart/form-data">
	<table class="table">
		<tr class="table-primary">
			<td>아이디</td>
			<td><input type="text" name="sampleId" size="20"></td>
		<tr class="table-primary">
		    <td>비밀번호</td>
		    <td><input type="text" name="samplePw" size="20"></td>
		<tr>
		<tr class="table-primary">
			<td>파일</td>
			<td><input type="file" name="multipartFile"></td>
		</tr>
		<tr>
		    <td colspan="2"><input type="submit" class="btn btn-info" value="샘플 추가"></td>
		</tr>
	</table>
	</form>
</body>
</html>