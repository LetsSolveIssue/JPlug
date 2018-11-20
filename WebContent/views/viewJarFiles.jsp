<%@ taglib uri="http://com.swinfosoft.mvc.web.tags" 
 prefix="mvc" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<% int i=0;%>
 <div class="col-md-8 pull-right">
 	<h3>You have following Jar Files</h3>
 	<hr/>
	<c:if test="${files !=null}">
	<table class="table table-striped table-bordered">

	<thead>
		<tr>
		<th><input type="checkbox"></th>
		<th>Jar Files</th>
		<th>Size</th>
		<!-- <th>Uploaded Date</th> -->
		<th>Action</th>
		<th>Action</th>
		
		</tr>
		</thead>
		<!--  -->
	<tbody>
	<c:forEach items="${files}" var="file" varStatus="status">
	<tr>
	
	<td><input type="checkbox"></td>
	<td><span class="glyphicon glyphicon-file">
	</span>&nbsp;&nbsp;&nbsp;${file.name}</td>
	<td>${file.length()}&nbsp;Byte</td>
	<%-- <td><a href="deleteFolder.action?id=${file.path}">Delete</a></td> --%>
	<td><a href="deleteFile.action?path=${file.path}">Delete</a></td>
	<td><a href="downloadFile.action?path=${file.path}">Download</a></td>
	</tr>
	
	</c:forEach>
	</tbody>
	</table>
	</c:if>	
<div class="row">
	<div class="col-md-1 button-group">
	<button type="button" class="btn btn-primary" name="edit">Bulk Delete</button>
	</div>	
</div>
</div>

