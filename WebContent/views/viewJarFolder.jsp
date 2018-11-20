<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>

<div class="col-md-6 pull-right">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title">Show Jar Files In Selected folder </p>
</div>
<div class="panel-body">
	<div class="container-fluid">
	<form method="post" action="viewJarFiles.action" class="form-horizontal">
	<c:if test="${folders !=null}">
	<div class="form-group">
	<label for="jarFolder" class="control-label">Select folder to show jar files</label>
	<select name="jarFolder" class="form-control">
	<c:forEach items="${folders}" var="folder">
	<option  value="${folder.path}">${folder.name}</option>
	</c:forEach>
	</select>
	</div>
	</c:if>			
				<div class="pull-right">
					<button type="submit" class="btn btn-primary btn-lg">Show Jar</button>
				</div>
	</form>
		</div>
</div>
</div>
</div>
