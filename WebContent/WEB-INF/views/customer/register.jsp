<script src="${js}/validations.js" type="text/javascript"></script>

<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					<div class=container>
						<div class="page-header">
							<h1>Register</h1>
							<p class="lead">Please fill in your information below.</p>
						</div>

						<sf:form method="post" modelAttribute="customer"
							onsubmit="return validatepass()">
							<h3>Basic Info</h3>
							<div class="form-group">
								<label for="firstname">First Name</label>
								<sf:input class="form-control" id="firstname"
									placehonder="First Name" path="firstName" required="true" />
								<sf:errors path="firstName" />
							</div>
							<div class="form-group">
								<label for="lastname">Last Name</label>
								<sf:input class="form-control" id="lastname"
									placehonder="Last Name" path="lastName" required="true" />
								<sf:errors path="lastName" />
							</div>
							<div class="form-group">
								<label for="email">Email</label>
								<sf:input class="form-control" type="email" id="email"
									placehonder="Email" path="email" required="true" />
								<sf:errors path="email" />
							</div>
							<div class="form-group">
								<label for="password">Create Password</label>
								<sf:input class="form-control" type="password" id="createpass"
									placehonder="password" path="password" required="true" />
								<sf:errors path="password" />
							</div>
							<div class="form-group">
								<label for="password">Repeat Password</label>
								<input class="form-control" type="password" id="repeatpass" required="true" /><p id="msg"></p>
								
							</div>
							<div class="form-group">
								<label for="phoneno">Phone Number</label>
								<sf:input class="form-control" id="phoneno"
									placehonder="Phone Number" path="phoneNumber" required="true" />
								<sf:errors path="phoneNumber" />
							</div>
							
							
							<div class="form-group">
								<label for="address">Billing Address</label>
								<sf:textarea class="form-control" type="textarea" id="billingAddress"
									placehonder="Billing Address" path="billingAddress" required="true" />
								<sf:errors path="billingAddress" />
							</div>
							<div class="form-group">
								<label for="address">Shipping Address</label>
								<sf:textarea class="form-control" type="textarea" id="shippingAddress"
									placehonder="Billing Address" path="shippingAddress" required="true" />
								<sf:errors path="shippingAddress" />
							</div>

							<!-- <td><input type="submit" value="Register New Seller" /></td> -->
							<button type="submit" class="btn btn-primary">Submit</button>
							<a href="${SITE_URL}" class="btn btn-default">Cancel</a>

						</sf:form>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>
