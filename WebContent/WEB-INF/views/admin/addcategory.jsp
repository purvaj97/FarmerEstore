

<div class="container">
	<div class="row">
		<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
			<div class="card card-signin my-5">
				<div class="card-body">
				<h4>${requestscope.msg}</h4>
					<sf:form method="post" >
						<h1>Add Category</h1>

						<table style="margin: auto;">
							<tr>
							
							<tr>
								<td>Catagory Name:</td>
								<td><input name="categoryName" type="text" id="categoryName" /></td>
							</tr>
							
							<tr>
								<td></td>
								<td><input type="submit" value="Add" /></td>
							</tr>
							<td><button><a
										href="<spring:url value='/admin/task'/>">back</a></button></td>
									
								</tr>
						</table>
					</sf:form>
				</div>
			</div>
		</div>
	</div>
</div>

