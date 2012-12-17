<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<style  type="text/css">
			table
			{
				border-collapse:collapse;
			}
			table, th, td
			{
				border: 1px solid black;
			}
		</style>
	</head>
	<body>
		<%@ include file="embeddable.jsp"%> <br>
		<a href="<c:url value='/storeEdit.do'/>">Add new</a>
		<table style="border: 1px solid black;">
			<th>id</th>
			<th>name</th>
			<th>actions</th>
			<c:forEach items="${stores}" var="store">
				<tr>
					<td>${store.id}</td>
					<td>${store.name}</td>
					<td>
						<a href="<c:url value='/storeEdit.do?id=${store.id}'/>">Edit</a><br>
						<a href="<c:url value='/storeRemove.do?id=${store.id}'/>">Remove</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
