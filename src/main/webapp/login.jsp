<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

<%@include file="includes/header.jsp"%>


	<div class="container p-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card ">
					<div id="card-header" class="card-header">
						<p class="text-center fs-3 ">Login Page</p>
						<p class="text-center text-danger fs-4">${msg}</p>
					</div>
					<div id="card-body" class="card-body">
						<form action="login" method="post">

							<div class="mb-3">
								<label>Email</label> <input type="email" name="email"
									class="form-control">
							</div>
							<div class="mb-3">
								<label>Password</label> <input type="password" name="password"
									class="form-control">
							</div>

							<button id="submit" class=" btn btn-dark col-md-12">Login</button>
							<div class="text-center m-2">
								Already have account?<a href="register.jsp"
									class="text-decoration-none text-secondary"> Login</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="includes/footer.jsp"%>