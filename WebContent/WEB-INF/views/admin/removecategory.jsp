
<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					<div>
						<h4>Category list</h4>
						
						<h3 style="color: red;"> ${requestScope.msg}</h3>
						<form method="post" action="<spring:url value='/admin/removecategory' />" >
                      	<table style=" margin: auto;" border="1">

							<c:forEach var="category" items="${requestScope.category_list1}">
								<tr>
									<td>${category.categoryName}</td>
									<td><input type="hidden" name="categoryId"  value="${category.categoryid}"></td>
									<td><button type="submit">Delete</a></td>

								</tr>
							</c:forEach>
					
						</table>
						<button><a href="<spring:url value='/admin/task'/>">back</a></button>
									
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
