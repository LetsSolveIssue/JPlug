	<div class="col-md-6">
	<h3>Reset new password</h3>	
	<hr/>

	<form action="setnewPassword.action" class="form-horizontal">
	<div class="form-group">
	<label for="mailId" class="control-label">your Email_Id :</label>
	<input class="form-control"type="text" name="mailid" value="${mailid}" readonly>
	<label for="name" class="control-label">Enter New password </label>
	<input type="password" name="pass"  class="form-control">
	</div>
	<div class="form-group">
	<label for="mailId" class="control-label">ReEnter password</label>
	<input type="password" name="repass"  class="form-control">
	</div>
	
	<div class="pull-right">
	<button type="submit" class="btn btn-primary btn-lg">Reset password</button>
	</div>
	</form>
	</div>
	
	
	
	
