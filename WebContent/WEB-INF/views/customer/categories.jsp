<!-- ========================= SECTION PAGETOP ========================= -->
<section class="section-pagetop bg">
	<div class="container">
		<h3>${requestScope.mesg}</h3>

		<h2 class="title-page">Category products</h2>

	</div>
	<!-- container //  -->
</section>
<!-- ========================= SECTION INTRO END// ========================= -->

<!-- ========================= SECTION CONTENT ========================= -->
<section class="section-content padding-y">
	<div class="container">

		<div class="row">
			<aside class="col-md-3">

				<div class="card">
					<article class="filter-group">
						<header class="card-header">
							<a href="#" data-toggle="collapse" data-target="#collapse_1"
								aria-expanded="true" class=""> <i
								class="icon-control fa fa-chevron-down"></i>
								<h6 class="title">Product type</h6>
							</a>
						</header>
						<div class="filter-content collapse show" id="collapse_1" style="">
							<div class="card-body">

								<c:forEach var="s" items="${sessionScope.category_list}">
									<ul class="list-menu">
										<li><a
											href="<spring:url value='/product/listbycategory?categoryName=${s.categoryName}'/>">
												${s.categoryName} </a></li>
									</ul>
								</c:forEach>
							</div>
							<!-- card-body.// -->
						</div>
					</article>

				</div>
				<!-- card.// -->

			</aside>
			<!-- col.// -->
			<main class="col-md-9"> <c:if
				test="${requestScope.product_list == null}">
				<p>No product Available for selected category</p>
			</c:if> <c:if test="${requestScope.product_list != null}">


				<div class="row">
					<c:forEach var="p" items="${requestScope.product_list}">
						<c:if test="${p.quantity > 0}">

							<div class="col-md-4">
								<figure class="card card-product-grid">
									<div class="img-wrap">
										<img src="${images}/products/${p.imageUrl}">
									</div>
									<!-- img-wrap.// -->
									<figcaption class="info-wrap">
										<div class="fix-height">
											<a href="#" class="title">${p.productName}</a>
											<div class="price-wrap mt-2">
												<span class="price">Price: ${p.price}</span> <span
													class="weight">Weight: ${p.weight}</span>
											</div>
										</div>

										<form action="<spring:url value='/product/details' />"
											method="post">
											<input type="hidden" name="productId" value="${p.id}" />
											<button type="submit" class="btn btn-block btn-primary">Details</button>
										</form>

									</figcaption>
								</figure>
							</div>
						</c:if>
					</c:forEach>
					<!-- col.// -->
				</div>
			</c:if> <!-- row end.// --> </main>
			<!-- col.// -->

		</div>

	</div>
	<!-- container .//  -->
</section>
<!-- ========================= SECTION CONTENT END// ========================= -->