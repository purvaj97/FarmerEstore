
<div class="container">
	<div class="row">
		<div>
			<table margin: auto;" border="1">

				<tr>
					<td>Product Name</td>
					<td>Weight</td>
					<td>Quantity</td>
					<td>Total</td>
					<td>Order Date</td>
					<td>Billing Address</td>
					<td>Shipping Address</td>
					<td>Status</td>
					<td></td>
				</tr>

				<c:forEach var="order" items="${seller_details.orders}">
					<tr>
						<td>${order.productName}</td>
						<td>${order.weight}</td>
						<td>${order.quantity}</td>
						<td>${order.value}</td>
						<td>${order.orderDate}</td>
						<td>${order.billingAddress}</td>
						<td>${order.shippingAddress}</td>
						<td>${order.status}</td>
						<td><form action="<spring:url value='/orders/update' />"
								method="post">
								<input type="hidden" name="orderId" value="${order.orderId}" />
								<button type="submit" class="btn btn-block btn-primary">Update</button>
							</form></td>
					</tr>
				</c:forEach>
			</table>
			<button>
				<a href="<spring:url value='/seller/task'/>">Back</a>
			</button>
		</div>
	</div>
</div>

