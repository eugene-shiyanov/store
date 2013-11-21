<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <link rel="stylesheet" href="css/main.css" type="text/css">
    </head>
    <body>
        <%@ include file="embeddable.jsp"%>
        <br>
        <a href="<c:url value='/storeEdit.do'/>">Add new</a>
        <form action="<c:url value='/storeRemove.do'/>" method="POST">
            <table>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>actions</th>
                </tr>
                <c:forEach items="${stores}" var="store">
                    <tr>
                        <td>${store.id}</td>
                        <td>${store.name}</td>
                        <td>
                            <a href="<c:url value='/storeEdit.do?id=${store.id}'/>">Edit</a><br>
                            <button name="id" value="${store.id}"
                                    onclick="return confirm('Are you sure?');">Remove</button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>
