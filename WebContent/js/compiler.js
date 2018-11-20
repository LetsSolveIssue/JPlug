
function makeTextCode()
{
var code=$('#divCode pre').html();
$('#divCodeShow pre').html(code);
$('.prettyprinted').removeClass('prettyprinted');
newPretyPrint();
}
$(document).ready(function(){

$('#divCode').keyup(function(){
makeTextCode();
});
makeTextCode();
});