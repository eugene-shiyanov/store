<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<body>
		<table>
			<th>id</th>
			<th>name</th>
			<th>price</th>
			<c:forEach items="${items}" var="item">
				<tr>
					<td><a href="<c:url value='/itemEdit.do?id=${item.id}'/>">${item.id}</a></td>
					<td>${item.name}</td>
					<td>${item.price}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
