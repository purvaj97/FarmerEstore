
<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">

					<h4 style="color: red;">${requestScope.mesg}</h4>
					<h4>Welcome:${sessionScope.seller_details.firstName}</h4>


					<h4>choose operation</h4>
					<hr />
					<h4>
						<a href="<spring:url value='/seller/productlist'/>">Show
							Products</a>
					</h4>
					<h4>
						<a href="<spring:url value='/product/addproduct'/>">Add
							Product</a>
					</h4>
					<h4>
						<a href="<spring:url value='/seller/orderlist'/>">Show
							Orders</a>
					</h4>
					<h4>
						<a href="<spring:url value='/seller/account'/>">User Profile</a>
					</h4>
				</div>
			</div>
		</div>
	</div>
</div>
