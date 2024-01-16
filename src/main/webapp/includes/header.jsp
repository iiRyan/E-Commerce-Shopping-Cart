
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.ecommerce.beans.Cart"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!doctype html>
<html>
<head>

		
		<!-- Google Fonts -->
		<link
			href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap"
			rel="stylesheet" />
		
		<!-- Font Awsome -->
		<link rel="stylesheet"
			href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
			integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
			crossorigin="anonymous" referrerpolicy="no-referrer" />
		
		<!-- Sweet Alert -->
		<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
		<link rel="stylesheet"
			href="https://cdn.jsdelivr.net/npm/@sweetalert2/theme-dark@3/dark.css">
		
		<!-- JS -->
		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
		
		<!-- TailwindCss -->
		<link
			href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.2.1/flowbite.min.css"
			rel="stylesheet" />
			
			<script src="https://cdn.tailwindcss.com"></script>
		</head>
		<%-- <style><%@include file="style.css"%></style> --%>

<body>

		
<!-- component -->
<!-- follow me on twitter @asad_codes -->

<div class="flex flex-wrap h-screen ">
  <section class="relative mx-auto">
  
 			 <!-- JSTL code -->
			<c:set var="contextPath" value="${pageContext.request.contextPath}" />
			<c:set var="userInfo" value="${sessionScope.user}" />
			 <c:set var="cartList" value="${sessionScope.cartList}" />
         <c:set var="cartSize" value="${empty sessionScope['sessionCart-list'] ? '' : fn:length(sessionScope['sessionCart-list'])}" />
         
      <!-- navbar -->
    <nav class="flex justify-between bg-indigo-600 text-white w-screen">
      <div class="px-5 xl:px-12 py-6 flex w-full items-center">
        <a class="text-3xl font-bold font-heading" href="${contextPath}/app/index">
          <!-- <img class="h-9" src="logo.png" alt="logo"> -->
         Shopping-Cart
        </a>
        
        
        <!-- Nav Links -->
        <c:if test="${ not empty user }">
        <ul class="hidden md:flex px-4 mx-auto font-semibold font-heading space-x-12">
          <li><a class="hover:text-gray-200" href="${contextPath}/app/index">Home</a></li>
          <li><a class="hover:text-gray-200" href="${contextPath}/app/cart-list">Cart
          <c:if test="${ not empty cartSize }">
           <span class="center relative inline-block select-none whitespace-nowrap rounded-lg bg-red-500 py-2 px-3.5 align-baseline font-sans text-xs
            font-bold uppercase leading-none text-white">${cartSize}</span></c:if>
           </a></li>
           
          <li><a class="hover:text-gray-200" href="#">About Us</a></li>
          <li><a class="hover:text-gray-200" href="#">Welcome ${userInfo.name} </a></li>
        </ul>
        </c:if>
      </div>
      <c:if test="${ not empty user }">
      <a class="hover:text-gray-200 self-center mr-12 font-semibold font-heading" href="${contextPath}/logout">
         Logout
      </a>
      </c:if>
     
     <!-- If the user NOT logged in show Login and Register links -->
        <c:if test="${ empty user }">
       <a class="hover:text-gray-200 self-center mr-12 font-semibold font-heading " href="${contextPath}/login.jsp">
         Login
      </a>
      <a class=" hover:text-gray-200 self-center mr-12 font-semibold font-heading" href="${contextPath}/register.jsp">
         Register
      </a>
       </c:if>
    </nav>
    
  



	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.2.1/flowbite.min.js"></script>