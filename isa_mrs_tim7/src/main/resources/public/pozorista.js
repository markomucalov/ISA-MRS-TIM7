function dobaviPozorista() {
	
	$.get('http://localhost:8080/pozorista', function (data) {
		var response = data;
		$("#pocetna").hide();
		$("#pozorista_prikaz").show();
		$("#map").show();
		var table = document.getElementById("tabela_pozorista");
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
			cell6.innerHTML = '<button class="btn btn-primary">repertoar</button>';
			
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

function dobaviBioskope() {
	
	$.get('http://localhost:8080/bioskopi', function (data) {
		var response = data;
		$("#pocetna").hide();
		$("#bioskopi_prikaz").show();
		$("#map").show();
		var table = document.getElementById("tabela_bioskopi");
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
			
			cell6.innerHTML = '<button class="btn btn-primary">repertoar</button>';
			
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

function povratakNaPocetnuPozorista(){
	$("#pocetna").toggle();
	$("#pozorista_prikaz").toggle();
	$("#tabela_pozorista").empty();
	$("#map").toggle();
}

function povratakNaPocetnuBioskopi(){
	$("#pocetna").toggle();
	$("#bioskopi_prikaz").toggle();
	$("#tabela_bioskopi").empty();
	$("#map").toggle();
}

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
			    marker.setPosition(dest);
			    marker.setTitle(currow.find('td:eq(1)').text());
			    } 
		});
	})
}