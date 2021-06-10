

<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
					<sf:form method="post" modelAttribute="product">
						<h1>Add Product</h1>

						<table style="margin: auto;">
							<tr>
								<td>Select Category:</td>
								<td><select name="category">
										<c:forEach var="cat" items="${requestScope.categoryList}">
											<option value="${cat.categoryName}">${cat.categoryName}</option>
										</c:forEach>
								</select></td>
								<td></td>
							</tr>
							<tr>
								<td>Product Name:</td>
								<td><sf:input path="productName"  required="true"/></td>
								<td><sf:errors path="productName" /></td>
							</tr>
							<tr>
								<td>Enter description:</td>
								<td><sf:input path="description" required="true" /></td>
								<td><sf:errors path="description" /></td>
							</tr>

							<tr>
								<td>Enter Price:</td>
								<td><sf:input path="price" required="true" /></td>
								<td><sf:errors path="price" /></td>
							</tr>
							<tr>
								<td>Enter Weight:</td>
								<td><sf:input path="weight" /></td>
								<td><sf:errors path="weight" /></td>
							</tr>
							<tr>
								<td>Enter Quantity:</td>
								<td><sf:input path="quantity" required="true" /></td>
								<td><sf:errors path="quantity" /></td>
							</tr>

							<tr>
								<td></td>
								<td><input type="submit" value="Add" /></td>
							</tr>
						</table>
						<button><a href="<spring:url value='/seller/task'/>">Back</a></button>
							
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>

