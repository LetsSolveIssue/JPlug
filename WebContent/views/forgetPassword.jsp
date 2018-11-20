<center><h3 style="color:green">${message}</h3></center>


 <form method="post" action="resetPassword.action">
<div class="form-group">
			    <input class="form-control"type="hidden" name="cans" value="${userques.getSecurityAnswer()}">
			     <input class="form-control"type="hidden" name="mailid" value="${userques.getMailId()}">
				<label for="mailId" class="control-label">Security Question</label>
				<input class="form-control"type="text" name="s1" value="${userques.getSecurityQuestion()}" readonly>
	
			</div>
			<div class="form-group">
			
				<label  class="control-label">Answer</label>
		
				<input type="text" name="ans" placeholder="password" class="form-control" required>

			</div>
			
				<div class="pull-right">
			
					<button type="submit" class="btn btn-primary btn-lg">Reset Password</button>

		
				</div>
				</form> 