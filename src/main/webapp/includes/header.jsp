
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

 <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap" rel="stylesheet" />
    
<style><%@include file="style.css"%></style>

<ul id="nav" class="nav justify-content-center">
	
			
			<li class="nav-item">
			  <a class="nav-link active logo" aria-current="page" href="<%=request.getContextPath()%>/index.jsp">E-Commerce Shoping Cart</a>
			</li>
			
			<!-- If the user not logged in show login & Register links -->
			
				 <li class="nav-item">
					<a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/login.jsp">Login</a>
				  </li>
				  <li class="nav-item">
					<a class="nav-link active"  href="<%=request.getContextPath()%>/register.jsp">Register</a>
				  </li>
				  
				   
				   
			<!-- If the User Object is not null "Logged in"  show his name-->
				
				  <li class="nav-item active">
	        <a class="nav-link" href="<%=request.getContextPath()%>/user/addExpenses.jsp"><i class="fa-solid fa-plus" style="color: #ffffff;"></i> Add New Budget</span></a>
	      </li>
	      
				<li class="nav-item">
					<a class="nav-link active" aria-current="page" href="#">Welcome ${loginUser.userName }</a>
				  </li>
				  
				  <!-- If the User Object is not null "Logged in"  show add budget button-->
				  <li class="nav-item">
					<a class="nav-link active"  href="<%=request.getContextPath()%>/logout">Logout</a>
				  </li>
				   
				
		  </ul>