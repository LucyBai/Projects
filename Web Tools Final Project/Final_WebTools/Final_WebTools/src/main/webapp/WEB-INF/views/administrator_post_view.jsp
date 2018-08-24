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
	.row{
	padding-top:10px;
	margin-bottom: 4px;
	padding-bottom:10px;
	}
	
	.highLight{
	background: #fff7e5;
	border-bottom: 1px solid #DEDEDE;
	}
	
	</style>
<title>Utopia</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div class="container-fluid">
		<c:import url="administrator_header.jsp"></c:import>
	</div>
	<div class="container">
    <div class=" thumbnail space"style="width: 65%; margin: 0 auto"> 
        <div class="row">
             <div class="col-md-10">
                 <div class="row hidden-md hidden-lg"><h1 class="text-center" >${map.artical.articalName}</h1></div>
   
                 <div class="pull-left col-md-6 col-xs-12 thumb-contenido"><img class="center-block img-responsive"  src="${contextPath}/resources${map.artical.fileName}" alt="images" /></div>
                 <div class="">
                     <h1  class="hidden-xs hidden-sm">${map.artical.articalName}</h1>
                     <hr>
                     <small>${map.artical.uploadDate}</small><br>
                     <small><strong>${map.artical.user.username}</strong></small>
                     <hr>
                     <p class="text-justify" style="margin-left: 45px">
                     ${map.artical.content }
	                 </p>
					<c:choose>
					<c:when test="${map.flag}">
						<span><img name="${map.artical.articalID}" class="like"
							src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAACWklEQVRIS7WVzWsTYRDGn3k3aSvFVhDBg6WCpRo3hEA1MbHR3UihBw8ejOBBD+Kppwoe9C/Qi3gSDx5EEATjQfDUqk005kNL8atJmiqoeJEKIhYrabLvyCY2NDbJRrvd2+77zPzm3eGZIWzwQxucH+sG3I1EFLPIE9Go0ajYOsDDoaHeDuevcYY4DuJBM8AACgpwzyHKV4eThUXzW8Y/0FOkjnPMdFIKmDoWkuch6M5qnamtARK+PYMGKZMQ6G/y2z5KoYw6S8tsKMoEgJ2NdBL8wWnI0dCLufkaYMLj6e7sKr2GIna16okk+dk8Fyz6WukM4F3vcpd338zMUuUGsYB6gYBLdjaciM8fTuWuVABxv/oSAl47AczGtJ6Z81UAUwF1SQCb7ARIicXw82xPFeBXfwiBzXYCAHzT0tmtKz14SkDITgAzx/RMLlwFHFDPEuGGnQAQn9FSuZtVgKY5qPg1CcBnC4Qps9DnGjbdXTNabL+6nRxIABhYJ+Q9lxHSp7Nf6pxsvjwOuvoV5meAsuN/IKYRGQgdSeU/rcSvGXZTBz27UTISQsG2f4JIY0E6Og6Fk28Kq+MaTtNYUPWSIWMQYktbECm/syJ0PZV99be+6bh+EnAHGcYkILpbQ+RPkGNES71NN9K13Adxv3sEzA+goLMhxECRhTyqZ/KPmhVhuXBiAdcxkohCCEddEinLLBDR0/n7rW5oCagMw6D7lGS+Jf7sDwkwEZ3WU7O3rXrUFqAKUcfAuFZJyDSmZWavWyVf4wOrgHhg70UGsZ7OXrbSNvVBu4Ht6n4DPJrOGc32WOUAAAAASUVORK5CYII="
							alt="like_button" style="margin-left: 45px"/><b> ${map.count} Like</b></span></c:when>
							<c:otherwise><span><i class="far fa-heart"></i><b> ${map.count} Like</b></span>
							</c:otherwise>
					</c:choose>
				</div>
				<c:forEach items="${map.comments}" var="com">
				<div class="row highLight col-md-11" style="margin-top:10px;margin-left: 45px;border-radius: 10px;">
				<div class="col-sm-2"><b>${com.user.username}</b></div>
				<div class="col-sm-5">${com.commentContent}</div>
				<div class='col-sm-5'>${com.commentTime }</div>
				<a href="${contextPath}/comment/delete?delete=${com.commentID}&&articalId=${map.artical.articalID}" class="comment btn btn-warning" style="margin-right: 20px;
                  margin-top: 10px;float: right;">Delete</a>
				</div>
				</c:forEach>
				<div class="row noColor" style="margin-left: 45px; border-radius:15px">
					<div class="col-md-3">
						<a href="${contextPath}/artical/delete?delete=${map.artical.articalID}" class="comment btn btn-warning" style="float:right;">Delete</a>
					</div>
				</div>
			   </div>
	     </div>
	   </div>
	  </div>
	</div>
</body>
</html>