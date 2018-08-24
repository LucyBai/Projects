<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
<link href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet"> 
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"> 
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
                    <h2><span class="ion-minus"></span>Blog Posts<span class="ion-minus"></span></h2>
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis  dis parturient montes, nascetur ridiculus </p><br>
                 </div> 
            </div>  
	
		 <div class=" col-lg-6 col-lg-offset-3">
        <form  action="${contextPath}/artical/search" method="post">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="Search" name="search">
            <div class="input-group-btn">
                <button class="btn btn-default" type="submit">Search</button>
            </div>
        </div>
        </form>
      </div>
		 <div class=" col-lg-6 col-lg-offset-3">
          <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>   
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="${contextPath}/artical/type?name=travel">Travel</a></li>
            <li><a href="${contextPath}/artical/type?name=photo">Photo</a></li>
            <li><a href="${contextPath}/artical/type?name=it">IT</a></li>
            <li><a href="${contextPath}/artical/type?name=fiction">Fiction</a></li> 
          </ul>
        </div>
         </div>
         	<c:choose>
			<c:when test="${empty requestScope.articals}">
				<div class="col-lg-6 col-lg-offset-3">
				<h3>No post!</h3>
				</div>
			</c:when>
			<c:otherwise>
		    <c:forEach items="${requestScope.articals}" var="artical">     
     
			    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12" data-aos="fade-right">
                    <div class="col-lg-6 col-xs-12">
                        <img src="${contextPath}/resources${artical.fileName}" alt="images" height="200" width="250"/>			
							<div class="row">
								<span><i class="far fa-heart"></i><b> ${artical.favoriteCount} Like</b></span>
							</div>
					</div>
					<div class="col-lg-6 col-xs-12">
						 <div class="blog-column">
							<span>${artical.articalName}</span>
							 <ul class="blog-detail list-inline"> 
								<li><i class="fa fa-user"></i>${artical.user.username}</li> 
								<li><i class="fa fa-clock-o"></i>${artical.uploadDate}</li> 
							</ul> 
							<p>${artical.content}</p>
							<a href="${contextPath}/artical/comment/${artical.articalID}">Add/View Comments</a>
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