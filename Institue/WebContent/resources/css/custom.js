/**
 * This is custom js file all the custom js code have to be write here  
 */

$(document).ready(function() {
	$('#myTab a').click(function (e) {
	  e.preventDefault()
	  $(this).tab('show')
	});
	$("#show_class").hide();
	$("#show_batch").hide();
	$(".notice").change(function(){
		if ($(this).val() == "class"){
			$("#show_class").show();
			$("#show_batch").hide();
		} 
		if($(this).val() == "batch"){
			$("#show_class").hide();
			$("#show_batch").show();			
		}
		if($(this).val() == ""){
			$("#show_class").hide();
			$("#show_batch").hide();			
		}
	});
});