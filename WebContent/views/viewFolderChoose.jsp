<%@ taglib uri="http://com.swinfosoft.mvc.web.tags" 
 prefix="mvc" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>
<% int i=0;%>
 <div class="col-md-6 pull-right">
 <div class="panel panel-primary">
 	<div class="panel-heading">
 		<h1 class="panel-title">Select button to show folder </h1>
 	</div>
 		<div class="panel-body">
 		<br/><br/>
 		<form method="post" action="viewFolder.action">
 		<input type="radio" name="f" value="self"  >Self Folder </intput>
 		<input type="radio" name="f" value="users" >Users Folder </intput>
 		<br/>
 		<br/>
 		<div class="panel-footer pull-right">
 			<button type="submit" class="btn btn-primary " name="submit">submit</button>
 			</div>
 			</form>
 			<form action="#">
 			<div class="panel-footer pull-left">
 			<button type="submit" class="btn btn-primary " name="cancle">cancle</button>
 			</div>
 			</form>
 		</div>
 	
 	</div>
 </div>


