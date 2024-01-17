<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@include file="../includes/header.jsp"%>

<title>Orders</title>




<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<c:if test="${not empty msg}">
	<p class="text-center text-danger fs-4">${msg}</p>
</c:if>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div class="h-screen mt-12">

	<div
		class="max-w-md bg-gray-100 mx-auto shadow-lg rounded-lg  md:max-w-5xl">
		<h1 class="text-xl font-medium ">Orders</h1>
		<div
			class="relative text-center  overflow-x-auto shadow-md sm:rounded-lg">
			<table class="w-full mb-5 text-gray-500 ">
				<thead class="text-gray-700 uppercase bg-gray-50  ">
					<tr>
						<th scope="col" class="px-6 py-3">#</th>

						<th scope="col" class="px-6 py-3">Date</th>
						<th scope="col" class="px-6 py-3">Name</th>
						<th scope="col" class="px-6 py-3">Category</th>
						<th scope="col" class="px-6 py-3">Quantity</th>
						<th scope="col" class="px-6 py-3">Price</th>
						<th scope="col" class="px-6 py-3">Action</th>
					</tr>
				</thead>
				<c:forEach var="order" items="${orderList}" varStatus="status">
					<tbody>
						<tr class=" border-b ">
							<td>${status.index + 1}</td>
							<td>${order.date}</td>
							<td>${order.name}</td>
							<td>${order.category}</td>
							<td>${order.quantity}</td>
							<td>${order.price}</td>
							<td><a
								class="block mr-5 rounded-md bg-red-600 px-5 py-1.5 text-sm font-medium text-white transition hover:bg-red-700 hover:bg-indigo-700"
								href="${contextPath}/app/cancel-order?id=${order.orderId}">
									Cancel </a></td>

						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>

	</div>
</div>





<%@include file="../includes/footer.jsp"%>