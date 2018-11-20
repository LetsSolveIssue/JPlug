<div class="container">
<div class="row">
	<!--header starts  -->
		<div class="col-md-3"><a id="top" href="#">
			  <img src="images/jplug-logo.png" alt="JPlug" ></a>
			  
		</div>
		<div class=" col-md-5.5  pull-right">
				<h3><text color="green">Login here</text></h3>
				<form action="login.action" class="form-inline">
			
					<div class="form-group">	
			
						<input type="text" name="userId" placeholder="userId" class="form-control">

					</div>
			
					<div class="form-group">
					<input type="password" name="password" placeholder="password" class="form-control">

					</div>
			
					<button type="submit" class="btn btn-primary" >sign in</button>
				</form>
				<br/>
				<a href="#" data-toggle="modal" data-target="#myModal">Forget Password</a>
				
				
			</div>
<form action="forgetPassword.action">		
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> 
<div class="modal-dialog"> 
<div class="modal-content"> 
<div class="modal-header"> 
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> 
<h4 class="modal-title" id="myModalLabel">Enter Email_Id for password Reset</h4> 
</div> 
<div class="modal-body">
<label for"mid" class="control-label">Enter Email Id</label>
<input type="email" name="emailid" id="mid" class="form-control"/>
</div> 
<div class="modal-footer"> <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> 
<button type="submit" class="btn btn-primary">Ok</button> 
</div></div> </div> </div>
</form>

	<!--header ends  -->	
	</div>
	</div>
	
	
	
	
	
	