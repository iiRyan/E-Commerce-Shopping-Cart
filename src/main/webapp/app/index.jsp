<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>



<meta charset="UTF-8">
<title>Shpoing-Cart</title>
</head>
<body>
	<%@include file="../includes/header.jsp"%>


	<div class="container">
		<div class="cart-header my-3">All Products</div>
		<div class="row">
			<div class="col-md-3">
				<div class="card w-100" style="width: 18rem;">
					<img class="card-img-top" src="/assets/img/1.jpg" alt="Card image cap">
					
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<h6 class="price">Price $33.4</h6>
						<h6 class="category">Category: some category</h6>
						<div class="mt-3 d-flex justify-content-between">
							<a href="#" class="btn btn-primary">Add to Cart</a> <a href="#"
								class="btn btn-primary">Buy Now</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="../includes/footer.jsp"%>