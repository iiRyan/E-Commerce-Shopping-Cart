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

	<c:if test="${empty products}">
                      There is no proucts
    </c:if>
    
	<div class="container mx-auto px-4">
   <div class="my-3">
       All Products
   </div>
   <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
       <c:forEach var="product" items="${products}">
       
       <div class="max-w-sm rounded overflow-hidden shadow-lg">
  <img class="w-full" src="../assets/img/${product.image}" alt="Sunset in the mountains">
  <div class="px-6 py-4">
    <div class="font-bold text-xl mb-2">${product.name}</div>
    <p class="text-gray-700 text-base">
      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatibus quia, nulla! Maiores et perferendis eaque, exercitationem praesentium nihil.
    </p>
  </div>
  <div class="px-6 pt-4 pb-2">
    <span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2">#photography</span>
    <span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2">#travel</span>
    <span class="inline-block bg-gray-200 rounded-full px-3 py-1 text-sm font-semibold text-gray-700 mr-2 mb-2">#winter</span>
  </div>
</div>

           <div class="card h-full">
               <img class="card-img-top" src="../assets/img/${product.image}" alt="Card image cap">
               <div class="card-body flex flex-col justify-between">
                  <h5 class="card-title">${product.name}</h5>
                  <h6 class="price">Price: $${product.price}</h6>
                  <h6 class="category">Category: ${product.category}</h6>
                  <div class="mt-3 flex justify-between">
                      <a class="btn btn-dark" href="add-to-cart?id=${product.id}">Add to Cart</a> 
                      <a class="btn btn-success" href="order-now?quantity=1&id=${product.id}">Buy Now</a>
                  </div>
               </div>
           </div>
       </c:forEach>
   </div>
   <c:if test="${empty products}">
       There is no products
   </c:if>
</div>

	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status == "isExist") {

			Swal.fire({
				position : "center",
				icon : "warning",
				title : "Prduct Already Exist!",
				showConfirmButton : false,
				timer : 1500
			});
		} else if (status == "notExist") {

			Swal.fire({
				position : "center",
				icon : "success",
				title : "Prduct has been added!",
				showConfirmButton : false,
				timer : 1500
			});
		}
	</script>
	<script src="js/main.js"></script>
</body>
<%@include file="../includes/footer.jsp"%>