<div>
	<!-- ========================= SECTION PAGETOP ========================= -->
	<section class="section-pagetop bg">
		<div class="container">
			<h3>${requestScope.mesg}</h3>

			<h2 class="title-page">Products List</h2>

		</div>
		<!-- container //  -->
	</section>
	<!-- ========================= SECTION INTRO END// ========================= -->

	<!-- ========================= SECTION CONTENT ========================= -->
	<div>

		<div class="container">
			<div class="row">
				<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
					<div class="card card-signin my-5">
						<div class="card-body">
							<div>
								<h3>${requestScope.mesg}</h3>
								<c:if test="${product_list == null}">
									<p>No Products added</p>
								</c:if>

								<c:if test="${product_list != null}">

									<table style="margin: auto;" border="1">

										<tr>
											<td>Product Name</td>
											<td>Weight</td>
											<td>Quantity</td>
											<td>Price</td>

											<td></td>
											<td></td>
										</tr>



										<div class="row">
											<c:forEach var="p" items="${product_list}">
												<tr>
													<td>${p.productName}</td>
													<td>${p.weight}</td>
													<td>${p.quantity}</td>
													<td>${p.price}</td>
													<td>
														<form action="<spring:url value='/product/update'/>"
															method="post">
															<input type="hidden" name="productId" value="${p.id}" />
															<button type="submit" class="btn btn-block btn-primary">Update</button>
														</form>
													</td>
													<td>
														<form action="<spring:url value='/product/delete'/>"
															method="post">
															<input type="hidden" name="productId" value="${p.id}" />
															<button type="submit" class="btn btn-block btn-danger">Delete</button>
														</form>
													</td>
												</tr>
											</c:forEach>
										</div>
									</table>
								</c:if>
								<button><a href="<spring:url value='/seller/task'/>">Back</a></button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>