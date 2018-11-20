<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>

<html >
<head>
<title> 
${title}
</title>
</head>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="css/prettify.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript" src="js/pretty.js"></script>
<!-- style="background-color:BACEFF; -->
<body>
<div id="divMessage">
<span id="spMessage"></span>
</div>
<!--main container starts -->
<div class="container">
	
	
	<!--header will be inserted here  -->
	<c:choose>
	<c:when test="${user !=null}">
	<c:import url="userHeader.jsp" />
	</c:when>
	<c:otherwise>
	<c:import url="header.jsp" />
	</c:otherwise>
	</c:choose>
	
	<hr/>
	<div class="row">
	<c:choose>
	<c:when test="${user !=null}">
	<div class="col-md-2 pull-left table-bordered">
	<c:choose>
	<c:when test="${user.role==1}">
	<c:import url="userMenu.jsp" />
	</c:when>
	<c:when test="${user.role==2}">
	<c:import url="moderatorMenu.jsp" />
	</c:when>
	<c:when test="${user.role==3}">
	<c:import url="adminMenu.jsp" />
	</c:when>
	</c:choose>
	</div>
	</c:when>
	</c:choose>
	<!--contents will be inserted here  -->
	<div id="divLayer"></div>
	<img alt="loading..." id="imgSpinner" src="images/spinner.gif">
	<c:import url="${body}" />	
	</div>
	</div>
	<hr/>
	<!--footer will be inserted here  -->
	<jsp:include page="footer.html" />	
