//GLOBAL VARIABLES

var opened = 'nothing';
var getVehiclesIds_Url = 'http://localhost:9000/getVehiclesIds';
var getVehiclesRegnums_Url = 'http://localhost:9000/getVehiclesRegnums';
var getAvaiableServices_Url = 'http://localhost:9000/getAvaiableServices';
var getMyBookings_Url = 'http://localhost:9000/getMyBookings';

//VEHICLES

function vehicles_onload(){

    $.ajax({ url: getVehiclesIds_Url,
    		 dataType: 'json',
    		 success: function(ids){
			    for (i = 0; i < ids.length; i++) { 
			    	$( "#modifyVehicle" + ids[i] + "row" ).toggle();
			    	$( "#deleteVehicle" + ids[i] + "row" ).toggle();
				}
    		 },
    });
   
}

function toggle_modifyRow(id){

    if (opened != 'nothing') {

        $( opened ).toggle();
        $( "#" + id + "row" ).toggle();
        opened = "#" + id + "row";

    } else {

        $( "#" + id + "row" ).toggle();
        opened = "#" + id + "row";

    }
}

function toggle_deleteRow(id){

    if (opened != 'nothing') {

        $( opened ).toggle();
	    $( "#" + id + "row" ).toggle();
        opened = "#" + id + "row";

    } else {

        $( "#" + id + "row" ).toggle();
        opened = "#" + id + "row";  

    }
}

function untoggle(id){

    $("#" + id).parent().parent().parent().parent().toggle();
    opened = 'nothing';    

}

//REGISTRATIONS

function registrations_onload(){

    var ids = [1,2,3];
    
    for (i = 0; i <= ids.length; i++) { 
    	$( "#acceptUser" + ids[i] + "row" ).toggle();
    	$( "#declineUser" + ids[i] + "row" ).toggle();
    	$( "#deleteUser" + ids[i] + "row" ).toggle();
	}

}

function toggle_acceptRow(id){
	$( "#" + id + "row" ).toggle();
}

function toggle_declineRow(id){
    $( "#" + id + "row" ).toggle();
}

function toggle_deleteRow(id){
    $( "#" + id + "row" ).toggle();
}

//BOOKINGS

function bookings_onload(){

    var ids = [1,2,3];
    
    for (i = 0; i <= ids.length; i++) { 
    	$( "#acceptEvent" + ids[i] + "row" ).toggle();
    	$( "#declineEvent" + ids[i] + "row" ).toggle();
	}

}

function toggle_acceptEvent(id){
	$( "#" + id + "row" ).toggle();
}

function toggle_declineEvent(id){
    $( "#" + id + "row" ).toggle();
}

//SCHEDULER

function scheduler_onload(){

	var dayToSet = new Date();
	var today = new Date();
	
	if(today.getDay() == 6) dayToSet.setDate(today.getDate() + 2)
	if(today.getDay() == 0) dayToSet.setDate(today.getDate() + 1)
    
    document.getElementById('dateselector').value = dayToSet.toISOString().slice(0, 10);
    
    setDays();
    checkDays();
    
    setMyBookings();
    
}

function minusOneWeek(){
    var result = new Date(document.getElementById('dateselector').value);
    result.setDate(result.getDate() - 7);
    document.getElementById('dateselector').value = result.toISOString().slice(0, 10);
    setDays();
    checkDays();
}

function plusOneWeek(){
    var result = new Date(document.getElementById('dateselector').value);
    result.setDate(result.getDate() + 7);
    document.getElementById('dateselector').value = result.toISOString().slice(0, 10);
    setDays();
    checkDays();
}

function datechanged(){
	setDays();
    checkDays();
}

function setDays(){
    var day = new Date(document.getElementById('dateselector').value);

    if (day.getDay() == 0){

        var day1 = new Date(document.getElementById('dateselector').value);
        day1.setDate(day1.getDate() - 6);
        var day2 = new Date(document.getElementById('dateselector').value);
        day2.setDate(day2.getDate() - 5);
        var day3 = new Date(document.getElementById('dateselector').value);
        day3.setDate(day3.getDate() - 4);
        var day4 = new Date(document.getElementById('dateselector').value);
        day4.setDate(day4.getDate() - 3);
        var day5 = new Date(document.getElementById('dateselector').value);
        day5.setDate(day5.getDate() - 2);

        document.getElementById('day1').innerHTML = day1.toISOString().slice(0, 10);
        document.getElementById('day2').innerHTML = day2.toISOString().slice(0, 10);
        document.getElementById('day3').innerHTML = day3.toISOString().slice(0, 10);
        document.getElementById('day4').innerHTML = day4.toISOString().slice(0, 10);
        document.getElementById('day5').innerHTML = day5.toISOString().slice(0, 10);

    }
    if (day.getDay() == 1){

        var day2 = new Date(document.getElementById('dateselector').value);
        day2.setDate(day2.getDate() + 1);
        var day3 = new Date(document.getElementById('dateselector').value);
        day3.setDate(day3.getDate() + 2);
        var day4 = new Date(document.getElementById('dateselector').value);
        day4.setDate(day4.getDate() + 3);
        var day5 = new Date(document.getElementById('dateselector').value);
        day5.setDate(day5.getDate() + 4);

        document.getElementById('day1').innerHTML = day.toISOString().slice(0, 10);
        document.getElementById('day2').innerHTML = day2.toISOString().slice(0, 10);
        document.getElementById('day3').innerHTML = day3.toISOString().slice(0, 10);
        document.getElementById('day4').innerHTML = day4.toISOString().slice(0, 10);
        document.getElementById('day5').innerHTML = day5.toISOString().slice(0, 10);

    }
    if (day.getDay() == 2){

        var day1 = new Date(document.getElementById('dateselector').value);
        day1.setDate(day1.getDate() - 1);
        var day3 = new Date(document.getElementById('dateselector').value);
        day3.setDate(day3.getDate() + 1);
        var day4 = new Date(document.getElementById('dateselector').value);
        day4.setDate(day4.getDate() + 2);
        var day5 = new Date(document.getElementById('dateselector').value);
        day5.setDate(day5.getDate() + 3);

        document.getElementById('day1').innerHTML = day1.toISOString().slice(0, 10);
        document.getElementById('day2').innerHTML = day.toISOString().slice(0, 10);
        document.getElementById('day3').innerHTML = day3.toISOString().slice(0, 10);
        document.getElementById('day4').innerHTML = day4.toISOString().slice(0, 10);
        document.getElementById('day5').innerHTML = day5.toISOString().slice(0, 10);

    }
    if (day.getDay() == 3){

        var day1 = new Date(document.getElementById('dateselector').value);
        day1.setDate(day1.getDate() - 2);
        var day2 = new Date(document.getElementById('dateselector').value);
        day2.setDate(day2.getDate() - 1);
        var day4 = new Date(document.getElementById('dateselector').value);
        day4.setDate(day4.getDate() + 1);
        var day5 = new Date(document.getElementById('dateselector').value);
        day5.setDate(day5.getDate() + 2);

        document.getElementById('day1').innerHTML = day1.toISOString().slice(0, 10);
        document.getElementById('day2').innerHTML = day2.toISOString().slice(0, 10);
        document.getElementById('day3').innerHTML = day.toISOString().slice(0, 10);
        document.getElementById('day4').innerHTML = day4.toISOString().slice(0, 10);
        document.getElementById('day5').innerHTML = day5.toISOString().slice(0, 10);

    }
    if (day.getDay() == 4){

        var day1 = new Date(document.getElementById('dateselector').value);
        day1.setDate(day1.getDate() - 3);
        var day2 = new Date(document.getElementById('dateselector').value);
        day2.setDate(day2.getDate() - 2);
        var day3 = new Date(document.getElementById('dateselector').value);
        day3.setDate(day3.getDate() - 1);
        var day5 = new Date(document.getElementById('dateselector').value);
        day5.setDate(day5.getDate() + 1);

        document.getElementById('day1').innerHTML = day1.toISOString().slice(0, 10);
        document.getElementById('day2').innerHTML = day2.toISOString().slice(0, 10);
        document.getElementById('day3').innerHTML = day3.toISOString().slice(0, 10);
        document.getElementById('day4').innerHTML = day.toISOString().slice(0, 10);
        document.getElementById('day5').innerHTML = day5.toISOString().slice(0, 10);

    }
    if (day.getDay() == 5){

        var day1 = new Date(document.getElementById('dateselector').value);
        day1.setDate(day1.getDate() - 4);
        var day2 = new Date(document.getElementById('dateselector').value);
        day2.setDate(day2.getDate() - 3);
        var day3 = new Date(document.getElementById('dateselector').value);
        day3.setDate(day3.getDate() - 2);
        var day4 = new Date(document.getElementById('dateselector').value);
        day4.setDate(day4.getDate() - 1);

        document.getElementById('day1').innerHTML = day1.toISOString().slice(0, 10);
        document.getElementById('day2').innerHTML = day2.toISOString().slice(0, 10);
        document.getElementById('day3').innerHTML = day3.toISOString().slice(0, 10);
        document.getElementById('day4').innerHTML = day4.toISOString().slice(0, 10);
        document.getElementById('day5').innerHTML = day.toISOString().slice(0, 10);

    }
    if (day.getDay() == 6){

        var day1 = new Date(document.getElementById('dateselector').value);
        day1.setDate(day1.getDate() - 5);
        var day2 = new Date(document.getElementById('dateselector').value);
        day2.setDate(day2.getDate() - 4);
        var day3 = new Date(document.getElementById('dateselector').value);
        day3.setDate(day3.getDate() - 3);
        var day4 = new Date(document.getElementById('dateselector').value);
        day4.setDate(day4.getDate() - 2);
        var day5 = new Date(document.getElementById('dateselector').value);
        day5.setDate(day5.getDate() - 1);

        document.getElementById('day1').innerHTML = day1.toISOString().slice(0, 10);
        document.getElementById('day2').innerHTML = day2.toISOString().slice(0, 10);
        document.getElementById('day3').innerHTML = day3.toISOString().slice(0, 10);
        document.getElementById('day4').innerHTML = day4.toISOString().slice(0, 10);
        document.getElementById('day5').innerHTML = day5.toISOString().slice(0, 10);

    }

}

function checkDays(){

    var blockDate = new Date();
    blockDate.setDate(blockDate.getDate());

    for (var i = 1; i <= 5; i++){

        date = (document.getElementById("day" + i).innerHTML).split('-');
        year = date[0];
        month = date[1];
        day = date[2];

        var checkDate = new Date(year + "-" + month + "-" + day + "T00:00:00.000")

        if(checkDate<blockDate){

            /* TODO:
            for(var j = 1; j <= 9; j++){
                blockTD(i,j);
            }
            */

            blockTD(i,1);
            blockTD(i,2);
            blockTD(i,3);
            blockTD(i,4);
            blockTD(i,5);
            blockTD(i,6);
            blockTD(i,7);
            blockTD(i,8);
            blockTD(i,9);

        } else {

            if( document.getElementById("d" + i + "t" + 1).className == 'blocked'){
                activateTD(i,1);
                activateTD(i,2);
                activateTD(i,3);
                activateTD(i,4);
                activateTD(i,5);
                activateTD(i,6);
                activateTD(i,7);
                activateTD(i,8);
                activateTD(i,9);
            }

        }

    }

}

function blockTD(day, time){

    document.getElementById("d" + day + "t" + time).className = 'blocked';
    document.getElementById("d" + day + "t" + time).toggleAttribute("data-bs-toggle");   

}

function activateTD(day, time){

    document.getElementById("d" + day + "t" + time).className = 'active';
    document.getElementById("d" + day + "t" + time).setAttribute("data-bs-toggle", "modal");
    
}

function uploadModal(id){

	//date
	
    var d = id.charAt(1); 
    var day = new Date(document.getElementById('day' + d).innerHTML);
    
    document.getElementById('modal-date').value = day.toISOString().slice(0, 10);
    
    //time
    
    var t = id.charAt(3);
    switch (t) {
	  case "1":
	    time = "07:00";
	    break;
	  case "2":
	    time = "08:00";
	    break;
	  case "3":
	    time = "09:00";
	    break;
	  case "4":
	    time = "10:00";
	    break;
	  case "5":
	    time = "11:00";
	    break;
	  case "6":
	    time = "12:00";
	    break;
	  case "7":
	    time = "13:00";
	    break;
	  case "8":
	    time = "14:00";
	    break;
	  case "9":
	    time = "15:00";
		break;
	}
	
	document.getElementById('modal-time').value = time;
	
	//vehicle's regnums
	
		//TODO: <option disabled>Please select...</option>
	
	/*	- feltöltés beégetett tömbből
	var vehicles = document.getElementById('modal-regnums');
	
	var r = ["ABC-123", "ABC-456", "ABC-789"];
	
    for (i = 0; i < r.length; i++) { 
		var option = document.createElement("option");
		option.text = r[i];
		option.value = i;
		vehicles.add(option);
	}
	*/
		
	/* - feltöltés ajax lekérdezésből
    $.ajax({ url: getVehiclesRegnums_Url,
		 dataType: 'json',
		 success: function(r){
		    for (i = 0; i < r.length; i++) { 
				var option = document.createElement("option");
				option.text = r[i];
				//TODO: option.value = ...;
				vehicles.add(option);
			}
		 },
	});
	*/
	
	//avaiable services
	
		//TODO: <option disabled>Please select...</option>
	
	/* - feltöltés beégetett tömbből
	var services = document.getElementById('modal-services');
	
	var s = ["műszaki vizsga felkészítés", "olajcsere", "fékbetét csere", "klíma töltés", "karosszéria javítás", "futómű beállítás"];
	
	for (i = 0; i < s.length; i++) { 
		var option = document.createElement("option");
		option.text = s[i];
		option.value = i;
		services.add(option);
	}
	*/
	
	/* - feltöltés ajax lekérdezésből	
    $.ajax({ url: getAvaiableServices_Url,
	 dataType: 'json',
	 success: function(s){
	    for (i = 0; i < s.length; i++) { 
			var option = document.createElement("option");
			option.text = s[i];
			//TODO: option.value = ...;
			services.add(option);
		}
	 },
	});
	*/	
	
}

function deloadModal(){

	alert(
		'dátum: ' + document.getElementById('modal-date').value + '\nidő: ' + document.getElementById('modal-time').value + '\njármű: ' + document.getElementById('modal-regnums').options[document.getElementById('modal-regnums').selectedIndex].text + '\nfeladat: ' + document.getElementById('modal-services').options[document.getElementById('modal-services').selectedIndex].text
	);

	var vehicles = document.getElementById('modal-regnums');
	
    for (i = vehicles.length; i > 0; i--) { 
		vehicles.remove(vehicles.i);
	}
	
	var services = document.getElementById('modal-services');
	
	for (i = services.length; i > 0; i--) { 
		services.remove(services.i);
	}

}

function setMyBookings(){

	$.ajax({ url: getMyBookings_Url,
	 dataType: 'json',
	 success: function(answer){
	 
	 	alert(JSON.stringify(answer));
	 	
	 	var myBookings = JSON.stringify(answer);
	 	alert(myBookings.length);
	 
	    for (i = 0; i < answer.length; i++) { 
			
		}
	 },
	});

}