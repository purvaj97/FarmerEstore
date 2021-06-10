
<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">

			<h5 class="card-title text-center">${requestScope.mesg}</h5>

			<img src="${images}/error.png" height="300" weight="400" />

			<button class="btn btn-lg btn-block text-uppercase">
				<a href="<spring:url value='/seller/task'/>">Retry</a>
			</button>

			
		</div>
	</div>
</div>
