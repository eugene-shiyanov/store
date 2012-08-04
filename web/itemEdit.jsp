<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<form action="<c:url value='/itemEdit.do'/>" method="POST">
		<input type="hidden" name="id" value="${item.id}">
		<table>
			<tr>
				<td>Name: </td>
				<td>
					<input type="text" name="name" value="${item.name}">
				</td>
			</tr>
			<tr>
				<td>Price: </td>
				<td>
					<input type="text" name="price" value="${item.price}">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="Save">
				</td>
			</tr>
		</table>
	</form>
</html>
