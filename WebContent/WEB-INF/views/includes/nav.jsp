

<nav class="navbar navbar-expand-sm bg-light navbar-light">
	<div class="col-lg-2 col-4">
		<a href="${SITE_URL}" class="brand-wrap"> <img class="logo"
			src="${images}/logo.jpeg"><strong>Farmers E-Store</strong>
		</a>
		<!-- brand-wrap.// -->
	</div>

	<div class="col-lg-4 col-sm-6 col-12">
		<div class="widgets-wrap float-md-right">
			<c:if test="${sessionScope.customer_details != null}">
				<div class="widget-header  mr-3">
					<a href="<spring:url value='/customer/cart/showcart' />"
						class="icon icon-sm rounded-circle border">Cart</a>
				</div>
				<div class="widget-header icontext">
					<a href="<spring:url value='/customer/account'/>"
						class="icon icon-sm rounded-circle border">User</a>
					<div class="text">
						<span class="text-muted">Welcome:
							${sessionScope.customer_details.firstName}</span>

					</div>
				</div>
			</c:if>
			<c:if test="${sessionScope.seller_details != null}">
				<div class="widget-header icontext">
					<a href="<spring:url value='/seller/account'/>"
						class="icon icon-sm rounded-circle border">User</a>
					<div class="text">
						<span class="text-muted">Welcome:
							${sessionScope.seller_details.firstName}</span>

					</div>
				</div>
			</c:if>
			<c:if
				test="${sessionScope.customer_details == null and sessionScope.seller_details == null}">
				<div>
					<ul class="nav navbar-nav justify-content-right">
						<li class="navbar-item">

							<button class="btn btn-lg btn-block " type="submit">
								<a href="<spring:url value='/admin/login'/>"> Admin Login</a>
							</button>
						</li>
					</ul>
				</div>
			</c:if>
		</div>
	</div>

</nav>





