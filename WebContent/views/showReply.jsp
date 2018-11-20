
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<div class="col-md-6 col-md-offset-3 ">
<div style="background:skyblue" class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title"><span class="glyphicon glyphicon-question-sign"></span>&nbsp;&nbsp;<b class="pull-right"><span class="glyphicon glyphicon-user">&nbsp;${post.userName}</b></p>
</div>
<div class="panel-body">
	<div class="container-fluid">
	<form class="form-horizontal">
	<div class="form-group">
	<label><b>Title:</b></label>
	${post.title}
	</div>
	<div class="form-group">
	<label><b>Contents:</b></label>
	${post.content}
	</div>
	<label><b>Code</b></label>
	<textarea class="form-control" name="code" rows="5" readonly>${post.code}</textarea>
				<br/> 
			</form>
		</div>
</div>
</div>
</div>

<div class="col-md-6 col-md-offset-3">
<div style="background:pink" class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title"><span class="glyphicon glyphicon-inbox"></span>&nbsp;&nbsp;<b>All answere...</b></p>
</div>
<div class="panel-body">
	<div class="container-fluid">
	<div class="form-group">
	<c:forEach items="${postm}" var="postm" varStatus="status">
	<label><span class="glyphicon glyphicon-user">&nbsp;</span><b class="text text-primary">${postm.userName}</b></label>
	<div class="pull-right">${postm.date}</div>
	<div>
	<label><b>Title:</b></label>
	${postm.title}<br/>
	<label><b>Contents:</b></label>
	${postm.content}<br/>
	<label><b>Code:</b></label><br/>
	<textarea class="form-control" rows="5" readonly>${postm.code} </textarea>
			</div><br/></c:forEach>
			</div>
				<br/>
</div>
</div>
</div> 
