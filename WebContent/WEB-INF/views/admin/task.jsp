
<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">

					<h4 style="color: red;">${requestScope.mesg}</h4>
					<h4>Welcome:${sessionScope.admin_details.firstName}</h4>


					<h4>choose operation</h4>
					<h4>
						<a href="${SITE_URL}/admin/customerList">Customer list</a>
					</h4>
					<h4>
						<a href="${SITE_URL}/admin/sellerList">Seller list</a>
					</h4>
					<h4>
						<a href="<spring:url value='addcategory'/>">Add	Category</a>
					</h4>
					<h4>
						<a href="<spring:url value='removecategory'/>">remove Category</a>
					</h4>
					<h4>
						<a href="<spring:url value='/admin/logout'/>">logout</a>
					</h4>
				</div>
			</div>
		</div>
	</div>
</div>
