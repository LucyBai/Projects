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
<script>
	$(document).on('click','.block',
			function(event) {
				debugger;
				event.preventDefault();
				var c = $(this).attr('name');
				var element = this;
				console.log(element);
				var toblock = {
					"personID" : c
                };
				$.ajax({
					url : "../blacklist/add",
					data : toblock,
					dataType : 'json',
					type : "POST",
					cache: true,
					success : function(data) {
						if (data) {
							console.log(data);
							$(element).removeClass("btn-default").addClass("btn-success");
							$(element).html("Active");
						} else {
							console.log(data);
							$(element).addClass("btn-default").removeClass(
									"btn-success");
							$(element).html("BlackList");
						}

					}
				})
			});
</script>
<title>Utopia</title>
</head>
<div class="container-fluid">
		<c:import url="administrator_header.jsp"></c:import>
	</div>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div class="container">
		<h2 class="text-center">User List</h2>
		<c:choose>
			<c:when test="${fn:length(requestScope.userlist)==1}">
				<h4>No user register!</h4>
			</c:when>
			<c:otherwise>
				<table class="table table-stripped table-hover">
					<tr>
						<th>User Name</th>
						<th>First Name</th>
						<th>BIO </th>
						<th></th>
					</tr>
					<c:forEach var="i" begin="1"
						end="${fn:length(requestScope.model.userlist)}">
						<c:choose>
							<c:when
								test="${model.userlist[i-1].personID==sessionScope.user.personID}">
								<tr>
									<td>${model.userlist[i-1].username}</td>
									<td>${model.userlist[i-1].firstName}</td>
									<td>${model.userlist[i-1].bio}</td>
									<td></td>
								</tr>
							</c:when>
							<c:when test="${not model.checklist[i-1]}">
								<tr>
									<td>${model.userlist[i-1].username}</td>
									<td>${model.userlist[i-1].firstName}</td>
									<td>${model.userlist[i-1].bio}</td>
									<td><a name="${model.userlist[i-1].personID}"
							     	class="btn btn-warning block" href="#">Active</a></td>
								</tr>
							</c:when>
							<c:otherwise>
								<tr>
									<td>${model.userlist[i-1].username}</td>
									<td>${model.userlist[i-1].firstName}</td>
									<td>${model.userlist[i-1].bio}</td>
									<td><a name="${model.userlist[i-1].personID}"
								    	class="btn btn-warning block" href="#">BlackList</a></td>
								</tr>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>

	</div>
</html>