<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>

<div class="col-md-6 pull-right">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title">Attach Jar File</p>
</div>
<div class="panel-body">
	<div class="container-fluid">
	<form method="post" action="uploadJar.action" enctype="multipart/form-data"  class="form-horizontal">
	<c:if test="${folders !=null}">
	<div class="form-group">
	<label for="jarFolder" class="control-label">Folder to store jar files</label>
	<select name="jarFolder" class="form-control">
	<c:forEach items="${folders}" var="folder">
	<option  value="${folder.path}">${folder.name}</option>
	</c:forEach>
	</select>
	</div>
	</c:if>
	<div class="form-group">
	<input type="file" name="jarFile"  class="form-control">
	</div>
				
				<div class="pull-right">
					<button type="submit" class="btn btn-primary btn-lg">Add Jar</button>
				</div>
	</form>
		</div>
</div>
</div>
</div>
