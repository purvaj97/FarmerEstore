

<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					<div class=container>
						<div class="page-header">
							<h1>Update Quantity</h1>
						</div>

						<form method="post" action="updateproduct">
							<div class="form-group">
								<label for="firstname">Product Name</label> <input
									class="form-control" type="text" id="productName"
									disabled="disabled" value="${product.productName}" />
							</div>
							<div class="form-group">
								<label for="lastname">Quantity</label> <input
									class="form-control" type="text" name="quantity" required
									value="${product.quantity}" />

							</div>
							<input type="hidden" name="productId" value="${product.id}" />

							<button type="submit" class="btn btn-primary">Submit</button>
							<a href="<spring:url value='/seller/task'/>"
								class="btn btn-default">Cancel</a>

						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>
