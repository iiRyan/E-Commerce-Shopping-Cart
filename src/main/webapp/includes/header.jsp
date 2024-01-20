
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
			href="https://cdn.jsdelivr.net/npm/@sweetalert2/theme-@3/.css">
		
		<!-- JS -->
		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
		
		<!-- TailwindCss -->
		<link
			href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.2.1/flowbite.min.css"
			rel="stylesheet" />
			
			<script src="https://cdn.tailwindcss.com"></script>
		</head>
		 <style><%@include file="style.css"%></style> 

<body>

		
<!-- component -->
<!-- follow me on twitter @asad_codes -->

  
 			 <!-- JSTL code -->
			<c:set var="contextPath" value="${pageContext.request.contextPath}" />
			<c:set var="userInfo" value="${sessionScope.user}" />
			<c:set var="cartList" value="${sessionScope.myCartList}" />
         	<c:set var="cartSize" value="${empty sessionScope['myCartList'] ? '' : fn:length(sessionScope['myCartList'])}" />
         
      <!-- navbar -->
   <div id="header">

    <header class="bg-gray-900">
        <div class="mx-auto flex h-16 max-w-screen-xl items-center gap-8 px-4 sm:px-6 lg:px-8">
          <a class="block text-white  :text-teal-300" href="${contextPath}/app/index">
            <span class="sr-only">Home</span>
           <img class="h-12" alt="" src="../assets/img/logo.png">
              <path
                d="M0.41 10.3847C1.14777 7.4194 2.85643 4.7861 5.2639 2.90424C7.6714 1.02234 10.6393 0 13.695 0C16.7507 0 19.7186 1.02234 22.1261 2.90424C24.5336 4.7861 26.2422 7.4194 26.98 10.3847H25.78C23.7557 10.3549 21.7729 10.9599 20.11 12.1147C20.014 12.1842 19.9138 12.2477 19.81 12.3047H19.67C19.5662 12.2477 19.466 12.1842 19.37 12.1147C17.6924 10.9866 15.7166 10.3841 13.695 10.3841C11.6734 10.3841 9.6976 10.9866 8.02 12.1147C7.924 12.1842 7.8238 12.2477 7.72 12.3047H7.58C7.4762 12.2477 7.376 12.1842 7.28 12.1147C5.6171 10.9599 3.6343 10.3549 1.61 10.3847H0.41ZM23.62 16.6547C24.236 16.175 24.9995 15.924 25.78 15.9447H27.39V12.7347H25.78C24.4052 12.7181 23.0619 13.146 21.95 13.9547C21.3243 14.416 20.5674 14.6649 19.79 14.6649C19.0126 14.6649 18.2557 14.416 17.63 13.9547C16.4899 13.1611 15.1341 12.7356 13.745 12.7356C12.3559 12.7356 11.0001 13.1611 9.86 13.9547C9.2343 14.416 8.4774 14.6649 7.7 14.6649C6.9226 14.6649 6.1657 14.416 5.54 13.9547C4.4144 13.1356 3.0518 12.7072 1.66 12.7347H0V15.9447H1.61C2.39051 15.924 3.154 16.175 3.77 16.6547C4.908 17.4489 6.2623 17.8747 7.65 17.8747C9.0377 17.8747 10.392 17.4489 11.53 16.6547C12.1468 16.1765 12.9097 15.9257 13.69 15.9447C14.4708 15.9223 15.2348 16.1735 15.85 16.6547C16.9901 17.4484 18.3459 17.8738 19.735 17.8738C21.1241 17.8738 22.4799 17.4484 23.62 16.6547ZM23.62 22.3947C24.236 21.915 24.9995 21.664 25.78 21.6847H27.39V18.4747H25.78C24.4052 18.4581 23.0619 18.886 21.95 19.6947C21.3243 20.156 20.5674 20.4049 19.79 20.4049C19.0126 20.4049 18.2557 20.156 17.63 19.6947C16.4899 18.9011 15.1341 18.4757 13.745 18.4757C12.3559 18.4757 11.0001 18.9011 9.86 19.6947C9.2343 20.156 8.4774 20.4049 7.7 20.4049C6.9226 20.4049 6.1657 20.156 5.54 19.6947C4.4144 18.8757 3.0518 18.4472 1.66 18.4747H0V21.6847H1.61C2.39051 21.664 3.154 21.915 3.77 22.3947C4.908 23.1889 6.2623 23.6147 7.65 23.6147C9.0377 23.6147 10.392 23.1889 11.53 22.3947C12.1468 21.9165 12.9097 21.6657 13.69 21.6847C14.4708 21.6623 15.2348 21.9135 15.85 22.3947C16.9901 23.1884 18.3459 23.6138 19.735 23.6138C21.1241 23.6138 22.4799 23.1884 23.62 22.3947Z"
                fill="currentColor"
              />
            </svg>
          </a>
      
          <div class="flex flex-1 items-center justify-end md:justify-between">
            <nav aria-label="Global" class="hidden md:block">
              <ul class="flex items-center text-sm text-white sm:text-center gap-6 text-sm">
                <li>
                  <a
                    class=" transition  :text-white :hover:text-white/75"
                    href="${contextPath}/app/index"
                  >
                    Home
                  </a>
                </li>
      
      				<li>
                  <a
                    class=" transition hover:text-gray-500/75 :text-white :hover:text-indigo-700"
                    href="${contextPath}/about.jsp"
                  >
                    About Us
                  </a>
                </li>
                
                <c:if test="${ not empty user }">
                <li>
                  <a
                    class=" transition hover:text-gray-500/75 :text-white :hover:text-indigo-700"
                   href="${contextPath}/app/cart-list?user_id=${userInfo.id}"
                  >
                    Cart <c:if test="${ not empty cartSize }">
           <span class="center relative inline-block select-none whitespace-nowrap rounded-lg bg-red-500 py-1 px-1.5 align-baseline font-sans text-xs
            font-bold uppercase leading-none text-white">${cartSize}</span></c:if>
            
                  </a>
                </li>
      
                <li>
                  <a
                    class=" transition hover:text-gray-500/75 :text-white :hover:text-indigo-700"
                    href="${contextPath}/app/orders-list"
                  >
                    Orders
                  </a>
                </li>
       </c:if>
      
              </ul>
            </nav>
                <c:if test="${ not empty user }">
                
            <div class="flex items-center gap-4">
              <div class="sm:flex sm:gap-4">
                <p 
                  class="block rounded-md bg-indigo-600 px-5 py-2.5 text-sm font-medium text-white transition hover:bg-indigo-700 hover:bg-indigo-700 cursor-pointer">
                 Welcome ${userInfo.name}
                </p>
                <a
                  class="block rounded-md bg-indigo-600 px-5 py-2.5 text-sm font-medium text-white transition hover:bg-indigo-700 hover:bg-indigo-700"
                  href="${contextPath}/logout"
                >
                  Logout
                </a>
              </div>

            </div>
            
               </c:if>
            
      
       <c:if test="${ empty user }">
            <div class="flex items-center gap-4">
              <div class="sm:flex sm:gap-4">
                <a
                  class="block rounded-md bg-indigo-600 px-5 py-2.5 text-sm font-medium text-white transition hover:bg-indigo-700 hover:bg-indigo-700"
                  href="${contextPath}/login.jsp"
                >
                  Login
                </a>
      
                <a
                  class="hidden rounded-md bg-gray-100 px-5 py-2.5 text-sm font-medium text-white transition hover:bg-gray-900 bg-gray-800 :text-white :hover:text-indigo-600 sm:block"
                  href="${contextPath}/register.jsp"
                >
                  Register
                </a>
              </div>
      
                          </div>
            </c:if>
          </div>
        </div>
      </header>
      
 
   </div>
    
  



	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/2.2.1/flowbite.min.js"></script>