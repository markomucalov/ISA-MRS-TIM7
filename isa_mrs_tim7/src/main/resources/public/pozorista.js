function dobaviPozorista() {
	
	$.get('http://localhost:8080/pozorista', function (data) {
		var response = data;
		$("#pocetna").hide();
		$("#pozorista_prikaz").show();
		var table = document.getElementById("tabela");
		var countRow = 0;
		
		for(var counter in response.content){
			var row = table.insertRow(countRow);
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var adresaTemp = response.content[counter].adresa;
			cell1.innerHTML = countRow+1;
			cell2.innerHTML = response.content[counter].naziv;
			cell3.innerHTML = adresaTemp.ulica+" "+adresaTemp.broj+" "+adresaTemp.grad+" "+adresaTemp.zip;
			cell4.innerHTML = "udaljenost";
			cell5.innerHTML = '<button class="btn btn-primary">repertoar</button>';	
			countRow++;
		}
	})
     getMapLocation();
}

function povratakNaPocetnu(){
	$("#pocetna").toggle();
	$("#pozorista_prikaz").toggle();
	$("#tabela").empty();
	
}

var y = document.getElementById("map");
var mapLatitude;
var mapLongitude;
var myLatlng;
var map;

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
    var marker = new google.maps.Marker({
      position: myLatlng,
      map: map,
      title:"Vasa pozicija"
    });
  }