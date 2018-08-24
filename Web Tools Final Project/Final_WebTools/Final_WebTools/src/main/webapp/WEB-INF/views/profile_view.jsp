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
</head>
<body>
<div class="container-fluid">
		<c:import url="header.jsp"></c:import>
	</div>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div class="container">
		<h2 class="text-center">${requestScope.model.follower.username}'s Station
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
				<td>${requestScope.model.follower.firstName}</td>	
				<td>${fn: length(requestScope.model.follower.followers)}</td>
				<td>${fn: length(requestScope.model.followinglist)}</td>
			</tr>
			<tr>
			   <th colspan="3">BIO</th>
			</tr>
			<tr>
				<td colspan="3">${requestScope.model.follower.bio}</td>
			</tr>
		</table>
	  </div>
	  <div class="col-md-9">

		<c:choose>
			<c:when test="${not requestScope.model.follows}">
				<h4>User is Private. You need to follow</h4>
			</c:when>
			<c:otherwise>
				<c:forEach items="${requestScope.model.follower.artical}" var="pic">
					<div class="col-md-4">
					<div class="col-xs-4 text-center">
	                         <h4>${pic.articalName}</h4>
	                    </div>	
						<div class="thumbnail">
							<img class="img img-responsive" src="${contextPath}/resources${pic.fileName}"
								alt="images" style="height:200px; width:200px"  />
							<div class="caption">
								<div class="row" style="margin-left:5px">
									<span><i class="far fa-heart"></i><b> ${pic.favoriteCount} Like</b></span>
								</div>
								<div class="row" style="margin-left:5px">
								<a href="../../artical/comment/${pic.articalID}">Add/View Comments</a>
								</div>
								<p>${artical.articalID}</p>
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