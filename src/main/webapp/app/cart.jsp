<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



    <%@include file="../includes/header.jsp" %>



  <div class="container">
      
        <c:set var="cartList" value="${requestScope.localCartList}" />
        
        <c:set var="cartList" value="${requestScope.listOfPrices}" />
        <c:if test="${not empty msg} }"></c:if>
						<p class="text-center text-danger fs-4">${msg}</p>
						
						<c:if test="${not empty cartList} "></c:if>
       <div class="d-flex py-3">Total Price:$${cartList}</div> <a href="#" class="mx-3 btn btn-primary">checkout</a>
       
      
       <table class="table table-light">
       
        <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Category</th>
                <th scope="col">Price</th>
                <th scope="col">Buy Now </th>
                <th scope="col">Canel</th>
            </tr>
        </thead>
         <c:forEach var="cart" items="${localCartList}">
        <tbody>
            <tr>
                <td>${cart.name}</td>
                <td>${cart.category}</td>
                <td>${cart.price}</td>
                <td>
                    <form action="" method="POST" class="form-inlin">
                        <input type="hidden" name="id" value="1" class="form-input">
                        <div class="form-goup d-flex justify-content-between">
                            <a href="#" class="btn btn-sm btn-incre"><i class="fas fa-plus-square"></i></a>
                            <input type="text" name="quantity" class="form-control" value="1" readonly>
                            <a href="#" class="btn btn-sm btn-decre"><i class="fas fa-minus-square"></i></a>
                        </div>
                    </form>
                </td>
                <td><a href="#" class="btn btn-sm btn-danger">Remove</a></td>
            </tr>
        </tbody>
          </c:forEach>
       </table>
     
    </div>



	<%@include file="../includes/footer.jsp" %>
