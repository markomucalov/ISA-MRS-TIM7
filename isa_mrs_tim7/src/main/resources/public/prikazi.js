
var ulogovaniAdmin = "jovaperic";

$("#dobavi").on("click", function() {
	dobaviPoz();
	});

$("#dobaviBio").on("click", function() {
	dobaviBio();
	});





function dobaviPoz() {
	
	
	$.get('http://localhost:8080/pozorista', function (data) {
		var response = data;
		
		var table = document.getElementById("tabela_poz");
		$("#tabela_poz").empty();
		const starTotal = 5;
		var countRow = 0;
		
		for(var counter in response.content){
			
			var row = table.insertRow(countRow);
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var cell6 = row.insertCell(5);
			var adresaTemp = response.content[counter].adresa;
			cell1.innerHTML = countRow+1;
			cell2.innerHTML = response.content[counter].naziv;
			cell3.innerHTML = adresaTemp.ulica+" "+adresaTemp.broj+" "+adresaTemp.grad+" "+adresaTemp.zip;
			cell4.innerHTML = "udaljenost";
			
			cell6.innerHTML = '<button class="btn btn-primary" onclick="prikaziRepertoarPozoriste()">repertoar</button>';
			
			var starPercentage = (response.content[counter].rejting / starTotal) * 100;
			if(starPercentage < 10){
				cell5.innerHTML = '<span class="rating-static rating-5"></span>';
			}
			else if(starPercentage >= 10 && starPercentage < 20){
				cell5.innerHTML = '<span class="rating-static rating-10"></span>';
			}
			else if(starPercentage >= 20 && starPercentage < 30){
				cell5.innerHTML = '<span class="rating-static rating-15"></span>';
			}
			else if(starPercentage >= 30 && starPercentage < 40){
				cell5.innerHTML = '<span class="rating-static rating-20"></span>';
			}
			else if(starPercentage >= 40 && starPercentage < 50){
				cell5.innerHTML = '<span class="rating-static rating-25"></span>';
			}
			else if(starPercentage >= 50 && starPercentage < 60){
				cell5.innerHTML = '<span class="rating-static rating-30"></span>';
			}
			else if(starPercentage >= 60 && starPercentage < 70){
				cell5.innerHTML = '<span class="rating-static rating-35"></span>';
			}
			else if(starPercentage >= 70 && starPercentage < 80){
				cell5.innerHTML = '<span class="rating-static rating-40"></span>';
			}
			else if(starPercentage >= 80 && starPercentage < 90){
				cell5.innerHTML = '<span class="rating-static rating-45"></span>';
			}
			else if(starPercentage >= 90){
				cell5.innerHTML = '<span class="rating-static rating-50"></span>';
			}
			countRow++;
		}
	})
	
     getMapLocation();
}

function dobaviBio() {
	
	
	$.get('http://localhost:8080/bioskopi', function (data) {
		var response = data;
		
		var table = document.getElementById("tabela_bio");
		$("#tabela_bio").empty();
		const starTotal = 5;
		var countRow = 0;
		
		for(var counter in response.content){
			
			var row = table.insertRow(countRow);
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var cell6 = row.insertCell(5);
			var adresaTemp = response.content[counter].adresa;
			cell1.innerHTML = countRow+1;
			cell2.innerHTML = response.content[counter].naziv;
			cell3.innerHTML = adresaTemp.ulica+" "+adresaTemp.broj+" "+adresaTemp.grad+" "+adresaTemp.zip;
			cell4.innerHTML = "udaljenost";
			
			cell6.innerHTML = '<button class="btn btn-primary" onclick="prikaziRepertoarBiskopa()">repertoar</button>';
			
			var starPercentage = (response.content[counter].rejting / starTotal) * 100;
			if(starPercentage < 10){
				cell5.innerHTML = '<span class="rating-static rating-5"></span>';
			}
			else if(starPercentage >= 10 && starPercentage < 20){
				cell5.innerHTML = '<span class="rating-static rating-10"></span>';
			}
			else if(starPercentage >= 20 && starPercentage < 30){
				cell5.innerHTML = '<span class="rating-static rating-15"></span>';
			}
			else if(starPercentage >= 30 && starPercentage < 40){
				cell5.innerHTML = '<span class="rating-static rating-20"></span>';
			}
			else if(starPercentage >= 40 && starPercentage < 50){
				cell5.innerHTML = '<span class="rating-static rating-25"></span>';
			}
			else if(starPercentage >= 50 && starPercentage < 60){
				cell5.innerHTML = '<span class="rating-static rating-30"></span>';
			}
			else if(starPercentage >= 60 && starPercentage < 70){
				cell5.innerHTML = '<span class="rating-static rating-35"></span>';
			}
			else if(starPercentage >= 70 && starPercentage < 80){
				cell5.innerHTML = '<span class="rating-static rating-40"></span>';
			}
			else if(starPercentage >= 80 && starPercentage < 90){
				cell5.innerHTML = '<span class="rating-static rating-45"></span>';
			}
			else if(starPercentage >= 90){
				cell5.innerHTML = '<span class="rating-static rating-50"></span>';
			}
			countRow++;
		}
	})
	
     getMapLocation();
}
$('th').click(function(){
    var table = $(this).parents('table').eq(0)
    var rows = table.find('tr:gt(0)').toArray().sort(comparer($(this).index()))
    this.asc = !this.asc
    if (!this.asc){rows = rows.reverse()}
    for (var i = 0; i < rows.length; i++){table.append(rows[i])}
})
function comparer(index) {
    return function(a, b) {
        var valA = getCellValue(a, index), valB = getCellValue(b, index)
        return $.isNumeric(valA) && $.isNumeric(valB) ? valA - valB : valA.toString().localeCompare(valB)
    }
}
function getCellValue(row, index){ return $(row).children('td').eq(index).text() }

var y = document.getElementById("map");
var mapLatitude;
var mapLongitude;
var myLatlng;
var map;
var marker;

function getMapLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showMapPosition);
    } else {
        y.innerHTML = "Lokacija nije podrzana za ovaj pretrazivac.";
    }
}
function showMapPosition(position) {
    mapLatitude = position.coords.latitude;
    mapLongitude = position.coords.longitude;
    myLatlng = new google.maps.LatLng(mapLatitude,mapLongitude);
    initMap();
}
function initMap() {
	
    var uluru = {lat: 44.787197, lng: 20.457273};
    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 6,
      center: new google.maps.LatLng(mapLatitude, mapLongitude)
    });
    marker = new google.maps.Marker({
      position: myLatlng,
      map: map,
      title:"Vasa pozicija"
    });
  }




function preuzmiAdresu(param){

	$("#t_"+param+" tbody").on('click', 'tr', function(){
		var geocoder = new google.maps.Geocoder();
		var currow = $(this).closest('tr');
		var address = currow.find('td:eq(2)').text();
		
		
		geocoder.geocode( { 'address': address}, function(results, status) {

			if (status == google.maps.GeocoderStatus.OK) {
			    var latitude = results[0].geometry.location.lat();
			    var longitude = results[0].geometry.location.lng();
			    var dest = new google.maps.LatLng( latitude, longitude );
			    var distance_in_meters = google.maps.geometry.spherical.computeDistanceBetween( myLatlng, dest );
			    currow.find('td:eq(3)').text(Math.round((distance_in_meters/1000) * 100) / 100+" km");
			   
			    } 
		});
	})
}

function prikaziRepertoarPozoriste(){
	
	
	alert("Repertoar za odabrano pozoriste trenutno ne postoji." );
	
	
	
	
	
}


function prikaziRepertoarBiskopa(){
	
	var div1 = document.getElementById("sakrij1");
    var div2 = document.getElementById("sakrij2");
    var mapa = document.getElementById("map");
    var prikaz=document.getElementById("prikazRepBio");
    naz=
    div1.style.display = "none";
    div2.style.display = "none";
    mapa.style.display = "none";
    prikaz.style.display="show";
    
    
    $.get('http://localhost:8080/repertoariPrikaz', function (data) {
		var response = data;
		
		var table = document.getElementById("tabela_repBio");
		
		
		var countRow = 0;
		
for(var counter in response){
	      
			
			var row = table.insertRow(countRow);
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var cell6 = row.insertCell(5);
			var cell7 = row.insertCell(6);
			
			
			cell1.innerHTML = countRow+1;
			cell2.innerHTML = response[counter].naslov;
			cell3.innerHTML = response[counter].datum;
			cell4.innerHTML = response[counter].pocetak;
			cell5.innerHTML = response[counter].id;
			cell6.innerHTML = response[counter].trajanje;
			
				
				
				
				
			
			cell7.innerHTML = '<button class="btn btn-primary" onClick="rezervisiMesto()">rezervisi</button>';
			
			countRow++;
}
		
		
		
	})
	
	
    
    
    
    
    
    
	
}
var idTerm="";



function rezervisiMesto(){
	var naslov=$(event.target).parent().siblings().first().next().text();
	var datum=$(event.target).parent().siblings().first().next().next().text();
	var pocetak=$(event.target).parent().siblings().first().next().next().next().text();
	
	idTerm=$(event.target).parent().siblings().first().next().next().next().next().text();
	
	nas1=naslov;
	dat1=datum;
	poc1=pocetak;
	
	var prikaz=document.getElementById("prikazRepBio");
	var param="sala1";
	postavi(param);
	
	prikaz.style.display="none";
	$("#konfigur").show();
	
	
	
	$.get('http://localhost:8080/getAllKarteZauzete', function (data) {		
		var response = data;
		
		var trenutni=0;
		
		
		for(var i = 1; i<= 10; i++){
			for(var j = 1; j<=12; j++){
				for(var a in response){
				if(response[a].red == i && response[a].kolona == j && response[a].naslov==naslov && response[a].datum==datum && response[a].pocetak==pocetak){
					
					
					
					$("#rec"+i+j).css({ fill: "#ff0000", stroke: "#000000" });
					$("#rec"+i+j).attr("name", "rezervisano");
					$("#rec"+i+j).remove();
					//$("#rec"+i+j).unbind('click'); 
					
					
				}
				}
		     
			}
			}
	
	})
	
	
	
	
	


}

function obavestenje(){alert("Sediste je zauzeto");



}

function postavi(param){
	
	
	$.get('http://localhost:8080/'+ulogovaniAdmin+'/'+param+'/konfiguracijaSale', function (data) {		
		var response = data;
		var trenutni = 0;
	
	for(var i = 1; i<= 10; i++){
		for(var j = 1; j<=12; j++){
			if(response[trenutni].tipSedista == "OBICNO" && response[trenutni].red == i && response[trenutni].kolona == j){
				$("#rec"+i+j).css({ fill: "#ffffff", stroke: "#000000" });
				$("#rec"+i+j).attr("name", "obicno");
				/*$("#rec"+i+j).attr("onclick", "promenaKonfiguracije()");*/
				$("#rec"+i+j).on('click', function(d,i) {
					var idSedista = this.id;
					if($('#opcijaObicno').is(':checked')) {
						$("#"+idSedista).css({ fill: "#ffffff", stroke: "#000000" });
						$("#"+idSedista).attr("name", "obicno"); 
					}
					
					else if($('#opcijaProlaz').is(':checked')) {
						$("#"+idSedista).css({ fill: "#0066ff", stroke: "#000000" });
						$("#"+idSedista).attr("name", "zauzeto"); 
					}
		        })
				$("#rec"+i+j).show();
			}
			else if(response[trenutni].tipSedista == "VIP" && response[trenutni].red == i && response[trenutni].kolona == j){
				$("#rec"+i+j).css({ fill: "#ff9900", stroke: "#000000" });
				$("#rec"+i+j).attr("name", "vip");
				/*$("#rec"+i+j).attr("onclick", "promenaKonfiguracije()");*/
				$("#rec"+i+j).on('click', function(d,i) {
					var idSedista = this.id;
					if($('#opcijaObicno').is(':checked')) {
						$("#"+idSedista).css({ fill: "#ffffff", stroke: "#000000" });
						$("#"+idSedista).attr("name", "obicno"); 
					}
					
					else if($('#opcijaProlaz').is(':checked')) {
						$("#"+idSedista).css({ fill: "#0066ff", stroke: "#000000" });
						$("#"+idSedista).attr("name", "zauzeto"); 
					}
		        })
				$("#rec"+i+j).show();
			}
			else if(response[trenutni].tipSedista == "ZA_BRZU_REZERVACIJU" && response[trenutni].red == i && response[trenutni].kolona == j){
				$("#rec"+i+j).css({ fill: "#33cc33", stroke: "#000000" });
				$("#rec"+i+j).attr("name", "brza");
				/*$("#rec"+i+j).attr("onclick", "promenaKonfiguracije()");*/
				
				$("#rec"+i+j).show();
			}
			else if(response[trenutni].tipSedista == "PROLAZ" && response[trenutni].red == i && response[trenutni].kolona == j){
				$("#rec"+i+j).css({ fill: "#ffffff", stroke: "#ffffff" });
				$("#rec"+i+j).attr("name", "prolaz");
				
			}
			
			
			trenutni++;
		}
	}
	})
}


function potvrdi(){
	var em = document.getElementById("email").innerHTML
	alert(em);
	
	var konfiguracijaDTO={
			"korisnickoIme": em,
		    "sedista": [],
		    "sala": idTerm
		}
	var brojac = 0;
	
	for(var i = 1; i<= 10; i++){
		for(var j = 1; j<=12; j++){
			if($("#rec"+i+j).attr("name", "zauzeto")){
			var sediste={
					"red": i,
					"kolona": j,
					"tip": $("#rec"+i+j).attr("name")
			}
			konfiguracijaDTO.sedista[brojac] = sediste;
			brojac++;			
		}}
	}
	
	$.ajax({
	    url: 'http://localhost:8080/sacuvajKartu',
	    type: 'POST',
	    data: JSON.stringify(konfiguracijaDTO),
	    contentType: "application/json; charset=utf-8",
	    dataType: "json",
	    statusCode: {
		    200: function() {
		    	alert('Uspesno ste sacuvali konfiguraciju.');
		    }
		  },
	    success: function(result) {
	    	alert('Uspesno ste sacuvali konfiguraciju.');
	    }
	});
	
	
	
	
	
	
	
	
	
	
	
	
}	
	
	



$("#search_poz").keyup(function () {
    var value = this.value.toLowerCase().trim();

    $("table tr").each(function (index) {
        if (!index) return;
        $(this).find("td").each(function () {
            var id = $(this).text().toLowerCase().trim();
            var not_found = (id.indexOf(value) == -1);
            $(this).closest('tr').toggle(!not_found);
            return not_found;
        });
    });
});


$("#search_bio").keyup(function () {
    var value = this.value.toLowerCase().trim();

    $("table tr").each(function (index) {
        if (!index) return;
        $(this).find("td").each(function () {
            var id = $(this).text().toLowerCase().trim();
            var not_found = (id.indexOf(value) == -1);
            $(this).closest('tr').toggle(!not_found);
            return not_found;
        });
    });
});