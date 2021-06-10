<!-- ========================= SECTION CONTENT ========================= -->
<section class="section-content padding-y">
	<div class="container">

		<div class="row">
			<aside class="col-md-3">
				<ul class="list-group">
					<a class="list-group-item active" href="#overview'/>"> Account overview</a>
					<a class="list-group-item"
						href="<spring:url value='/customer/update?customerId=${customer_details.customerId}'/>">
						Update Profile</a>
					<a class="list-group-item" href="#orders"> My Orders </a>
					<a class="list-group-item"
						href="<spring:url value='/customer/logout'/>">Log Out</a>

				</ul>
			</aside>
			<!-- col.// -->
			<main class="col-md-9">

			<article class="card mb-3" id="overview">
				<div class="card-body">

					<figure class="icontext">
						<div class="icon">
							<!--  <img class="rounded-circle img-sm border"
								src="images/avatars/avatar3.jpg" alt="User"> 
							-->
						</div>
						<div class="text">
							<p>
								<strong> Name: ${customer_details.firstName}
									${customer_details.lastName}</strong> <br> Email:
								${customer_details.email} <br>
							</p>

						</div>
					</figure>
					<hr>
					<p>
						&nbsp; Billing address: <br>
						${customer_details.billingAddress} &nbsp; <hr>
					<!--  	<br> &nbsp; Billing address: <br> ${customer_details.shippingAddress} &nbsp; -->

					</p>


				</div>
				<!-- card-body .// -->
			</article>
			<!-- card.// -->

			<article class="card  mb-3" id="orders">

				<h5 class="card-title mb-4">My orders</h5>

				<c:if test="${customer_details.orders == null}">
					<p>No orders placed</p>
				</c:if>

				<c:if test="${customer_details.orders != null}">

					<c:forEach var="order" items="${customer_details.orders}">
						<div class="row">
							<div class="col-md-6">Product Name:${order.productName}</div>
							<div class="col-md-6">Weight:${order.weight}</div>
							<div class="col-md-6">Quantity:${order.quantity}</div>
							<div class="col-md-6">Total:${order.value}</div>
							<div class="col-md-6">Order Date:${order.orderDate}</div>
							<br>
							<div class="col-md-6">Billing
								Address:${order.billingAddress}</div>
							<br>
							<div class="col-md-6">Shipping
								Address:${order.shippingAddress}</div>
								<br>
							
							<hr>
						</div>
					</c:forEach>
				</c:if>
			</article>
			<!-- card.// --> </main>
			<!-- col.// -->
		</div>

	</div>
	<!-- container .//  -->
</section>
<!-- ========================= SECTION CONTENT END// ========================= -->