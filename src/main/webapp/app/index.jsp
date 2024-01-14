<%@page import="java.util.*"%>
<%@page import="com.ecommerce.dao.ProductDao"%>
<%@page import="com.ecommerce.beans.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<meta charset="UTF-8">
<title>Shpoing-Cart</title>
</head>
<body>

	<%@include file="../includes/header.jsp"%>
	
	<!-- Get the  -->
	
	<c:set var="cartList" value="${requestScope.localCartList}" />
	<c:set var="status" value="${requestScope['status']}" />
	<input type="hidden" id="status" value="${status}" />

	<div class="container">
		<div class="row">
			<div class="container">
				<div class="card-header my-3">All Products</div>
				<div class="row">
					<c:forEach var="product" items="${products}">
						<div class="col-md-3 my-3">
							<div class="card h-100">
								<img class="card-img-top" src="../assets/img/${product.image}"
									alt="Card image cap">
								<div
									class="card-body d-flex flex-column justify-content-between">
									<h5 class="card-title">${product.name}</h5>
									<h6 class="price">Price: $${product.price}</h6>
									<h6 class="category">Category: ${product.category}</h6>
									<div class="mt-3 d-flex justify-content-between">
										<a class="btn btn-dark" href="add-to-cart?id=${product.id}">Add
											to Cart</a> <a class="btn btn-success"
											href="order-now?quantity=1&id=${product.id}">Buy Now</a>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					<c:if test="${empty products}">
                      There is no proucts
                  </c:if>
				</div>
			</div>
		</div>
	</div>



	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status == "isExist") {

			Swal.fire({
				  position: "center",
				  icon: "warning",
				  title: "Prduct Already Exist!",
				  showConfirmButton: false,
				  timer: 1500
				});
		} else if (status == "notExist") {

			Swal.fire({
				  position: "center",
				  icon: "success",
				  title: "Prduct has been added!",
				  showConfirmButton: false,
				  timer: 1500
				});
		}
	</script>
	<script src="js/main.js"></script>
</body>
<%@include file="../includes/footer.jsp"%>