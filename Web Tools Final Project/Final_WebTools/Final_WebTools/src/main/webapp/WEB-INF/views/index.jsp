<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.row {
	margin: 15px 0px 0px 0px;
}
.banner {
	background: url(${contextPath}"/myweb/resources/images/home-bg.jpg"); background-size : cover;
	height: 95vh;
	background-size: cover;
}
.button{
    background-color: #4d4d4d;
    color:#fff;
}
.overlay {
	background-color: rgba(255, 255, 255, 0.4);
	height: 25vh;
}
.post-title-block{padding:100px 0;}
.post-title-block h1 {color: #fff; font-size: 85px; font-weight: bold; text-transform: capitalize;}
.post-title-block li{font-size:20px; color: #fff;}
a {
	margin: 10px;
}
</style>
<title>Utopia</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext}" />
	<div class="banner container-fluid">
	    <div class="post-title-block">
	    <h1 class="text-center">Utopia</h2>
	    </div>
		<div class="overlay container-fluid">
			<div class="row text-center">
				<div class="col-md-4"></div>
				<a class="col-md-4 btn button" href="user/register">Register</a>
			</div>
			<div class="row text-center">
				<div class="col-md-4"></div>
				<a class="col-md-4 btn  button" data-toggle="modal"
					data-target="#loginForm">Login</a>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<p class="text-center">Design&LucyBai</p>
	</div>

	<div id="loginForm" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<div class="modal-content">
				<form action="user/login" method="post">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Login Right Now</h4>
					</div>
					<div class="modal-body">

						<div class="row">
							<div class="col-md-8 col-md-offset-2">
								<input name="username" class="form-control" required="required"
									placeholder="username" />
							</div>
						</div>

						<div class="row">
							<div class="col-md-8 col-md-offset-2">
								<input type="password" class="form-control" name="password"
									placeholder="password" required="required" />
							</div>
						</div>

						<div class="row">
							<div class="col-md-8 col-md-offset-2">
								<input type="submit" class="form-control btn button"
									value="Login" />
							</div>
						</div>
					</div>
				</form>
			</div>

		</div>
	</div>
</body>
</html>