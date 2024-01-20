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

<div class="min-h-screen">
	<div class="py-12">

	    
    
        <div class='overflow-x-auto w-full'>
            <table class='mx-auto max-w-4xl w-full whitespace-nowrap rounded-lg bg-white divide-y divide-gray-300 overflow-hidden'>
                <thead class="bg-gray-900">
                    <tr class="text-white text-left">
                        <th class="font-semibold text-sm uppercase px-6 py-4">Date</th>
                        <th class="font-semibold text-sm uppercase px-6 py-4">Price</th>
                        <th class="font-semibold text-sm uppercase px-6 py-4">Status</th>
                        <th class="font-semibold text-sm uppercase px-6 py-4 text-center">Action</th>
                        <th class="font-semibold text-sm uppercase px-6 py-4"> </th>
                    </tr>
                </thead>
                <c:forEach var="order" items="${orderList}" varStatus="status">
                <tbody class="divide-y divide-gray-200">
                    <tr>
                        <td class="px-6 py-4">
                            <div class="flex items-center space-x-3">
                                <div class="inline-flex w-10 h-10"> ${status.index + 1} </div>
                                <div>
                                    <p>${order.order_date}</p>
                                    <!-- <p class="text-gray-500 text-sm font-semibold tracking-wide"> mirarodeo23@mail.com </p> -->
                                </div>
                            </div>
                        </td>
                        <td class="px-6 py-4">
                            <p class=""> ${order.total_cost} </p>
                           <!--  <p class="text-gray-500 text-sm font-semibold tracking-wide"> Development </p> -->
                        </td>
                        <td class="px-6 py-4 text-center"> <span class="text-white text-sm w-1/3 pb-1 bg-yellow-600 font-semibold px-2 rounded-full"> In progress </span> </td>
                        <td class="px-6 py-4 text-center"> <a href="${contextPath}/app/cancel-order?id=${order.id}" class="font-medium text-red-600 dark:text-red-500 hover:underline">remove</a> </td>               
                    </tr>
                    </c:forEach>                                      
                </tbody>
            </table>
        </div>
    </div>
</div>





<%@include file="../includes/footer.jsp"%>