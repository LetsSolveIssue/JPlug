<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<div class="container">
 <div class="col-md-4 pull-right">
 	<h3>New Folder Form</h3>
	<form action="createFolder.action" class="form-horizontal">
	<c:if test="${folders !=null}">
	<div class="form-group">
	<label for="parent" class="control-label">Parent Folder</label>
	<select name="parent" class="form-control">
	<c:forEach items="${folders}" var="folder">
	<option  value="${folder.path}">${folder.name}</option>
	</c:forEach>
	</select>
	</div>
	<div class="form-group">
	<input type="checkbox" name="option"> 
	<label class="control-label">&nbsp;&nbsp;Create Sub Folder
	
	</label>
	</div>
	</c:if>
	<div class="form-group">
	<label for="name" class="control-label">FolderName</label>
	<input type="text" name="name" placeholder="folder Name" class="form-control">
	</div>
	<div class="pull-right">
	<button type="submit" class="btn btn-primary">create</button>
	</div>
	</form>
	</div>
	</div>

