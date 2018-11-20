<%@ taglib uri="http://com.swinfosoft.mvc.web.tags" 
 prefix="mvc" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<% int i=0;%>
 <div class="col-md-6 pull-right">
 	<h3>You have following folders</h3>
 	<hr/>
	<c:if test="${folders !=null}">
	<table class="table table-striped table-bordered">

	<thead>
		<tr>
		<th><input type="checkbox"></th>
		<th>Folder</th>
		<th>Size</th>
		<th>Action</th>
		<th>Action</th>
		<th>Action</th>
		</tr>
		</thead>
	<tbody>
	<c:forEach items="${folders}" var="folder" varStatus="status">
	<tr>
	
	<td><input type="checkbox"></td>
	<td><span class="glyphicon glyphicon-folder-open">
	</span>&nbsp;&nbsp;&nbsp;${folder.name}</td>
	
	<td>${folder.size} bytes</td>
	<td><a href="editFolder.action?id=${folder.id}">edit</a></td>
	<td><a href="deleteFolder.action?id=${folder.id}">delete</a></td>
	<td><a href="downloadFolder.action?path=${folder.path}">download</a></td>
	</tr>
	
	</c:forEach>
	</tbody>
	</table>
		
<div class="row">
	<div class="col-md-1 button-group">
	<button type="button" class="btn btn-primary" name="edit">Bulk Delete</button>
	</div>	
</div>
</div>
	</c:if>
	
	</div>

