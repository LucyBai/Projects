<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Utopia</title>
<style type="text/css">
h2 {
    color: #4C4C4C;
    word-spacing: 5px;
    font-size: 30px;
    font-weight: 700;
    margin-bottom:30px;
    font-family: 'Raleway', sans-serif;
}

.ion-minus{
    padding:0px 10px;
}

.blog {
	background-color:#f6f6f6;
	padding:60px 0px;
    font-family: 'Raleway', sans-serif;
}

.blog .blog-column a{
    color: #5db4c0;
    text-decoration: none;
}

.blog  span {
    font-size: 17px;
    font-weight: 700;
}
.blog  .blog-detail {
    margin-top: 10px;
}

.fa.fa-user, .fa.fa-clock-o {
    padding-right: 10px;
    color: #909090;
    font-size: 11px;
}
</style>
</head>
<body>
<div class="container-fluid">
	<c:import url="header.jsp"></c:import>
	</div>
	
<div class="blog">
    <div class="container">
           <c:set var="contextPath" value="${pageContext.request.contextPath}" />
		   <div class="row">
                 <div class="col-lg-6 col-lg-offset-3 text-center">  
                    <h2><span class="ion-minus"></span>Home Page<span class="ion-minus"></span></h2>
                    <p>Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis  dis parturient montes, nascetur ridiculus </p><br>
                 </div> 
            </div>  
		   <c:choose>
			<c:when test="${empty requestScope.feeds}">
				<h3>Need to create!</h3>
			</c:when>
			<c:otherwise>
		    <c:forEach items="${requestScope.feeds}" var="feed">     
            <div class="row">
			    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12" data-aos="fade-right">
                    <div class="col-lg-6 col-xs-12">
                        <img src="${contextPath}/resources${feed.fileName}" alt="images" style="height:200px; width:200px" />			
							<div class="row">
								<span><i class="far fa-heart"></i><b> ${feed.favoriteCount} Like</b></span>
							</div>
					</div>
					<div class="col-lg-6 col-xs-12">
						 <div class="blog-column">
							<span>${feed.articalName}</span>
							 <ul class="blog-detail list-inline"> 
								<li><i class="fa fa-user"></i>${feed.user.username}</li> 
								<li><i class="fa fa-clock-o"></i>${feed.uploadDate}</li> 
							</ul> 
							<p>${artical.content}</p>
							<a href="${contextPath}/artical/comment/${feed.articalID}">Add/View Comments</a>
						</div>
					</div>
                </div>
			</c:forEach>
			</c:otherwise>
		</c:choose>
		</div>
	</div>
</body>

</html>