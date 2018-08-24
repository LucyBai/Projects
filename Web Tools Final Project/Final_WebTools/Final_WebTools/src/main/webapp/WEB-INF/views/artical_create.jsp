<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
.btn{
margin:0 auto;
}
.image-preview-input {
    position: relative;
    overflow: hidden;
    margin: 0px;    
    color: #333;
    background-color: #fff;
    border-color: #ccc;    
}
.one{
    width:300;
    height:300;
}

</style>
<script>
	$(document).ready(function() {
		$('#read').change(function() {
			readURL(this);
		});

		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#one').attr('src', e.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
		}

	});
</script>
<title>Utopia</title>
</head>
<body>
	<div class="container-fluid">
		<c:import url="header.jsp"></c:import>
	</div>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div class="continer">
		<h2 class="text-center">Start your inspiration!</h2>
	</div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
			<div  id="loc">
				<img src="http://s.editor.pho.to/images/editor/editor-photo-features-frames.jpg" id="one"  width="350" height="250" />
			</div>
			<form action="${contextPath}/artical/upload" method="post" enctype="multipart/form-data">
		    <br>
		    <p>Type your artical name!</p>
		    <input type="text" name="articalName" />
		     <select name="type">
				  <option value ="travel">Travel</option>
				  <option value ="photo">Photo</option>
				  <option value="it">IT</option>
				  <option value="fiction">Fiction</option>
            </select>
            <br>
             <p>Write your idea!</p>
             <textarea rows="8" cols="50" name="content"> </textarea>
			<br>
			<input type="file" class="form-control loader" id="read" name="pic" />
		   <input type="submit" class="btn btn-labeled btn-default"> <span class="btn-label"><i class="glyphicon glyphicon-upload"></i> </span>Upload</button>
			</form>	
			</div>
		</div>

	</div>
</body>
</html>