


<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					<h5 class="card-title text-center">Sign In</h5>
					<h3>${requestScope.mesg}</h3>
					<form class="form-signin" method="post">
						<div class="form-label-group">
							<label for="email">Email </label> <input type="email" id="email"
								name="email" class="form-control" placeholder="Email address"
								required autofocus>
						</div>

						<div class="form-label-group">
							<label for="inputPassword">Password</label> <input
								type="password" id="password" name="password"
								class="form-control" placeholder="Password" required>
						</div>
						<div class="form-group">
							<button class="btn btn-lg btn-primary btn-block " type="submit">login</button>
						</div>
						
						<p class="text-center mt-4">
							Don't have account? <a
								href="<spring:url value='/customer/register'/>">Sign up</a>
						</p>
						<br> <br>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

