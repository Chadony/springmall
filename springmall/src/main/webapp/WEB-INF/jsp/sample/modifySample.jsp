<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>modifySample</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<h1 class="text-danger text-center">���� ��</h1>
		<form action="<%=request.getContextPath()%>/sample/modifySample" method="post">
            <table class="table table-bordered">
            	<tr class="table-primary">
            		<td>�ѹ�</td>
            		<td><input type="text" name="sampleNo" value="${sample.sampleNo}" readonly></td>
            	</tr>
                <tr class="table-success">
                    <td>���̵�</td>
					<td><input type="text" name="sampleId" value="${sample.sampleId}" readonly></td>
                </tr>
                <tr class="table-warning">
                    <td>��й�ȣ</td>
		    		<td><input type="text" name="samplePw" value="${sample.samplePw}" size="20"></td>
                </tr>             
                <tr class="info">
                    <td colspan="2">
                        <button type="submit" class="btn btn-info">���� ����</button>
                    </td>
                </tr> 
            </table>
        </form>
</body>
</html>