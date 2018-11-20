<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="col-md-6 col-md-offset-4">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title">Select folder name to view source code </p>
</div>
<div class="panel-body">
	<div class="container-fluid">
	<form method="post" action="viewProgramFiles.action" class="form-horizontal">
	<c:if test="${folders !=null}">
	<div class="form-group">
	<label for="codeFolder" class="control-label">Select folder name</label>
	<select name="codeFolder" class="form-control">
	<c:forEach items="${folders}" var="folder">
	<option  value="${folder.path}"><a href="javaFileProcess.action?path=${folder.path}">${folder.name}</a></option>
	</c:forEach>
	
	</select>
	</div>
	</c:if>			
				<div class="pull-right">
					<button type="submit" class="btn btn-primary btn-lg">Show Files</button>
				</div>
	</form>
		</div>
</div>
</div>
</div>
