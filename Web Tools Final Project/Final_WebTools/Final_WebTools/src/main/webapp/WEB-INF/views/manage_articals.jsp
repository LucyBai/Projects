<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
</head>
<body>
   <div class="container-fluid">
		<c:import url="administrator_header.jsp"></c:import>
	</div>
	<div class="container">
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	
	  <div class="col-md-12">
	    <c:choose>
			<c:when test="${empty requestScope.articals}">
				<h4>Start clicking !</h4>
			</c:when>

			<c:otherwise>
				<c:forEach items="${requestScope.articals}" var="artical">
					<div class="col-md-4">
				        <div class="col-xs-12 text-center">
	                         <h4>${artical.articalName}</h4>
	                    </div>	
						<div class="thumbnail">
							<img class="img img-responsive" src="${contextPath}/resources${artical.fileName}"
								alt="images" style="height:200px; width:250px"  />
							<div class="caption">
								<div class="row" style="margin-left:5px">
									<span><i class="far fa-heart"></i><b> ${artical.favoriteCount} Like</b></span>
								</div>
								<div class="row">
									<a href="${contextPath}/artical/view/${artical.articalID}"style="margin-left: 20px">View Artical</a>
								</div>
								<div class="row">
							    <form action="${contextPath}/artical/delete" method="get">
								<span><button value="${artical.articalID}"style="margin-left: 20px" class="btn btn-warning" name="delete"> Delete</button>
								</span>
								</form>
							</div>
							</div>
						</div>
					</div>
				</c:forEach>
				[<a href="${contextPath}/artical/managepage?page=1">1</a>]
                [<a href="${contextPath}/artical/managepage?page=2">2</a>]
                [<a href="${contextPath}/artical/managepage?page=3">3</a>]
			</c:otherwise>
			
		</c:choose>
	  </div>	
	</div>
</body>
</html>