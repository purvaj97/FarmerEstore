
<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					<div>
						<h4>Seller list</h4>

						<h3 style="color: red;">${requestScope.mesg}</h3>

						<table style="margin: auto;" border="1">

							<c:forEach var="s" items="${requestScope.seller_list}">
								<tr>
									<td>${s.firstName}${s.lastName}</td>
									<td>${s.address}</td>
									<td>${s.phoneNumber}</td>
									<td>${s.status}</td>
									<td><a
										href="<spring:url value='/seller/delete?sellerId=${s.sellerId}'/>">Delete</a></td>

									<td><a
										href="<spring:url value='/admin/verifyseller?sellerId=${s.sellerId}'/>">Verify</a></td>

								</tr>
							</c:forEach>
						</table>
						<button>
							<a href="<spring:url value='/admin/task'/>">back</a>
						</button>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
