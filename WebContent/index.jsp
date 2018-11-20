<%@ taglib uri="http://com.swinfosoft.mvc.web.tags" 
 prefix="mvc" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
 
 
 <html>
<head>
<title> 
JPlug
</title>
</head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.11.2.js"></script>
<script src="js/bootstrap.js"></script>
<body>
<!--main container starts -->
<div class="container">
	
	
	<!--header will be inserted here  -->
	<jsp:include page="views/header.jsp" />
	<hr/>
	<div class="row">
	<mvc:invoke action="config" />
 	<c:import url="${page}" />
	</div>
	
	<hr/>
	<!--footer will be inserted here  -->
	<jsp:include page="views/footer.html" />	