<div>

	<div class="col-md-6">
		<figure class="card card-product-grid">
			<div class="img-wrap">
				<img src="${images}/products/${product.imageUrl}">
			</div>
			<!-- img-wrap.// -->
			<figcaption class="info-wrap">
				<div class="fix-height">
					<a href="#" class="title">${product.productName}</a>
					<div class="price-wrap mt-2">
						<span class="price">Price: ${product.price}</span>&nbsp; &nbsp; <span
							class="weight">Weight: ${product.weight}</span>
						<!-- <del class="weight">${p.weight}</del> -->
					</div>
					<p class="product-description">${product.description}</p>
					<!-- price-wrap.// -->
				</div>
				<a
					href="<spring:url value='/customer/cart/addtocart?productId=${product.id}'/>"
					class="btn btn-block btn-primary">Add to Cart </a>
			</figcaption>
		</figure>
		<button><a href="<spring:url value='/customer/categories'/>">Back</a></button>
	</div>

</div>