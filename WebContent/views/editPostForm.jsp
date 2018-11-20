
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>

<div class="col-md-6 col-md-offset-3 ">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title"><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;<b>Edit Post</b></p>
</div>
<div class="panel-body">
	<div class="container-fluid">
	<form action="updatePost.action" 
	 class="form-horizontal">
	<div class="form-group">
	<lable><b>Title</b></lable>
	<input type="text" name="title" value="${posts.title}" class="form-control">
	</div>
	<div class="form-group">
	<lable><b>Contents</b></lable>
	<input type="text" name="contents" value="${posts.content}" class="form-control">
	<input type="hidden" name="postid" value="${posts.id}" class="form-control">
	</div>
	<lable><b>Code</b></lable>
	<textarea class="form-control" name="code" rows="5">${posts.code}</textarea>
				<br/>
				<div class="pull-right">
					<button type="submit" class="btn btn-primary btn-lg">Update</button>
				</div>
			</form>
		</div>
</div>
</div>
</div>
</b> 


