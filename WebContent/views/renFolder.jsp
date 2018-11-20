<%@ taglib uri="http://com.swinfosoft.mvc.web.tags" 
 prefix="mvc" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<% int i=0;%>
 <div class="col-md-4">
 <div class="container-fluid">
 	<div class="col-md-10">
 	<h4>Rename Folder Form</h4>
 	<hr/>
 	
 	<form action="renFolder.action" class="form-horizontal" >
	<div class="form-group">
	<label for="name" class="control-label">Folder Name</label>
	<input type="text" name="name" value="${folder.name}" class="form-control">
	</div>
	<div class="form-group">
	<input type="hidden" name="id" value="${folder.id}" class="form-control">
	</div>
	<div class="pull-right">
	<button type="submit" class="btn btn-primary">rename</button>
	</div>
	</form>
	</div>
</div>
</div>

