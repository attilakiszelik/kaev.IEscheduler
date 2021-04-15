function onload(){
	
	var ids = [1, 2, 3, 4, 5];
    
    for (i = 0; i < ids.length; i++) { 
    	$( "#modifyVehicle" + ids[i] + "row" ).toggle();
    	$( "#deleteVehicle" + ids[i] + "row" ).toggle();
	}
    
}

function toggle_modifyRow(id){
	$( "#" + id + "row" ).toggle();
}

function toggle_deleteRow(id){
	$( "#" + id + "row" ).toggle();
}