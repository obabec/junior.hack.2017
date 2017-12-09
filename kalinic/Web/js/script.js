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
	if (document.getElementById("c1").checked) {
		$("#d1").css("opacity", "1");
	}
	if (!document.getElementById("c1").checked) {
		$("#d1").css("opacity", "0");
	}

	if (document.getElementById("c2").checked) {
		$("#d2").css("opacity", "1");
	}
	if (!document.getElementById("c2").checked) {
		$("#d2").css("opacity", "0");
	}

	if (document.getElementById("c3").checked) {
		$("#d3").css("opacity", "1");
	}
	if (!document.getElementById("c3").checked) {
		$("#d3").css("opacity", "0");
	}
	if (document.getElementById("c4").checked) {
		$("#d4").css("opacity", "1");
	}
	if (!document.getElementById("c4").checked) {
		$("#d4").css("opacity", "0");
	}
	if (document.getElementById("c5").checked) {
		$("#d5").css("opacity", "1");
	}
	if (!document.getElementById("c5").checked) {
		$("#d5").css("opacity", "0");
	}

}
var locker=0;
function lock(){
	locker++;
	if(locker%2==1){
		$("#lock2").css("opacity", "1"); 
	}
	else{
		$("#lock2").css("opacity", "0");
	}
}
