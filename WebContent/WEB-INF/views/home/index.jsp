<%@include file="../includes/header.jsp"%>

<div class="wrapper">
	<!-- navigation -->
	<%@include file="../includes/nav.jsp"%>

	<!-- Content here -->
	<div class="content">

		<c:if test="${clickHome == true}">
			<!-- Carousel-->
    

			<!DOCTYPE html>
			<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img
						src="http://zilokart.com/wp-content/uploads/2016/11/grofers15.jpg"
						alt="img1" style="width: 100%;" height="1200px">
				</div>

				<div class="item">
					<img
						src="https://images.freekaamaal.com/store_desc_images/1515145891.jpg"
						alt="img2" style="width: 100%;">
				</div>

				<div class="item">
					<img
						src="https://miro.medium.com/max/1150/1*J_m_f9FZcvmMithmQo9s-Q.jpeg"
						alt="img3" style="width: 100%;">


				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>

</body>
			</html>
			<!-- /.carousel -->
			<div class="container marketing">
				<!-- Three columns of text below the carousel -->
				<div class="row">
					<div class="col-lg-4">
						<img class="img-circle"
							src="${images}/products/wheet.jpg"
							alt="Generic placeholder image" width="140" height="140">
						<h2>About Us</h2>
						<p>E-Grocers is a one-stop supermarket chain that aims to
							offer customers a wide range of basic home and personal products
							under one roof. Each store stocks home utility products -
							including food, toiletries, beauty products, garments,
							kitchenware, bed and bath linen, home appliances and more -
							available at competitive prices that our customers appreciate.
							Our core objective is to offer customers good products at great
							value.</p>
						<p>
							<a class="btn btn-default" href="#" role="button">View
								details &raquo;</a>
						</p>
					</div>
					<!-- /.col-lg-4 -->
					<div class="col-lg-4">
						<img class="img-circle"
							src="${images}/products/wheet.jpg"
							alt="Generic placeholder image" width="140" height="140">
						<h2>Feedback</h2>
						<p>We encourage all our valued stakeholders to share their
							experience or concern with us.</p>
						<p>
							<a class="btn btn-default" href="#" role="button">View
								details &raquo;</a>
						</p>
					</div>
					<!-- /.col-lg-4 -->
					<div class="col-lg-4">
						<img class="img-circle"
							src="${images}/products/wheet.jpg"
							alt="Generic placeholder image" width="140" height="140">
						<h2>Terms and Conditions</h2>
						<p>All the text and trademarks displayed on this site are
							owned by Avenue Supermarts Limited (ASL). You may print copies of
							the information on this site, or store the data on your computer,
							for your private use. You may not distribute text or graphics to
							others without the express written consent of ASL. Nor may you
							without our permission, copy and distribute this information on
							any other server, or modify or reuse text or trademarks on this
							or any another system.</p>
						<p>
							<a class="btn btn-default" href="#" role="button">View
								details &raquo;</a>
						</p>
					</div>
					<!-- /.col-lg-4 -->
				</div>
				<!-- /.row -->
			</div>

		</c:if>

		<!-- General pages -->

		<c:if test="${clickLogin == true}">
			<%@include file="login.jsp"%>
		</c:if>

		<c:if test="${clickAbout==true}">
			<%@include file="about.jsp"%>
		</c:if>


		<!--=========================== seller pages============== -->

		<c:if test="${sellerLogin == true}">
			<%@include file="../seller/login.jsp"%>
		</c:if>

		<c:if test="${sellerRegister == true}">
			<%@include file="../seller/register.jsp"%>
		</c:if>

		<c:if test="${seller_details != null}">
			<c:if test="${sellerAccount == true}">
				<%@include file="../seller/account.jsp"%>
			</c:if>

		</c:if>

		


		<c:if test="${ordersList == true}">
			<%@include file="../seller/orderslist.jsp"%>
		</c:if>

		<c:if test="${productListSeller == true}">
			<%@include file="../seller/productlist.jsp"%>
		</c:if>

		<c:if test="${sellerTask == true}">
			<%@include file="../seller/task.jsp"%>
		</c:if>

		<c:if test="${addProduct == true}">
			<%@include file="../product/addproduct.jsp"%>
		</c:if>

		<c:if test="${uploadImage == true}">
			<%@include file="../product/uploadimage.jsp"%>
		</c:if>

		<c:if test="${errorinseller == true}">
			<%@include file="../seller/error.jsp"%>
		</c:if>

		<c:if test="${sellerUpdate == true}">
			<%@include file="../seller/update.jsp"%>
		</c:if>

		<!-- ======================= Customer pages ========================-->

		<c:if test="${customerLogin == true}">
			<%@include file="../customer/login.jsp"%>
		</c:if>

		<c:if test="${customerRegister == true}">
			<%@include file="../customer/register.jsp"%>
		</c:if>

		<c:if test="${customer_details != null}">

			<c:if test="${showCategories == true}">
				<%@include file="../customer/categories.jsp"%>
			</c:if>

			<c:if test="${productList == true}">
				<%@include file="../customer/categories.jsp"%>
			</c:if>

			<c:if test="${productDetails == true}">
				<%@include file="../product/details.jsp"%>
			</c:if>

			<c:if test="${customerAccount == true}">
				<%@include file="../customer/account.jsp"%>
			</c:if>

			<c:if test="${customerUpdate == true}">
				<%@include file="../customer/update.jsp"%>
			</c:if>
		</c:if>

		<!--=========================== product pages============== -->

		<c:if test="${addproduct == true}">
			<%@include file="../product/addproduct.jsp"%>
		</c:if>

		<c:if test="${updateProduct == true}">
			<%@include file="../product/updateproduct.jsp"%>
		</c:if>

		<!--===================== Cart pages ===================== -->

		<c:if test="${showCart == true}">
			<%@include file="../customer/cart.jsp"%>
		</c:if>

		<!-- ========== Payment and order ========== -->

		<c:if test="${showPaymentPage == true}">
			<%@include file="../orders/payment.jsp"%>
		</c:if>

		<c:if test="${placedOrder == true}">
			<%@include file="../orders/placedorders.jsp"%>
		</c:if>
		<!--===================== Admin pages ===================== -->

		<c:if test="${adminLogin == true}">
			<%@include file="../admin/login.jsp"%>
		</c:if>
		<c:if test="${adminTask == true}">
			<%@include file="../admin/task.jsp"%>
		</c:if>
		<c:if test="${customerList == true}">
			<%@include file="../admin/customerList.jsp"%>
		</c:if>
		<c:if test="${sellerList == true}">
			<%@include file="../admin/sellerList.jsp"%>
		</c:if>
		<c:if test="${addCategory == true}">
			<%@include file="../admin/addcategory.jsp"%>
		</c:if>
		<c:if test="${removeCategory == true}">
			<%@include file="../admin/removecategory.jsp"%>
		</c:if>
		<c:if test="${errorinAdmin == true}">
			<%@include file="../admin/error.jsp"%>
		</c:if>


	</div>

	<%@ include file="../includes/footer.jsp"%>
</div>