
	<div class="container">
		<div class="row">
			<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
				<div class="card card-signin my-5">
					<div class="card-body">
						<h5 class="card-title text-center">
							Home<br /> ${requestScope.mesg}
						</h5>

						<button class="btn btn-lg btn-block text-uppercase">
							<a href="<spring:url value='/seller/login'/>">Sign in as
								Seller</a>
						</button>



						<button class="btn btn-lg btn-block text-uppercase">
							<a href="<spring:url value='/customer/login'/>">Sign in as
								Customer</a>
						</button>

					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="item active">
	</div>