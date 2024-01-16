<%@page import="java.util.*"%>
<%@page import="com.ecommerce.dao.ProductDao"%>
<%@page import="com.ecommerce.beans.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<meta charset="UTF-8">
<title>Shopping-Cart</title>
</head>
<body>

	<%@include file="../includes/header.jsp"%>

	<!-- Get the  -->

	<c:set var="cartList" value="${requestScope.localCartList}" />
	<c:set var="status" value="${requestScope['status']}" />
	<input type="hidden" id="status" value="${status}" />

	<c:if test="${empty products}">There is no proucts </c:if>
    
	
	
	
	
	 <div class="flex justify-center items-center min-h-screen mt-10">
 <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
 <c:forEach var="product" items="${products}">
 <div class="w-72 bg-white shadow-md rounded-xl duration-500 hover:scale-105 hover:shadow-xl" >
 <a href="add-to-cart?id=${product.id}">
                <img src="../assets/img/${product.image}"
                    alt="Product" class="h-80 w-72 object-cover rounded-t-xl" />
                <div class="px-4 py-3 w-72">
                    <span class="text-gray-400 mr-3 uppercase text-xs">${product.category}</span>
                    <p class="text-lg font-bold text-black truncate block capitalize">${product.name}</p>
                    <div class="flex items-center">
                        <p class="text-lg font-semibold text-black cursor-auto my-3">$${product.price}</p>
                        <del>
                            <p class="text-sm text-gray-600 cursor-auto ml-2">$199</p>
                        </del>
                        <div class="ml-auto"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20"
                                fill="currentColor" class="bi bi-bag-plus" viewBox="0 0 16 16">
                                <path fill-rule="evenodd"
                                    d="M8 7.5a.5.5 0 0 1 .5.5v1.5H10a.5.5 0 0 1 0 1H8.5V12a.5.5 0 0 1-1 0v-1.5H6a.5.5 0 0 1 0-1h1.5V8a.5.5 0 0 1 .5-.5z" />
                                <path
                                    d="M8 1a2.5 2.5 0 0 1 2.5 2.5V4h-5v-.5A2.5 2.5 0 0 1 8 1zm3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4h-3.5zM2 5h12v9a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V5z" />
                            </svg>
                            </div>
                    </div>
                </div>
            </a>
 </div>
            
            </c:forEach>
        </div>
        <!--   🛑 Product card 1 - Ends Here  -->
	 
	 
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