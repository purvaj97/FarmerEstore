

<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					<h5 class="card-title text-center">Sign In
						${requestScope.mesg}</h5>
					<form class="form-signin" method="post">
						<div class="form-label-group">
							<label for="email">Email </label> <input type="text" id="email"
								name="email" class="form-control" placeholder="Email address"
								required autofocus>
						</div>

						<div class="form-label-group">
							<label for="inputPassword">Password</label> <input
								type="password" id="password" name="password"
								class="form-control" placeholder="Password" required>
						</div>

						<button class="btn btn-lg btn-primary btn-block " type="submit">Sign
							in</button>

						<p class="text-center mt-4">
							Don't have account? <a
								href="<spring:url value='/seller/register'/>">Sign up</a>
						</p>
						<br>
						<br>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

