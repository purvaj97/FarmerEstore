<div>

	<div class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card card-signin my-5">
					<div class="card-body">
						<div>
							<h3>${requestScope.mesg}</h3>
								<h3>Orders List</h3>

							<table margin: auto;" border="1">

								<tr>
									<td>Product Name</td>
									<td>Weight</td>
									<td>Quantity</td>
									<td>Total</td>
									<td>Order Date</td>
									<td>Billing Address</td>
									<td>Shipping Address</td>
									<td>Delivery Status</td>
								</tr>

								<c:forEach var="order" items="${customer_details.orders}">
									<tr>
										<td>${order.productName}</td>
										<td>${order.weight}</td>
										<td>${order.quantity}</td>
										<td>${order.value}</td>
										<td>${order.orderDate}</td>
										<td>${order.billingAddress}</td>
										<td>${order.shippingAddress}</td>
										<td>${order.status}</td>
									</tr>
								</c:forEach>
								<tr>
								<p>Orders are placed and will reach to you soon.</p>
								</tr>
								
								<tr>
									<td><a href="<spring:url value='/customer/categories' />"
										class="btn btn-warning"> Continue Shopping</a></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</div>