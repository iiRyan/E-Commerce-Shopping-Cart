<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<%@include file="../includes/header.jsp"%>



<div class="container">


	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<c:set var="price" value="${requestScope.listOfPrices}" />
	<c:if test="${not empty msg}">
		<p class="text-center text-danger fs-4">${msg}</p>
	</c:if>


	<a href="${contextPath}/app/orders-list" class="mx-3 btn btn-primary">checkout</a>
<div class="d-flex py-3">Total Price:$${empty price ? '0' : price}</div>

	<table class="table table-light">

		<thead>
			<tr>
				<th scope="col">Name</th>
				<th scope="col">Category</th>
				<th scope="col">Price</th>
				<th scope="col">Buy Now</th>
				<th scope="col">Cancel</th>
			</tr>
		</thead>
		<c:forEach var="cart" items="${localCartList}">
			<tbody>
				<tr>
					<td>${cart.name}</td>
					<td>${cart.category}</td>
					<td>${cart.price}</td>
					<td>
						<form action="${contextPath}/app/order-now" method="post" class="form-inlin">
							<input type="hidden" name="id" value=${cart.id} class="form-input">
							<div  class="form-group d-flex justify-content-between w-50">
					
								<a href="${contextPath}/app/inc-dec?action=inc&id=${cart.id}" class="btn btn-sm btn-incre"><i class="fas fa-plus-square"></i></a>
									 <input type="text"name="quantity" class="form-control" value="${cart.quantity}"  readonly>
								<a href="${contextPath}/app/inc-dec?action=dec&id=${cart.id}" class="btn btn-sm btn-decre"><i class="fas fa-minus-square"></i></a><button class="btn btn-success btn-sm">Buy</button>
							</div>
						</form>
					</td>
					<td><a href="${contextPath}/app/remove-art-item?id=${cart.id}" class="btn btn-sm btn-danger">Remove</a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>

</div>



<%@include file="../includes/footer.jsp"%>
