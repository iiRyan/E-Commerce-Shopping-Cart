<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<title>Shopping Carts</title>
<%@include file="../includes/header.jsp"%>




<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<c:set var="price" value="${sessionScope.totalCartCost }" />
<c:if test="${not empty msg}">
	<p class="text-center text-danger fs-4">${msg}</p>
</c:if>

<c:set var="status" value="${requestScope['status']}" />
	<input type="hidden" id="status" value="${status}" />

<div class="min-h-screen">
	<div class="py-12">


		<div
			class="max-w-md mx-auto bg-gray-100 shadow-lg rounded-lg  md:max-w-5xl">
			<div class="md:flex ">
				<div class="w-full p-4 px-5 py-5">

					<div class="md:grid md:grid-cols-3 gap-2 ">

						<div class="col-span-2 p-5">

							<h1 class="text-xl font-medium ">Shopping Cart</h1>

							<c:if test="${not empty myCartList}">
							<c:forEach var="cart" items="${myCartList}">
							<c:set var="cart_id" value="${cart.cart_id}" />
								<div class="flex justify-between items-center mt-6 pt-6">
									<div class="flex  items-center">
										<img src="../assets/img/${cart.image}" width="60"
											class="rounded-full">

										<div class="flex flex-col ml-3">
											<span class="md:text-md font-medium">${cart.name}</span> <span
												class="text-xs font-light text-gray-400">${cart.category}</span>
										</div>
									</div>

									<form action="${contextPath}/app/order-now" method="post">
										<input type="hidden" name="id" value="${cart.id}">
										<div class="flex justify-center items-center">


											<div class="pr-8 flex ">

												<span class="font-semibold"><a
													href="${contextPath}/app/inc-dec?action=dec&id=${cart.id}"><i
														class="fas fa-minus-square text-indigo-600"></i></a></span> <input
													type="text"
													class="focus:outline-none bg-gray-100 border h-6 w-8 rounded text-sm px-2 mx-2"
													name="quantity" value="${cart.quantity}" readonly>
												<span class="font-semibold"><a
													href="${contextPath}/app/inc-dec?action=inc&id=${cart.id}"><i
														class="fas fa-plus-square text-indigo-600"></i></a></span>

											</div>

											<div class="pr-8">

												<span class="text-xs font-medium">$${cart.price}</span>
											</div>

											<div>

												<a href="${contextPath}/app/remove-art-item?product_id=${cart.id}"
													class="text-red-600 hover:bg-red-700"> <svg
														xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16 16"
														fill="currentColor" class="w-4 h-4">
 									 <path fill-rule="evenodd"
															d="M5 3.25V4H2.75a.75.75 0 0 0 0 1.5h.3l.815 8.15A1.5 1.5 0 0 0 5.357 15h5.285a1.5 1.5 0 0 0 1.493-1.35l.815-8.15h.3a.75.75 0 0 0 0-1.5H11v-.75A2.25 2.25 0 0 0 8.75 1h-1.5A2.25 2.25 0 0 0 5 3.25Zm2.25-.75a.75.75 0 0 0-.75.75V4h3v-.75a.75.75 0 0 0-.75-.75h-1.5ZM6.05 6a.75.75 0 0 1 .787.713l.275 5.5a.75.75 0 0 1-1.498.075l-.275-5.5A.75.75 0 0 1 6.05 6Zm3.9 0a.75.75 0 0 1 .712.787l-.275 5.5a.75.75 0 0 1-1.498-.075l.275-5.5a.75.75 0 0 1 .786-.711Z"
															clip-rule="evenodd" />
								</svg>
												</a>
											</div>

										</div>
									</form>

								</div>
							</c:forEach>
								
							</c:if>

							<div class="flex justify-between items-center mt-6 pt-6 border-t">
								<div class="flex items-center">
            					<i class="fa fa-arrow-left text-sm pr-2"></i>
            					<a href="${contextPath}/app/index"><span class="text-md  font-medium text-blue-500">Continue Shopping</span></a>
            				</div>
								<div class="flex justify-center items-end">
									<span class="text-sm font-medium text-gray-400 mr-1">Subtotal:</span>
									<span class="text-lg font-bold text-gray-800 "> Total
										Price:$${empty price ? '0' : price}</span>

								</div>

							</div>
						</div>
						<div class=" p-5  rounded overflow-visible">


							<div
								class="overflow-visible flex justify-between items-center mt-2">
								<img src="../assets/img/buy-now.svg" width="">
							</div>
						<a href="${contextPath}/app/check-out?cart_id=${empty cart_id ? 0 : cart_id}">
   						 <button class="h-12 w-full bg-indigo-600 rounded focus:outline-none mt-5 text-white hover:bg-indigo-700"> Check Out</button>
       						</a>				 
   													 


						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>


	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status == "ListEmpty") {

			Swal.fire({
				position : "center",
				icon : "warning",
				title : "buy something first ^_*.",
				showConfirmButton : false,
				timer : 1500
			});
		} 
	</script>
	<script src="js/main.js"></script>

<%@include file="../includes/footer.jsp"%>
