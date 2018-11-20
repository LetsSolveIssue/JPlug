	<div class="col-md-6">
	<h3>Your Profile Details</h3>	
	<hr/>

	<form action="updateProfile.action" class="form-horizontal">
	<div class="form-group">
	<label for="name" class="control-label">Name</label>
	<input type="text" name="name" value="${user.name}" class="form-control">
	</div>
	<div class="form-group">
	<label for="mailId" class="control-label">MailId</label>
	<input type="text" name="mailId" value="${user.mailId}" class="form-control">
	</div>
	<div class="form-group">
	<label for="password" class="control-label">Password</label>
	<input type="text" name="password" value="${user.password}" class="form-control">
	</div>
	<div class="pull-right">
	<button type="submit" class="btn btn-primary btn-lg">Update</button>
	</div>
	</form>
	</div>
	
	
	
	
