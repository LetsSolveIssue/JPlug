
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<html>
<body>
<div class="col-md-8 col-md-offset-2">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title"><span class="glyphicon glyphicon-edit"></span>&nbsp;&nbsp;<b>Write post</b></p>
</div>
<div class="panel-body">
	<div class="container-fluid">
	<form action="savePost.action" 
	 class="form-horizontal">
	<div class="form-group">
	<label><b>Title / Question</b></label>
	<input type="text" name="title" class="form-control">
	</div>
	<div class="form-group">
	<label><b>Contents / Descripton</b></label>
	<textarea class="form-control" id="1" name="contents" rows="10" cols="10">
			</textarea>
	</div>
	<div id="cod">
	<div id="2">
	<label><b>Code</b></label>
	<textarea class="form-control" id="1" name="code" rows="10" cols="10">
			</textarea></div>
				<br/>
				
	</div>
	<div class="pull-right">
				<button type="submit" class="btn btn-primary">Post</button>		
				
	</div>
	<div><input type="button" id="btn" value="Write code"class="btn btn-primary"></div>
		</form>	
	</div>
	
		
</div>
</div>
</div> 
<script type="text/javascript">
$("#cod").hide();
$(document).ready(function(){
	$("#btn").click(function(){
		$("#cod").toggle(1500);
	});	
});
</script>
</body>
</html>
