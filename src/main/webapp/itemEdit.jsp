<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
   <head>
	<link rel="stylesheet" href="css/main.css" type="text/css">
   </head>
   <body>
	 <%@ include file="embeddable.jsp"%> <br>
     <form action="<c:url value='/itemEdit.do'/>" method="POST">
       <input type="hidden" name="id" value="${item.id}">
       <table>
	 <tr>
	   <td>Name: </td>
	   <td>
	     <input type="text" name="name" value="${item.name}">
	     <c:if test="${not empty errors}">
	       <br>
	       <label class="errors"><c:out value="${errors['item.name']}"/></label>
	     </c:if>
	   </td>
	 </tr>
	 <tr>
	   <td>Price: </td>
	   <td>
	     <input type="text" name="price" value="${item.price}">
	     <c:if test="${not empty errors}">
	       <br>
	       <label class="errors"><c:out value="${errors['item.price']}"/></label>
	     </c:if>
	   </td>
	 </tr>
	 <tr>
	   <td colspan="2" align="right">
	     <input type="submit" value="Save">
	   </td>
	 </tr>
       </table>
     </form>
   </body>
</html>
