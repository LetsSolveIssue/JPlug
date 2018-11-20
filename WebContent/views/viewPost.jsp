 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<link rel="stylesheet" type="text/css" href="css/compiler.css">
<script type="text/javascript" src="js/compiler.js"></script>
<div class="row">
		<div class="col-md-7 col-md-offset-2">
			
			<div  class="panel panel-primary">
			<div class="panel-heading">
			<h1 class="panel-title"><span class="glyphicon glyphicon-envelope"></span>&nbsp;&nbsp;<b>view post</b></h1>
			</div>
			<div class="panel-body">
			<!-- 
			You can write your code here.
			 --> 
			 <c:forEach items="${postm}" var="post" varStatus="status">
			 <c:choose>
			 <c:when test="${post.userId eq user.id}">
			 <b><i><label><span class="glyphicon glyphicon-user">&nbsp;</span><b class="text text-primary">${post.userName}</b></label></i></b><br/><div class="pull-right"><a href="editPost.action?postid=${post.id}">
			 <span class="glyphicon glyphicon-pencil"></span>&nbsp;edit</a>&nbsp;&nbsp;&nbsp;&nbsp;
			 <span class="glyphicon glyphicon-remove glyphicon-blue"></span>&nbsp;<a href="deletePost.action?postid=${post.id}">remove</a></div>
			 <h6><i>${post.date}</i></h6><b>Title:</b>&nbsp;${post.title}<br/>
			 <b>Contents:</b>&nbsp;${post.content}<br/>
			   <label><b>Code:</b></label>&nbsp;<textarea class="form-control" rows="4" readonly>${post.code}</textarea><br/>
			 <c:if test="${post.status !=0 }">
			 <a href="showReply.action?postId=${post.id}"><span class="glyphicon glyphicon-inbox"></span></a>&nbsp;&nbsp;&nbsp;${post.status}&nbsp;&nbsp;<b class="text text-danger">people reply on this..</b>
			 </c:if>
			 <p class="pull-right"><a href="postAnswere.action?postid=${post.id}"><b class="text text-danger">Post Answere</b></a></p><hr/>
			 </c:when>
			 
			<c:otherwise>
			 <b><i><label><span class="glyphicon glyphicon-user">&nbsp;</span><b class="text text-primary">${post.userName}</b></label></i></b><h6><i>${post.date}</i></h6>
			 <b>Title:</b>&nbsp;${post.title}<br/>
			 <b>Contents:</b>&nbsp;${post.content}<br/>
			 <label><b>Code:</b></label>&nbsp;<textarea class="form-control" rows="4" readonly>${post.code}</textarea><br/>
			 <c:if test="${post.status !=0 }">
			 <a href="showReply.action?postId=${post.id}"><span class="glyphicon glyphicon-inbox"></span></a>&nbsp;&nbsp;&nbsp;${post.status}&nbsp;&nbsp;<b class="text text-danger"><b class="text text-danger">people reply on this..</b>
			 </c:if>
			  <p class="pull-right"><a href="postAnswere.action?postid=${post.id}"><b class="text text-danger">Post Answere</b></a></p><hr/>
			 </c:otherwise>
			</c:choose>
			 <br/>
			 </c:forEach>
			
			</div>
			</div>
		</div>
		</div>