function range() {

	var s1 = $("#s1").val();
	$("#l1").css("opacity", "0."+s1); 
	var s2 = $("#s2").val();
	$("#l2").css("opacity", "0."+s2); 
	var s3 = $("#s3").val();
	$("#l3").css("opacity", "0."+s3); 
	var s4 = $("#s4").val();
	$("#l4").css("opacity", "0."+s4); 
}
function check(){
	if ($("#c1").is(':checked')) {
		alert('Ko');
	}
}
