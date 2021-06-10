<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Last Action Status : ${requestScope.mesg}</h3>

	<table style="background-color: cyan; margin: auto;" border="1">

		<caption>product List</caption>
		<c:forEach var="s" items="${requestScope.cart_items}">
			<tr>
				<td>${s.product.productName}${s.quantity}</td>

				<td><a
					href="<spring:url value='/customer/cart/update?cartItemId=${s.cartItemId}'/>">Update
						quantity</a></td>
				<td><a
					href="<spring:url value='/customer/cart/delete?cartItemId=${s.cartItemId}'/>">Delete
						item</a></td>

			</tr>
		</c:forEach>
	</table>

	<h4>
		<a href="<spring:url value='/Customer/logout'/>">Log Me Out</a>
	</h4>
</body>
</html>