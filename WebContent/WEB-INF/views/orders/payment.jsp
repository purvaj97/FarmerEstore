<script src="${js}/validations.js" type="text/javascript"></script>

<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					<h3>Payment</h3>

					<div>
						<form action="placeorder" method="post" onsubmit="return makePayment()">
							<div>Payment amount: ${sessionScope.customer_details.cart.amount}</div>
							<div>
								<button type="submit" id="makepayment" class="btn btn-primary">Pay Now</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>