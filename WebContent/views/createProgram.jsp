<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="css/compiler.css">
<script type="text/javascript" src="js/compiler.js"></script>
<div class="row  pull-right col-md-10">
<div class="row">
		<!--  All folders of user to store created java program -->
	<div class="col-md-12 pull-left">
		<div class="panel panel-primary">
			<div class="panel-heading">
			<p class="panel-title">Your folders to store Data/File </p>
			</div>
		<div class="panel-body">
			<div class="container-fluid">
				<c:if test="${folders !=null}">
				<div class="form-group">
				<label for="jarFolder" class="control-label">Select folder to store programs</label>
				<select name="jarFolder" id="fid" class="form-control">
					<c:forEach items="${folders}" var="folder">
						<option  value="${folder.id}">${folder.name}</option>
					</c:forEach>
				</select>
				</div>
				</c:if>			
			</div>
		</div>
	</div>
</div>
</div>
		<!-- end of included page -->
<div class="row">
		<div class="col-md-6">
			
			<div class="panel panel-primary">
			<div class="panel-heading">
			<h1 class="panel-title">Code Window</h1>
			</div>
			<div class="panel-body">
			<!-- 
			You can write your code here.
			 -->
			<div id="divCodeWrapper">
				<div id="divCodeShow">
					<pre class="prettyprint" style="padding:9.5px!important;"></pre>
				</div>
				<div id="divCode" title="Java Program"  spellcheck="false" contenteditable="true" curser="active" style="opacity:0.5" >
					
					<pre>
					<ol ><li >import java.util.*;</li><li>class Test{</li><li>public static void main(String args[]){</li><li>System.out.println("Hello");</li><li>}</li><li>}</li></ol>
					</pre>
				
				</div>
			</div>
			</div>
			<div class="panel-footer">
			<button id="compile" class="btn btn-primary" type="button">Compile</button>
			<button id="run" class="btn btn-primary" type="button">Execute</button>
			
			</div>
			<div>
			<div class="form-group">
			<label><b>Run Time value:</b></label>
			<input type="text" id="cmdrtv"name="rtv" class="form-control">
			<label><b>Run Time Arguments:</b></label>
			<input type="text" id="cmdrta"name="rtv" class="form-control">
			</div>
			</div>
			</div>
			</div>
		<div class="col-md-6 pull-right">
			
			<div class="panel panel-primary">
			<div class="panel-heading">
			<h1 class="panel-title">Console Window</h1>
			</div>
			<div class="panel-body">
			<!-- <textarea class="form-control" rows="14" readonly>
			Result of compilation, Execution and Error messages will be displayed here.
			</textarea> -->
			<div id="divConsole" title="Console" >
				<ul>
					<li>Result of compilation, Execution and Error messages will be displayed here.</li>
				</ul>
			</div>
			</div>
			<div class="panel-footer">
			
			<button class="btn btn-primary" type="button">Clear</button>
			<!-- <button class="btn btn-primary pull-right" type="button"> Capture Code to post </button> -->
			</div>
			</div>
		</div>
		</div>
	</div>
<script>
$(document).ready(function(){
	
	$('#compile').click(function(){
		var code=getText($('#divCode'));
		//var code=$('#divCode').text();
		var id=$('#fid').find(":selected").val();
		//alert("code is :"+code);
		//console.log("code is :"+code);
		//console.log("id is :"+id);
			var html="<li>Result of compilation, Execution and Error messages will be displayed here.</li>";
			//console.log("html is :"+html);
		$.post("compiler.action", {'code':code ,'id':id},function(data){
			 var obj=data.split('\n');
			 //console.log("obj is :"+obj);
			
			$(obj).each(function(i,e){
				e=$.trim(e);
				console.log("value of e is :"+e);
				console.log("value of i is :"+i);
				if(e!=""){
					if(e.match("Failed")){
						html=html+"<li style='color: red;'>"+e+"</li>";
						showMessage(e);
					}
					else if(e.match("Successfully")){
						html=html+"<li style='color: green;'><b>"+e+"</b></li>";
						showMessage(e);
					}
					else
						{
						html=html+"<li style='color: red;'>"+e+"</li>";
					}
				}
			}); 
			$("#divConsole ul li").html("").append(html);
		}); 
	});
	
	
	$('#run').click(function(){
		var html="";
		var id=$('#fid').find(":selected").val();
		var args=$('#cmdrta').val();
		var rtv=$('#cmdrtv').val();
		
		console.log("var id=$('#fid') : "+id);
		console.log("var args=$('#cmdrta').text();  :"+args);
		console.log("var rtv=$('#rtv').val(); "+rtv);
		
		$.post("run.action",{'id':id,'args':args,'rtv':rtv},function(data){
			var object=data.split('\n');
			$(object).each(function(i,e){	
				e=$.trim(e);
				alert(e);
				if(e != ""){
					if(e.match("Successfully")){
						showMessage(e);
						html=html+"<li><b>"+e+"</b></li>";
					}
					else if(e.match("RunTime")){
						html=html+"<li style='color: red;'><b>"+e+"</b></li>";
					}
					else
						{
						html=html+"<li>"+e+"</li>";
					}
				}
		 	}); 
			$("#divConsole ul li").html("").append(html);
		}); 
	});
	
});

function getText(obj){
	var reg=new RegExp('</li>','g');
	var reg2=new RegExp('\\n','g');
	var reg3=new RegExp('&nbsp;','g');
	var txtList=$(obj).html().replace(reg3,' ').replace(reg,'::::').replace(reg2,'').split('>');
	alert(txtList);
	var txt='';
	$(txtList).each(function(i,e){
		var startIndex=e.indexOf('<');
		var endIndex=e.length;
		txt+=e.replace(e.substring(startIndex,endIndex),'');
	});
	return txt;
}
</script>