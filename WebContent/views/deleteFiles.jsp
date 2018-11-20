<%@ taglib uri="http://com.swinfosoft.mvc.web.tags" 
 prefix="mvc" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<% int i=0;%>
 <div class="col-md-8 pull-right">
 	<h3>You have following java code Files</h3>
 	<hr/>
	<c:if test="${files !=null}">
	<table class="table table-striped table-bordered">

	<thead>
		<tr>
		<th><input type="checkbox"></th>
		<th>java code</th>
		<th>Size</th>
		<th>Action</th>
		<th>Action</th>
		<th>Action</th>
		
		</tr>
		</thead>
	<tbody>
	<c:forEach items="${files}" var="file" varStatus="status">
	
	<tr>
	
	<td><input type="checkbox"></td>
	<td><span class="glyphicon glyphicon-file"></span>&nbsp;&nbsp;&nbsp;${file.name}</td>
	<td>${file.length()}&nbsp;Byte</td>
	<td><a class="view" href="#" rel="viewFile.action?path=${file.path}">view</a></td>
	<td><a href="downloadFile.action?path=${file.path}">Download</a></td>
	<!-- <td><a href="deleteFolder.action?id=${file.path}">Execute</a></td> -->
	
	<td><a href="deleteFile.action?path=${file.path}">Delete</a></td>
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
	
	
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> 
<div class="modal-dialog"> 
<div class="modal-content"> 
<div class="modal-header"> 
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> 
<h4 class="modal-title" id="myModalLabel">Your java program </h4> 
</div> 
<div id="code" class="modal-body">

</div> 
<div class="modal-footer"> <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> 
</div></div> </div> </div>


<script>
$(document).ready(function(){
	$('.view').click(function(){
		var url=$(this).attr("rel");
		$.post(url,function(data){
			var obj=data.split('\n');
			var html='<ol>';
			 $(obj).each(function(i,v){
				html+='<li>'+v.toString()+'</li>';
			}); 
			 html+='</ol>';
			$('#code').html(html);
			$('#myModal').modal("show");
		});
	});
});

</script> 