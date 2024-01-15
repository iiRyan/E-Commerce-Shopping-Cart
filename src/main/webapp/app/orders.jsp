<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@include file="../includes/header.jsp"%>



<div class="container">


	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	
	<c:if test="${not empty msg}">
		<p class="text-center text-danger fs-4">${msg}</p>
	</c:if>

	<table class="table table-light">

		<thead>
			<tr>
				<th scope="col">Date</th>
				<th scope="col">Name</th>
				<th scope="col">Category</th>
				<th scope="col">Quantity</th>
				<th scope="col">Price</th>
				<th scope="col">Cancel</th>
			</tr>
		</thead>
		<c:forEach var="order" items="${orderList}">
			<tbody>
				<tr>
					<td>${order.date}</td>
					<td>${order.name}</td>
					<td>${order.category}</td>
					<td>${order.price}</td>
					<td>${order.quantity}</td>
					
					<td><a href="${contextPath}/app/cancel-order?id=${order.orderId}" class="btn btn-sm btn-danger">Cancel</a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>

</div>



<%@include file="../includes/footer.jsp"%>
