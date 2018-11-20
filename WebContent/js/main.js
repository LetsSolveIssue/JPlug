var intervalId=null;
function showMessage(msg)
{
	$('#divMessage').show(200);
	$('#divMessage #spMessage').text(msg);
	clearInterval(intervalId);
	intervalId= setInterval(function(){$('#divMessage').hide(500); clearInterval(intervalId);}, 5000);
}
$(document).ajaxStart(function(){
	$('#imgSpinner').show();
	$('#divLayer').show();
});
$(document).ajaxComplete(function(){
	$('#imgSpinner').hide();
	$('#divLayer').hide();
});