//alert("I'm active");

function newVehicle(){

	var r = $('#regnum').val();
	var m = $('#man option:selected').text();
	var t = $('#type option:selected').text();
	var y = $('#yop').val();
	
	alert("forgalmi rendszám: " + r + ", gyártó: " + m + ", típus: " + t + ", gyártás éve: " + y);

}
