<center><h3 style="color:green">${message}</h3></center>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c" %>

<div class="col-md-6 col-md-offset-2 ">
<div class="panel panel-primary">
<div class="panel-heading">
<p class="panel-title"><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;<b>Edit Profile</b></p>
</div>
<div class="panel-body">
	<div class="container-fluid">
	<form action="changeProfile.action" class="form-horizontal">
	
	<div class="form-group">
	<lable><b>Name :</b></lable>
	<input type="text" name="name" value="${userinfo.name}" class="form-control">
	</div>
	<div class="form-group">
	<lable><b>Email_id :</b></lable>
	<input type="email" name="email" value="${userinfo.mailId}" class="form-control">
	</div>
	<div class="form-group">
	<lable class="control-label"><b>Password :</b></lable>
	<input type="text" name="password" value="${userinfo.password}" class="form-control">
	</div>
	<div>
	<label  ><b>Security Question</b></label>
				<select class="form-control" name="squestion" value="${userinfo.securityQuestion}">
						<option value="your best friend">your best friend</option>
						<option value="your favourite teacher">your favourite teacher</option>	
						<option value="your favourite food">your favourite food</option>
						<option value="your favourite sport">your favourite sport</option>
						<option value="your favourite place">your favourite place</option>
				</select>

			</div>
			<div class="form-group">
			
				<label for="ans" class="control-label">Answer</label>
		
				<input type="text" name="ans" value="${userinfo.securityAnswer}" class="form-control">

			</div>
	<div class="form-group">
	<!-- <lable><b>Role :</b></lable> -->
	<input type="hidden" name="role"  readonly value="${userinfo.role}" class="form-control">
	</div>
	<div class="form-group">
	<!-- <lable><b>userId :</b></lable> -->
	<input type="hidden" name="uid"  readonly value="${userinfo.id}" class="form-control">
	</div>
	
				<div class="pull-right">
					<button type="submit" class="btn btn-primary btn-lg">Change Profile</button>
				</div>
			</form>
		</div>
</div>
</div>
</div>
