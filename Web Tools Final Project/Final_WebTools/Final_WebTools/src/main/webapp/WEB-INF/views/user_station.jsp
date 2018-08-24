<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<style>
</style>
<script>
	
</script>

<title>Utopia</title>
</head>
<body>
	<div class="container-fluid">
		<c:import url="header.jsp"></c:import>
	</div>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div class="container">
		<h2 class="text-center">${sessionScope.user.username}'s Station
			</h2>
			
	<div class="row">
	  <div class="col-md-3">
	   <table class="table table-striped table-hover">
			<tr>
				<th>Name</th>
				<th>Followers</th>
				<th>Following</th>
			</tr>
			<tr>
				<td>${sessionScope.user.firstName}</td>
				<td>${fn: length(sessionScope.user.followers)}</td>
				<td>${fn: length(requestScope.model.following)}</td>
			</tr>
			<tr>
			   <th colspan="3">BIO</th>
			</tr>
			<tr>
				<td colspan="3">${sessionScope.user.bio}</td>
			</tr>
		</table>
	  </div>
	  <div class="col-md-9">
	    <c:choose>
			<c:when test="${empty requestScope.model.artical_list}">
				<h4>Start clicking !</h4>
			</c:when>

			<c:otherwise>
				<c:forEach items="${requestScope.model.artical_list}" var="artical">
					<div class="col-md-4">
				        <div class="col-xs-4 text-center">
	                         <h4>${artical.articalName}</h4>
	                    </div>	
						<div class="thumbnail">
							<img src="${contextPath}/resources${artical.fileName}"
								alt="images" style="height:200px; width:200px" />
							<div class="caption">
								<div class="row" style="margin-left:5px">
									<span><i class="far fa-heart"></i><b> ${artical.favoriteCount} Like</b></span>
								</div>
								<div class="row" style="margin-left:5px">
									<a href="${contextPath}/artical/comment/${artical.articalID}">Add/View Comments</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	  </div>
	</div>	
		
	</div>
</body>
</html>