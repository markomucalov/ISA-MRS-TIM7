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
			cell6.innerHTML = '<button class="btn btn-primary" onclick="prikaziRepertoarPozorista()">repertoar</button>';
			
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
			
			cell6.innerHTML = '<button class="btn btn-primary" onclick="prikaziRepertoarBioskopi()">repertoar</button>';
			
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

var prethodnaStranica;
var trenutnaStranaRezultati;
var ukupanBrojStrana;

function prikaziRepertoarBioskopi(){
	$("#bioskopi_prikaz").hide();
	$("#map").hide();
	var bioskopIme = $(event.target).parent().siblings().first().next().text();
	bioskopIme = bioskopIme.split(" ").join("%20");
	$("#repertoarPrikaz").load("repertoarBioskopi.html", function() {
		$("#nazPoBi").text(bioskopIme.split("%20").join(" "));
		$.get('http://localhost:8080/'+bioskopIme+'/filmovi/0', function (data) {
			trenutnaStranaRezultati = 0;
			var response = data;
			var numOfElems = response.numberOfElements;
			
			if(numOfElems < 4){
				var numOfElemsCounter = 1;
				while(numOfElemsCounter <= 4){
					if(numOfElemsCounter > numOfElems){
						$('#rep'+numOfElemsCounter).hide();
					}
					numOfElemsCounter++;
				}
			}
			var counter = 1;
			var contentCounter = 0;
			while(counter <= numOfElems){
				$("#rep"+counter+"-h").text(response.content[contentCounter].naizv);
				$("#rep"+counter+"-zanr").text(response.content[contentCounter].zanr);
				$("#rep"+counter+"-reditelj").text(response.content[contentCounter].imeReditelja);
				$("#rep"+counter+"-trajanje").text(response.content[contentCounter].trajanje);
				var glumci = response.content[contentCounter].spisakGlumaca;
				var glumciText="";
				glumci.forEach(function(element) {
					  glumciText = glumciText+element+" ";
					});
				$("#rep"+counter+"-glumci").text(glumciText);
				$("#rep"+counter+"-opis").text(response.content[contentCounter].opis);
				var ocene = response.content[contentCounter].ocene;
				var oceneSuma=0;
				if(ocene.length == 0){
					oceneSuma = 0;
				}
				else{
					ocene.forEach(function(element) {
						oceneSuma = oceneSuma+element;
						});
					oceneSuma = oceneSuma/ocene.length;
					oceneSuma = Math.round(oceneSuma * 100) / 100;
				}
				$("#rep"+counter+"-ocena").text(oceneSuma);
				$("#rep"+counter+"-cena").text(response.content[contentCounter].cena);
				$("#rep"+counter+"-img").attr('src', response.content[contentCounter].slika);
				counter++;
				contentCounter++;
			}
			var numOfPages = response.totalPages;
			ukupanBrojStrana = response.totalPages;
			var pageCounter = 1;
			while(pageCounter < numOfPages){
				pageCounter++
				$("#sledeca").before('<li class="page-item"><a class="page-link" href="#" onclick="stranicaRezultati('+pageCounter.toString()+')">'+pageCounter+'</a></li>');
			}
		})
	});
	$("#repertoarPrikaz").show();
	prethodnaStranica = "bioskopi";
}

var prethodnaStranicaPozorista;
var trenutnaStranaRezultatiPozorista;
var ukupanBrojStranaPozorista;

function prikaziRepertoarPozorista(){
	$("#pozorista_prikaz").hide();
	$("#map").hide();
	var pozoristeIme = $(event.target).parent().siblings().first().next().text();
	pozoristeIme = pozoristeIme.split(" ").join("%20");
	$("#repertoarPrikaz").load("repertoarPozorista.html", function() {
		$("#nazPoPo").text(pozoristeIme.split("%20").join(" "));
		$.get('http://localhost:8080/'+pozoristeIme+'/predstave/0', function (data) {
			trenutnaStranaRezultatiPozorista = 0;
			var response = data;
			var numOfElems = response.numberOfElements;
			
			if(numOfElems < 4){
				var numOfElemsCounter = 1;
				while(numOfElemsCounter <= 4){
					if(numOfElemsCounter > numOfElems){
						$('#rep'+numOfElemsCounter).hide();
					}
					numOfElemsCounter++;
				}
			}
			var counter = 1;
			var contentCounter = 0;
			while(counter <= numOfElems){
				$("#rep"+counter+"-h").text(response.content[contentCounter].naizv);
				$("#rep"+counter+"-zanr").text(response.content[contentCounter].zanr);
				$("#rep"+counter+"-reditelj").text(response.content[contentCounter].imeReditelja);
				$("#rep"+counter+"-trajanje").text(response.content[contentCounter].trajanje);
				var glumci = response.content[contentCounter].spisakGlumaca;
				var glumciText="";
				glumci.forEach(function(element) {
					  glumciText = glumciText+element+" ";
					});
				$("#rep"+counter+"-glumci").text(glumciText);
				$("#rep"+counter+"-opis").text(response.content[contentCounter].opis);
				var ocene = response.content[contentCounter].ocene;
				var oceneSuma=0;
				if(ocene.length == 0){
					oceneSuma=0;
				}
				else{
					ocene.forEach(function(element) {
						oceneSuma = oceneSuma+element;
						});
					oceneSuma = oceneSuma/ocene.length;
					oceneSuma = Math.round(oceneSuma * 100) / 100;
				}
				
				$("#rep"+counter+"-ocena").text(oceneSuma);
				$("#rep"+counter+"-cena").text(response.content[contentCounter].cena);
				$("#rep"+counter+"-img").attr('src', response.content[contentCounter].slika);
				counter++;
				contentCounter++;
			}
			var numOfPages = response.totalPages;
			ukupanBrojStrana = response.totalPages;
			var pageCounter = 1;
			while(pageCounter < numOfPages){
				pageCounter++
				$("#sledeca").before('<li class="page-item"><a class="page-link" href="#" onclick="stranicaRezultati('+pageCounter.toString()+')">'+pageCounter+'</a></li>');
			}
		})
	});
	$("#repertoarPrikaz").show();
	prethodnaStranicaPozorista = "pozorista";
}

function b64toBlob(b64Data, contentType, sliceSize) {
	  contentType = contentType || '';
	  sliceSize = sliceSize || 128;

	  var byteCharacters = atob(b64Data);
	  var byteArrays = [];

	  for (var offset = 0; offset < byteCharacters.length; offset += sliceSize) {
	    var slice = byteCharacters.slice(offset, offset + sliceSize);

	    var byteNumbers = new Array(slice.length);
	    for (var i = 0; i < slice.length; i++) {
	      byteNumbers[i] = slice.charCodeAt(i);
	    }

	    var byteArray = new Uint8Array(byteNumbers);

	    byteArrays.push(byteArray);
	  }

	  var blob = new Blob(byteArrays, {type: contentType});
	  return blob;
}

function stranicaRezultati(page){
	var stranica;
	if(trenutnaStranaRezultati == 0 && page == 'prethodna'){
		stranica = '0';
	}
	else if(trenutnaStranaRezultati == ukupanBrojStrana && ukupanBrojStrana != 0 && page == 'sledeca'){
		var poslednjaStrana = ukupanBrojStrana - 1;
		stranica = poslednjaStrana.toString();
	}
	else if(page == 'prethodna' && trenutnaStranaRezultati > 0){
		trenutnaStranaRezultati--;
		stranica = trenutnaStranaRezultati;
	}
	else if(page == 'sledeca' && trenutnaStranaRezultati < ukupanBrojStrana){
		trenutnaStranaRezultati++;
		stranica = trenutnaStranaRezultati;
	}
	else if(page !='prethodna' && page != 'sledeca'){
		var stranicaNaKojuIdemo = parseInt(page) - 1;
		if(stranicaNaKojuIdemo < 0){
			stranicaNaKojuIdemo = 0;
		}
		stranica = stranicaNaKojuIdemo.toString();
	}
	else{
		stranica = 0;
	}
	var bioskopIme = $('#nazPoBi').text();
	bioskopIme = bioskopIme.split(" ").join("%20");
	
	var i;
	for (i = 1; i < 5; i++) { 
		$('#rep'+i).show();
	}
	
	$.get('http://localhost:8080/'+bioskopIme+'/filmovi/'+stranica, function (data) {
		var response = data;
		var numOfElems = response.numberOfElements;
		if(numOfElems < 4){
			var numOfElemsCounter = 1;
			while(numOfElemsCounter <= 4){
				if(numOfElemsCounter > numOfElems){
					$('#rep'+numOfElemsCounter).hide();
				}
				numOfElemsCounter++;
			}
		}
		var counter = 1;
		var contentCounter = 0;
		while(counter <= numOfElems){
			$("#rep"+counter+"-h").text(response.content[contentCounter].naizv);
			$("#rep"+counter+"-zanr").text(response.content[contentCounter].zanr);
			$("#rep"+counter+"-reditelj").text(response.content[contentCounter].imeReditelja);
			$("#rep"+counter+"-trajanje").text(response.content[contentCounter].trajanje);
			var glumci = response.content[contentCounter].spisakGlumaca;
			var glumciText="";
			glumci.forEach(function(element) {
				  glumciText = glumciText+element+" ";
				});
			$("#rep"+counter+"-glumci").text(glumciText);
			$("#rep"+counter+"-opis").text(response.content[contentCounter].opis);
			var ocene = response.content[contentCounter].ocene;
			var oceneSuma=0;
			ocene.forEach(function(element) {
				oceneSuma = oceneSuma+element;
				});
			oceneSuma = oceneSuma/ocene.length;
			oceneSuma = Math.round(oceneSuma * 100) / 100;
			$("#rep"+counter+"-ocena").text(oceneSuma);
			$("#rep"+counter+"-cena").text(response.content[contentCounter].cena);
			$("#rep"+counter+"-img").attr('src', response.content[contentCounter].slika);
			counter++;
			contentCounter++;
		}
	})
}

function stranicaRezultatiPozorista(page){
	var stranica;
	if(trenutnaStranaRezultatiPozorista == 0 && page == 'prethodna'){
		stranica = '0';
	}
	else if(trenutnaStranaRezultatiPozorista == ukupanBrojStranaPozorista && ukupanBrojStranaPozorista != 0 && page == 'sledeca'){
		var poslednjaStrana = ukupanBrojStranaPozorista - 1;
		stranica = poslednjaStrana.toString();
	}
	else if(page == 'prethodna' && trenutnaStranaRezultatiPozorista > 0){
		trenutnaStranaRezultatiPozorista--;
		stranica = trenutnaStranaRezultatiPozorista;
	}
	else if(page == 'sledeca' && trenutnaStranaRezultatiPozorista < ukupanBrojStranaPozorista){
		trenutnaStranaRezultatiPozorista++;
		stranica = trenutnaStranaRezultatiPozorista;
	}
	else if(page !='prethodna' && page != 'sledeca'){
		var stranicaNaKojuIdemo = parseInt(page) - 1;
		if(stranicaNaKojuIdemo < 0){
			stranicaNaKojuIdemo = 0;
		}
		stranica = stranicaNaKojuIdemo.toString();
	}
	else{
		stranica = 0;
	}
	var pozoristeIme = $('#nazPoPo').text();
	pozoristeIme = pozoristeIme.split(" ").join("%20");
	
	var i;
	for (i = 1; i < 5; i++) { 
		$('#rep'+i).show();
	}
	
	$.get('http://localhost:8080/'+pozoristeIme+'/predstave/'+stranica, function (data) {
		var response = data;
		var numOfElems = response.numberOfElements;
		if(numOfElems < 4){
			var numOfElemsCounter = 1;
			while(numOfElemsCounter <= 4){
				if(numOfElemsCounter > numOfElems){
					$('#rep'+numOfElemsCounter).hide();
				}
				numOfElemsCounter++;
			}
		}
		var counter = 1;
		var contentCounter = 0;
		while(counter <= numOfElems){
			$("#rep"+counter+"-h").text(response.content[contentCounter].naizv);
			$("#rep"+counter+"-zanr").text(response.content[contentCounter].zanr);
			$("#rep"+counter+"-reditelj").text(response.content[contentCounter].imeReditelja);
			$("#rep"+counter+"-trajanje").text(response.content[contentCounter].trajanje);
			var glumci = response.content[contentCounter].spisakGlumaca;
			var glumciText="";
			glumci.forEach(function(element) {
				  glumciText = glumciText+element+" ";
				});
			$("#rep"+counter+"-glumci").text(glumciText);
			$("#rep"+counter+"-opis").text(response.content[contentCounter].opis);
			var ocene = response.content[contentCounter].ocene;
			var oceneSuma=0;
			ocene.forEach(function(element) {
				oceneSuma = oceneSuma+element;
				});
			oceneSuma = oceneSuma/ocene.length;
			oceneSuma = Math.round(oceneSuma * 100) / 100;
			$("#rep"+counter+"-ocena").text(oceneSuma);
			$("#rep"+counter+"-cena").text(response.content[contentCounter].cena);
			$("#rep"+counter+"-img").attr('src', response.content[contentCounter].slika);
			counter++;
			contentCounter++;
		}
	})
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

function povratakNaPrethodnuRepertoar(){
	if(prethodnaStranica == "bioskopi"){
		$("#repertoarPrikaz").toggle();
		$("#bioskopi_prikaz").toggle();
		$("#map").toggle();
	}
}

function povratakNaPrethodnuRepertoarPozorista(){
	if(prethodnaStranicaPozorista == "pozorista"){
		$("#repertoarPrikaz").toggle();
		$("#pozorista_prikaz").toggle();
		$("#map").toggle();
	}
}

function prikazLoginStranice(){
	$("#pocetna").hide();
	$("#login").load("login.html");
	$("#login").show();
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

function ucitajAdminPozBio(){
	$("#pocetna").hide();
	$("#adminPB").load("pozoristeBioskopAdmin.html");
	$("#adminPB").show();
	
}