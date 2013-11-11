<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <link rel="stylesheet" href="css/main.css" type="text/css">
    </head>
    <body>
        <%@ include file="embeddable.jsp"%>
        <br>
        <a href="<c:url value='/itemEdit.do'/>">Add new</a>
        <form action="<c:url value='/itemRemove.do'/>" method="POST">
            <table>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>price</th>
                    <th>actions</th>
                </tr>
                <c:forEach items="${items}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.price}</td>
                        <td><a href="<c:url value='/itemEdit.do?id=${item.id}'/>">Edit</a><br>
                            <button name="id" value="${item.id}"
                                onclick="return confirm('Are you sure?');">Remove</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
