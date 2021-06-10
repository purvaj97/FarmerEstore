<!-- ========================= SECTION CONTENT ========================= -->
<section class="section-content padding-y">
	<div class="container">

		<div class="row">
			<aside class="col-md-3">
				<ul class="list-group">
					<a class="list-group-item active" href="#overview'/>"> Account overview</a>
					<a class="list-group-item"
					href="<spring:url value='/seller/update?sellerId=${seller_details.sellerId}'/>">
						Update Profile</a>
					<a class="list-group-item"
						href="<spring:url value='/seller/logout'/>">Log Out</a>

				</ul>
			</aside>
			<!-- col.// -->
			<main class="col-md-9">

			<article class="card mb-3">
				<div class="card-body">

					<figure class="icontext">
						<div class="icon"></div>
						<div class="text">
							<strong> Name: ${seller_details.firstName}
								${seller_details.lastName} </strong> <br> Email:
							${seller_details.email} <br>
						</div>
					</figure>
					<hr>
					<p>
						My address: <br> ${seller_details.address} &nbsp;
					</p>
				</div>
				<!-- card-body .// -->
			</article>
			<!-- card.// -->
		</div>
		<button>
			<a href="<spring:url value='/seller/task'/>">Back</a>
		</button>
	</div>
	<!-- container .//  -->
</section>
<!-- ========================= SECTION CONTENT END// ========================= -->