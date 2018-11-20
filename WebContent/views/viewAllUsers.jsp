<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>

<div class="col-md-6 pull-right">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title">All users of your JPlug</p>
</div>
<div class="panel-body">
	<div class="container-fluid">
	<form method="post" action="viewFolderOfUser.action" class="form-horizontal">
	<c:if test="${users !=null}">
	<div class="form-group">
	<label for="jarFolder" class="control-label">Select User to show AllFolders</label>
	<select name="selectedUser" class="form-control">
	<c:forEach items="${users}" var="user">
	<option  value="${user.id}">${user.name}</option>
	</c:forEach>
	</select>
	</div>
	</c:if>			
				<div class="pull-right">
					<button type="submit" class="btn btn-primary btn-lg">Click</button>
				</div>
	</form>
		</div>
</div>
</div>
</div>
