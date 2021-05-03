//GLOBAL VARIABLES

var opened = 'nothing';

//VEHICLES

function vehicles_onload(){
    
    //httpGetAsync(theUrl, callback)

    var ids = [1, 2, 3, 4, 5];
    
    for (i = 0; i < ids.length; i++) { 
    	$( "#modifyVehicle" + ids[i] + "row" ).toggle();
    	$( "#deleteVehicle" + ids[i] + "row" ).toggle();
	}
    
}

/* https://stackoverflow.com/questions/247483/http-get-request-in-javascript
function httpGetAsync(theUrl, callback){
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.onreadystatechange = function() { 
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200)
            callback(xmlHttp.responseText);
    }
    xmlHttp.open("GET", theUrl, true); // true for asynchronous 
    xmlHttp.send(null);
}
*/

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

    var ids = [2];
    
    for (i = 0; i < ids.length; i++) { 
    	$( "#acceptUser" + ids[i] + "row" ).toggle();
    	$( "#declineUser" + ids[i] + "row" ).toggle();
	}

}

function toggle_acceptRow(id){
	$( "#" + id + "row" ).toggle();
}

function toggle_declineRow(id){
    $( "#" + id + "row" ).toggle();
}

//SCHEDULER

function scheduler_onload(){
    
    document.getElementById('dateselector').value = new Date().toISOString().slice(0, 10);
    setDays();
    checkDays();
    
}

function minusOneDay(){
    var result = new Date(document.getElementById('dateselector').value);
    result.setDate(result.getDate() - 1);
    document.getElementById('dateselector').value = result.toISOString().slice(0, 10);
    setDays();
    checkDays();
}

function plusOneDay(){
    var result = new Date(document.getElementById('dateselector').value);
    result.setDate(result.getDate() + 1);
    document.getElementById('dateselector').value = result.toISOString().slice(0, 10);
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

    alert(id);

}