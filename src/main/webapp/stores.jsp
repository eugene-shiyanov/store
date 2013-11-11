<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <link rel="stylesheet" href="css/main.css" type="text/css">
    </head>
    <body>
        <%@ include file="embeddable.jsp"%>
        <br>
        <a href="<c:url value='/storeEdit.do'/>">Add new</a>
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
                        <a href="<c:url value='/storeRemove.do?id=${store.id}'/>">Remove</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
