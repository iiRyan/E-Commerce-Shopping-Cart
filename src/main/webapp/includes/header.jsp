  <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.ecommerce.beans.Cart"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css" />

 <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap" rel="stylesheet" />
    
     <!-- Font Awsome -->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" 
      integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
       crossorigin="anonymous" referrerpolicy="no-referrer" />
    
    <!-- Sweet Alert -->
       <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
     <!-- CSS -->
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@sweetalert2/theme-dark@3/dark.css">
   
   <!-- JS -->
   <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
    
<style><%@include file="style.css"%></style>

<ul id="nav" class="nav justify-content-center">
	
			
			<c:set var="contextPath" value="${pageContext.request.contextPath}" />
			<!-- If the user not logged in show login & Register links -->
			<c:if test="${ empty user }">
			<li class="nav-item">
			  <a class="nav-link active logo" aria-current="page" href="${contextPath}/login.jsp">E-Commerce Shoping Cart</a>
			</li>
				 <li class="nav-item">
					<a class="nav-link active" aria-current="page" href="${contextPath}/login.jsp">Login</a>
				  </li>
				  <li class="nav-item">
					<a class="nav-link active"  href="${contextPath}/register.jsp">Register</a>
				  </li>
				   </c:if>
				  
				   
				   
			<!-- If the User Object is not null "Logged in"  show his name-->
		<c:if test="${not empty user }">
				<li class="nav-item">
				 		 <a class="nav-link active logo" aria-current="page" href="${contextPath}/app/index">E-Commerce Shoping Cart</a>
				</li>
				
				<c:set var="cartList" value="${sessionScope.localCartList}" />
				 <li class="nav-item active">
		        		<a class="nav-link" href="${contextPath}/app/cart-list">Cart<span class="badge bg-danger px-1">${localCartList.size()}</span></a>
		     	 </li>
		      
			    <li class="nav-item">
						<a class="nav-link active" aria-current="page" style="color: #414a67">Welcome ${user.name}</a>
				</li>
					  
					  <!-- If the User Object is not null "Logged in"  show add budget button-->
				 <li class="nav-item">
						<a class="nav-link active"  href="${contextPath}/logout">Logout</a>
				  </li>
		</c:if>
				
		</ul>
		  
		  
		  
		  