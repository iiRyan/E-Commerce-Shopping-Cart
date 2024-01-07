  <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css" />

 <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap" rel="stylesheet" />
    
    <!-- Sweet Alert -->
       <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    
    
<style><%@include file="style.css"%></style>

<ul id="nav" class="nav justify-content-center">
	
			
			
			<!-- If the user not logged in show login & Register links -->
			<c:if test="${ empty user }">
			<li class="nav-item">
			  <a class="nav-link active logo" aria-current="page" href="<%=request.getContextPath()%>/login.jsp">E-Commerce Shoping Cart</a>
			</li>
				 <li class="nav-item">
					<a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/login.jsp">Login</a>
				  </li>
				  <li class="nav-item">
					<a class="nav-link active"  href="<%=request.getContextPath()%>/register.jsp">Register</a>
				  </li>
				   </c:if>
				  
				   
				   
			<!-- If the User Object is not null "Logged in"  show his name-->
				<c:if test="${not empty user }">
				<li class="nav-item">
			  <a class="nav-link active logo" aria-current="page" href="<%=request.getContextPath()%>/app/index.jsp">E-Commerce Shoping Cart</a>
			</li>
				  <li class="nav-item active">
	        <a class="nav-link" href="<%=request.getContextPath()%>/app/cart.jsp"><i class="fa-solid fa-plus"></i> Cart</span></a>
	      </li>
	      
				<li class="nav-item">
					<a class="nav-link active" aria-current="page" style="color: #414a67">Welcome ${user.name}</a>
				  </li>
				  
				  <!-- If the User Object is not null "Logged in"  show add budget button-->
				  <li class="nav-item">
					<a class="nav-link active"  href="<%=request.getContextPath()%>/logout">Logout</a>
				  </li>
				   </c:if>
				
		  </ul>