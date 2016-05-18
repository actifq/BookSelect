<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="table.css">
</head>
<body>
	<center>
		<h3>�ڷ��</h3>
		<br />
		<br />
		<br />
		<br />
		<table id="table_content">
			<tr>
				<td align=left><a href="board_insert.do" class="button">�۾���</a>
				</td>
			</tr>
		</table>
		<table id="table_content">
			<tr>
				<th width=10%>��ȣ</th>
				<th width=45%>����</th>
				<th width=15%>�̸�</th>
				<th width=20%>�ۼ���</th>
				<th width=10%>��ȸ��</th>
			</tr>
			<c:forEach var="dto" items="${list }">
				<tr class="dataTr">
					<td width=10% class="tdcenter">${dto.no }</td>
					<td width=45% class="tdleft"><a
						href="board_content.do?no=${dto.no }&page=${curpage}">${dto.subject }</a>
						<c:if test="${today==dto.regdate }">
							<img src="image/icon_new (2).gif">
						</c:if></td>
					<td width=15% class="tdcenter">${dto.name }</td>
					<td width=20% class="tdcenter">
						<fmt:formatDate value="${dto.regdate }" pattern="yyyy-MM-dd"/>
					</td>
					<td width=10% class="tdcenter">${dto.hit }</td>
				</tr>
			</c:forEach>
		</table>
		<table id="table_content">
			<tr>
				<td align=right><a
					href="list.do?page=${curpage>1?curpage-1:curpage }">����</a>&nbsp; <a
					href="list.do?page=${curpage<totalpage?curpage+1:curpage }">����</a>&nbsp;&nbsp;
					${curpage } page / ${totalpage } pages</td>
			</tr>
		</table>
	</center>
</body>
</html>



