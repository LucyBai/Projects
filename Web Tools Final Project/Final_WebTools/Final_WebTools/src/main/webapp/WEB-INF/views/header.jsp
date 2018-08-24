<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>Utopia</title>
<style>
.navbar{margin-bottom:0;}
.banner-section{background-image:url(${contextPath}"/myweb/resources/images/about-bg.jpg");
background-size:cover; 
height: 370px; left: 0; 
position: absolute; top: 0; 
background-position:0;}
section{width:100%; float:left;}
.post-title-block{padding:100px 0;}
.post-title-block h1 {color: #fff; font-size: 85px; font-weight: bold; text-transform: capitalize;}
.post-title-block li{font-size:20px; color: #fff;}
h1 a:hover{
text-decoration: none;
}

</style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
    <nav class="navbar navbar-inverse navbar-fixed-top " >
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
       
        </div>
	<div id="navbar" class="navbar-collapse collapse fixed-top">
          <ul class="nav navbar-nav ">
            <li class="active"><a href="${contextPath}/user/login">Hi, ${user.firstName}</a></li>
            <li><a href="${contextPath}/artical/create">Inspiration</a></li>
            <li><a href="${contextPath}/user/station">My Station</a></li>
            <li><a href="${contextPath}/user/login">My Home</a></li>
            <li><a href="${contextPath}/artical/station">Artical Station</a></li>
            <li><a href="${contextPath}/user/available">Explore Users</a></li>
            <li><a href="${contextPath}/follow/followers">Followers</a><li>
            <li><a href="${contextPath}/follow/following">Following</a><li>
            <li><a href="${contextPath}/logout"> Log Out</a></li>
          </ul>
	</div>
	</nav>
	<section class="banner-section">
</section>
    <div class="container">

        <div class="row">
            <div class="col-lg-12 col-md-12 col-sm-12 post-title-block">
                <h1 class="text-center">Utopia</h1>
                <ul class="list-inline text-center">
                    <li>Author |</li>
                    <li>Category |</li>
                    <li>Date |</li>
                </ul>
            </div>
         </div>
       </div>
</body>
</html>