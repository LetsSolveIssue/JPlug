
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<html>
<body>
<div class="col-md-7 pull-right">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title"><span class="glyphicon glyphicon-question-sign"></span>&nbsp;&nbsp;<b>Question</b></p>
</div>
<div class="panel-body">
	<div class="container-fluid">
	<form class="form-horizontal">
	<div class="form-group">
	<label><b>Title:</b></label>
	${posts.title}
	</div>
	<div class="form-group">
	<label><b>Contents:</b></label>
	${posts.content}
	</div>
	<label><b>Code</b></label>
	<textarea class="form-control" name="code" rows="5" readonly>${posts.code}</textarea>
				<br/> 
			</form>
		</div>
</div>
</div>
</div>
<div class="col-md-7 pull-right">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title"><span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;<b>Post your answer...</b></p>
</div>
<div class="panel-body">
	<div class="container-fluid">
	<form action="savePostReply.action" 
	 class="form-horizontal">
	<div class="form-group">
	<label><b>Title</b></label>
	<input type="text" name="title" class="form-control">
	<input type="hidden" name="postId" value="${posts.id}"class="form-control">
	</div>
	<div class="form-group">
	<label><b>Contents</b></label>
	<input type="text" name="contents" class="form-control">
	</div>
	<div id="cod">
	<div id="2">
	<label><b>Code</b></label>
	<textarea class="form-control" id="1" name="code" rows="5">
			</textarea></div>
				<br/>
				
				</div>
				<div class="pull-right">
				<button type="submit" class="btn btn-primary">Post</button>
			</div>
			</form>
			<div>
	<input type="button" id="btn" value="Write code"class="btn btn-primary"></div>
		</div>
</div>
</div>
</div> 
</body>
</html>
