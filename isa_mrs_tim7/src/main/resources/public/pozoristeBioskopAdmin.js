var error_broj = false;
var error_zip = false;

var error_ime = false;
var error_prezime = false;
var error_email = false;
var error_korIme = false;
var error_lozinka = false;
var error_potvrdaLozinke = false;

var korisIme = "";

var ulogovaniAdmin = "";


function check_broj() {
		
	var pattern = new RegExp(/^\d+[a-z0-9]{0,1}$/);
	
	if(pattern.test($("#broj").val()) || $("#broj").val()=="bb") {
		$(".error_broj_ulice").text("");
	} else {
		$(".error_broj_ulice").text("broj moze biti oblika 11|11a|bb");
		error_broj = true;
	}
	
}

function check_zip() {
	
	var pattern = new RegExp(/^\d+$/);
		
	if(pattern.test($("#zip").val())) {
		$(".error_zip_grada").text("");
	} else {
		$(".error_zip_grada").text("zip mora biti broj");
		error_zip = true;
	}
	
}

function check_form_adminPB() {
	
	
	var korIme = $("#korisnickoIme").val();
											
	error_ime = false;
	error_prezime = false;
	error_email = false;
	error_korIme = false;
	error_lozinka = false;
	error_potvrdaLozinke = false;
											
	check_email();
	check_ime_prezime();
	check_if_empty_korIme();
	check_lozinka_change();
		
	if(error_ime == false && error_prezime == false && error_email == false && error_korIme == false && error_lozinka == false && error_potvrdaLozinke == false) {
		izmeniPodatkeAdminaPB(korisIme);
		return true;
	} else {
		return false;	
	}
}

function check_form() {
	
	var nazivBioskopa = $("#naziv").val();
											
	error_broj = false;
	error_zip = false;
	
	check_broj();
	check_zip();
		
	if(error_broj == false && error_zip == false) {
		izmeniPodatke(nazivBioskopa);
		return true;
	} else {
		return false;	
	}
}

function postaviPodatkeNaFormu(nazivBioskopa){
	$.get('http://localhost:8080/'+nazivBioskopa+'/bioskop', function (data) {
		var response = data;
		$("#naziv").val(response.naziv);
		$("#ulica").val(response.adresa.ulica);
		$("#broj").val(response.adresa.broj);
		$("#grad").val(response.adresa.grad);
		$("#zip").val(response.adresa.zip);
		$("#opis").val(response.promotivniOpis);	
	})
}

function izmeniPodatke(nazivBioskopa){
	var naziv = $("#naziv").val();
	var ulica = $("#ulica").val();
	var broj = $("#broj").val();
	var grad = $("#grad").val();
	var zip = $("#zip").val();
	var opis = $("#opis").val();
	var bioskopDTO={
		    "naziv": naziv,
		    "adresa": {
		        "ulica": ulica,
		        "broj": broj,
		        "grad": grad,
		        "zip": zip
		    },
		    "promotivniOpis": opis 
		}
	$.ajax({
	    url: 'http://localhost:8080/'+nazivBioskopa+'/izmenaPodataka',
	    type: 'POST',
	    /*data: JSON.stringify({ BioskopDTO: bioskopDTO }),*/
	    data: JSON.stringify(bioskopDTO),
	    contentType: "application/json; charset=utf-8",
	    dataType: "json",
	    success: function(data) {
	        alert('uspesno ste izmenili podatke');
	    }
	});
}

function izmeniPodatkeAdminaPB(korisnickoIme){
	var ime = $("#ime").val();
	var prezime = $("#prezime").val();
	var korIme = $("#korisnickoIme").val();
	var lozinka = $("#lozinka").val();
	var email = $("#eMailAdresa").val();
	var adminDTO={
			"ime": ime,
		    "prezime": prezime,
		    "mailAdresa": email,
		    "korisnickoIme": korIme,
		    "lozinka": lozinka 
		}
	$.ajax({
	    url: 'http://localhost:8080/'+korisnickoIme+'/izmenaPodatakaAdminaPB',
	    type: 'POST',
	    /*data: JSON.stringify({ BioskopDTO: bioskopDTO }),*/
	    data: JSON.stringify(adminDTO),
	    contentType: "application/json; charset=utf-8",
	    dataType: "json",
	    success: function(data) {
	        alert('uspesno ste izmenili podatke administratora');
	    }
	});
}

function omoguciPromLoz(){
	if($("#omoguciPromenuLozinke").prop('checked') == true){
		$("#lozinka").prop('disabled', false);
		$("#potvrdaLozinke").prop('disabled', false);
	}
	else{
		$("#lozinka").prop('disabled', true);
		$("#potvrdaLozinke").prop('disabled', true);
		$(".error_lozinke").text("");
		$(".error_potvrdeLozinke").text("");
	}
}

function check_email() {
	
	var pattern = new RegExp(/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/);
		
	if(pattern.test($("#eMailAdresa").val())) {
		$(".error_emaila").text("");
	} else {
		$(".error_emaila").text("email mora biti oblika: nesto@nesto.domen");
		error_email = true;
	}
	
}

function check_ime_prezime(){
	
	var pattern = new RegExp(/^[a-zA-Z]+$/);
	
	if(pattern.test($("#ime").val())) {
		$(".error_imena").text("");
	} else {
		$(".error_imena").text("ime moze sadrzati samo slova");
		error_ime = true;
	}
	
	if(pattern.test($("#prezime").val())) {
		$(".error_prezimena").text("");
	} else {
		$(".error_prezimena").text("prezime moze sadrzati samo slova");
		error_prezime = true;
	}
}

function check_if_empty_korIme(){
	var korIme = $("#korisnickoIme").val();
	if($("#korisnickoIme").val() == ""){
		$(".error_korImena").text("korisnicko ime ne sme biti prazno");
		error_korIme = true;
	}
	else{
		$(".error_korImena").text("");
	}
}

function check_lozinka_change(){
	if($("#omoguciPromenuLozinke").prop('checked') == true){
		if($("#lozinka").val() == ""){
			$(".error_lozinke").text("lozinka ne sme biti prazna");
			error_lozinka = true;
		}
		else{
			$(".error_lozinke").text("");
		}
		
		if($("#potvrdaLozinke").val() != $("#lozinka").val()){
			$(".error_potvrdeLozinke").text("mora biti uneta ista lozinka");
			error_potvrdaLozinke;
		}
		else{
			$(".error_potvrdeLozinke").text("");
		}
	}
}

function postaviPodatkeAdminaNaFormu(korImeAdmina){
	
	var nazivBioskopa;
	
	ulogovaniAdmin = korImeAdmina;
	
	$.get('http://localhost:8080/'+korImeAdmina+'/bioskopPozoristeAdmin', function (data) {
		var response = data;
		$("#ime").val(response.ime);
		$("#prezime").val(response.prezime);
		$("#korisnickoIme").val(response.korisnickoIme);
		$("#eMailAdresa").val(response.mailAdresa);
		$("#lozinka").val(response.lozinka);
		$("#potvrdaLozinke").val(response.lozinka);
		korisIme = response.korisnickoIme;
		nazivBioskopa = response.bioskop.naziv;
		postaviPodatkeNaFormu(nazivBioskopa);
		ucitajRepertoarBioskopa(nazivBioskopa);
		ucitajSale(korImeAdmina);
	})
}

/* funkcije za repertoar*/

function ucitajRepertoarBioskopa(nazivBioskopa){
	$.get('http://localhost:8080/'+nazivBioskopa+'/allFilmovi', function (data) {
		var response = data;
		var tabela = document.getElementById("tabela_filmovi_sadrzaj");
		$("#tabela_filmovi").find("tr:not(:first)").remove();;
		
		for(var counter in response){
			var row = tabela.insertRow(counter);
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			var cell5 = row.insertCell(4);
			var cell6 = row.insertCell(5);
			
			cell1.innerHTML = response[counter].naizv;
			cell2.innerHTML = response[counter].zanr;
			cell3.innerHTML = response[counter].imeReditelja;
			cell4.innerHTML = response[counter].trajanje;
			cell5.innerHTML = '<button class="btn btn-primary" onclick="prikaziDetaljeFilma()">Detalji/Izmeni</button>';
			cell6.innerHTML = '<button class="btn btn-primary" onclick="obrisiFilm()">Obrisi</button>';
		}
	})
}

function dodajFilmUTabelu(response){
	var tabela = document.getElementById("tabela_filmovi_sadrzaj");
	var row = tabela.insertRow(-1);
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	var cell4 = row.insertCell(3);
	var cell5 = row.insertCell(4);
	var cell6 = row.insertCell(5);
	
	cell1.innerHTML = response.naizv;
	cell2.innerHTML = response.zanr;
	cell3.innerHTML = response.imeReditelja;
	cell4.innerHTML = response.trajanje;
	cell5.innerHTML = '<button class="btn btn-primary" onclick="prikaziDetaljeFilma()">Detalji/Izmeni</button>';
	cell6.innerHTML = '<button class="btn btn-primary" onclick="obrisiFilm()">Obrisi</button>';
}

function prikaziDetaljeFilma(){
	/*TODO*/
}

function obrisiFilm(){
	var nazivBioskopa = $("#naziv").val();
	var nazivFilma = $(event.target).parent().siblings().first().text();
	$(event.target).parent().parent().remove();
	
	$.ajax({
	    url: 'http://localhost:8080/'+nazivBioskopa+'/'+nazivFilma+'/obrisiFilm',
	    type: 'POST',
	    /*data: JSON.stringify({ BioskopDTO: bioskopDTO }),*/
	    contentType: "application/json; charset=utf-8",
	    dataType: "json",
	    success: function() {
	        alert('uspesno ste izbrisali film');
	    }
	});
}

function dodajNoviFilm(nazivBioskopa){
	var naziv = $("#nazivFiPr").val();
	var zanr = $("#zanrFiPr").val();
	var reditelj = $("#rediteljFiPr").val();
	var trajanje = $("#trajanjeFiPr").val();
	var cena = $("#cenaFiPr").val();
	var opis = $("#opisFiPr").val();
	var filmDTO={
			"naizv": naziv,
		    "spisakGlumaca": [],
		    "zanr": zanr,
		    "imeReditelja": reditelj,
		    "trajanje": trajanje,
		    "opis" : opis,
		    "cena" : cena
		}
	var counterGlumci = 0;
	$("#lista_glumaca li").each(function(){
		filmDTO.spisakGlumaca[counterGlumci] = $(this).text();
		counterGlumci ++;
	 });
	$("#DodavanjeRepertoara").submit(function (evt) {
		   evt.preventDefault(); //prevents the default action

	});
	$.ajax({
	    url: 'http://localhost:8080/'+nazivBioskopa+'/dodajFilm',
	    type: 'POST',
	    /*data: JSON.stringify({ BioskopDTO: bioskopDTO }),*/
	    data: JSON.stringify(filmDTO),
	    contentType: "application/json; charset=utf-8",
	    dataType: "json",
	    success: function(data) {
	    	var response = data;
	        dodajFilmUTabelu(response);
	    }
	});
}

function dodavanjeGlumaca(){
	var newitem = $('#glumac_polje').val();
	var uniqid = Math.round(new Date().getTime() + (Math.random() * 100));
	$('#lista_glumaca').append('<li id="'+uniqid+'" class="list-group-item"><input type="button" data-id="'+uniqid+'" class="listelement" value="X" onClick="ukloniGlumca()" /> '+newitem+'<input type="hidden" name="listed[]" value="'+newitem+'"></li>');
	$('#glumac_polje').val('');
}

function ukloniGlumca(){
	$('#lista_glumaca').delegate(".listelement", "click", function() {
		var elemid = $(this).attr('data-id');
		$("#"+elemid).remove();
    });
}

var error_nazivFiPr = false;
var error_zanrFiPr = false;
var error_rediteljFiPr = false;
var error_trajanjeFiPr = false;
var error_cenaFiPr = false;

function check_if_empty_naziv(){
	var korIme = $("#nazivFiPr").val();
	if($("#nazivFiPr").val() == ""){
		$(".error_nazivaFiPr").text("Naziv ne sme biti prazan");
		error_nazivFiPr = true;
	}
	else{
		$(".error_nazivaFiPr").text("");
	}
}

function check_if_empty_zanr(){
	var korIme = $("#zanrFiPr").val();
	if($("#zanrFiPr").val() == ""){
		$(".error_zanraFiPr").text("Zanr ne sme biti prazan");
		error_zanrFiPr = true;
	}
	else{
		$(".error_zanraFiPr").text("");
	}
}

function check_if_empty_reditelj(){
	var korIme = $("#rediteljFiPr").val();
	if($("#rediteljFiPr").val() == ""){
		$(".error_rediteljaFiPr").text("Reditelj ne sme biti prazan");
		error_rediteljFiPr = true;
	}
	else{
		$(".error_rediteljaFiPr").text("");
	}
}

function check_trajanje() {
	
	var pattern = new RegExp(/^([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$/);
		
	if(pattern.test($("#trajanjeFiPr").val())) {
		$(".error_trajanja").text("");
	} else {
		$(".error_trajanja").text("trajanje mora biti oblika: cc:mm:ss");
		error_trajanjeFiPr = true;
	}
	
}

function check_cena() {
	
	var pattern = new RegExp(/^\d+$/);
		
	if(pattern.test($("#cenaFiPr").val())) {
		$(".error_cene").text("");
	} else {
		$(".error_cene").text("Cena mora biti broj");
		error_cenaFiPr = true;
	}
	
}

function check_form_dodaj_film() {
	
	var nazivBioskopa = $("#naziv").val();
											
	error_nazivFiPr = false;
	error_zanrFiPr = false;
	error_rediteljFiPr = false;
	error_trajanjeFiPr = false;
	error_cenaFiPr = false;
	
	check_if_empty_naziv();
	check_if_empty_zanr();
	check_if_empty_reditelj();
	check_trajanje();
	check_cena();
		
	if(error_nazivFiPr == false && error_zanrFiPr == false && error_rediteljFiPr == false && error_trajanjeFiPr == false && error_cenaFiPr == false) {
		dodajNoviFilm(nazivBioskopa);
		$("#nazivFiPr").val("");
		$("#zanrFiPr").val("");
		$("#rediteljFiPr").val("");
		$("#trajanjeFiPr").val("");
		$("#cenaFiPr").val("");
		$("#opisFiPr").val("");
		$("#lista_glumaca").empty();
		return true;
	} else {
		return false;	
	}
}

function ucitajRepertoarPozorista(){
	/*TODO*/
}

/*funkcije za rad sa SALAMA*/

function dodajSalu(){
	var nazivSale = $("#nazivSale").val();
	if(nazivSale == ""){
		$(".error_nazivaSale").text("naziv sale ne sme biti prazan");
		return;
	}
	else{
		$(".error_nazivaSale").text("");
	}
	$.ajax({
		  type: 'POST',
		  url: 'http://localhost:8080/'+nazivSale+'/'+ulogovaniAdmin+'/dodajSalu',
		  statusCode: {
		    409: function() {
		      alert('Sala sa tim nazivom vec postoji.');
		    }
		  },
		  success: function(result) {
			  alert('Uspesno ste dodali salu.');
			  $("#selektovanjeSala").append($("<option></option>").attr("value",nazivSale).text(nazivSale));
		    return;
		  },
		  error: function(result) {
		    // error response - look at 'result' object
		    return;
		  }
		});
}

function ucitajSale(korImeAdmina){
	$.get('http://localhost:8080/'+korImeAdmina+'/allSale', function (data) {
		var response = data;
		$("#selektovanjeSala").children().remove();
		$("#selektovanjeSala").append($("<option></option>").attr("value","").text(""));
		for(var i in response.sale){
			$("#selektovanjeSala").append($("<option></option>").attr("value",response.sale[i]).text(response.sale[i]));
		}
		for(var i = 1; i<= 10; i++){
			for(var j = 1; j<=12; j++){
				$("#rec"+i+j).hide();
			}
		}
	})
}

function ucitajKonfiguracijuSale(){

    var selektovanaSala = $('#selektovanjeSala').find(":selected").text();
    if( selektovanaSala != ""){
    	$.get('http://localhost:8080/'+ulogovaniAdmin+'/'+selektovanaSala+'/konfiguracijaSale', function (data) {		
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
    						else if($('#opcijaBrza').is(':checked')) {
    							$("#"+idSedista).css({ fill: "#33cc33", stroke: "#000000" });
    							$("#"+idSedista).attr("name", "brza"); 
    						}
    						else if($('#opcijaVip').is(':checked')) {
    							$("#"+idSedista).css({ fill: "#ff9900", stroke: "#000000" });
    							$("#"+idSedista).attr("name", "vip");
    						}
    						else if($('#opcijaProlaz').is(':checked')) {
    							$("#"+idSedista).css({ fill: "#ffffff", stroke: "#ffffff" });
    							$("#"+idSedista).attr("name", "prolaz"); 
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
    						else if($('#opcijaBrza').is(':checked')) {
    							$("#"+idSedista).css({ fill: "#33cc33", stroke: "#000000" });
    							$("#"+idSedista).attr("name", "brza"); 
    						}
    						else if($('#opcijaVip').is(':checked')) {
    							$("#"+idSedista).css({ fill: "#ff9900", stroke: "#000000" });
    							$("#"+idSedista).attr("name", "vip");
    						}
    						else if($('#opcijaProlaz').is(':checked')) {
    							$("#"+idSedista).css({ fill: "#ffffff", stroke: "#ffffff" });
    							$("#"+idSedista).attr("name", "prolaz"); 
    						}
    			        })
    					$("#rec"+i+j).show();
    				}
    				else if(response[trenutni].tipSedista == "ZA_BRZU_REZERVACIJU" && response[trenutni].red == i && response[trenutni].kolona == j){
    					$("#rec"+i+j).css({ fill: "#33cc33", stroke: "#000000" });
    					$("#rec"+i+j).attr("name", "brza");
    					/*$("#rec"+i+j).attr("onclick", "promenaKonfiguracije()");*/
    					$("#rec"+i+j).on('click', function(d,i) {
    						var idSedista = this.id;
    						if($('#opcijaObicno').is(':checked')) {
    							$("#"+idSedista).css({ fill: "#ffffff", stroke: "#000000" });
    							$("#"+idSedista).attr("name", "obicno"); 
    						}
    						else if($('#opcijaBrza').is(':checked')) {
    							$("#"+idSedista).css({ fill: "#33cc33", stroke: "#000000" });
    							$("#"+idSedista).attr("name", "brza"); 
    						}
    						else if($('#opcijaVip').is(':checked')) {
    							$("#"+idSedista).css({ fill: "#ff9900", stroke: "#000000" });
    							$("#"+idSedista).attr("name", "vip");
    						}
    						else if($('#opcijaProlaz').is(':checked')) {
    							$("#"+idSedista).css({ fill: "#ffffff", stroke: "#ffffff" });
    							$("#"+idSedista).attr("name", "prolaz"); 
    						}
    			        })
    					$("#rec"+i+j).show();
    				}
    				else if(response[trenutni].tipSedista == "PROLAZ" && response[trenutni].red == i && response[trenutni].kolona == j){
    					$("#rec"+i+j).css({ fill: "#ffffff", stroke: "#ffffff" });
    					$("#rec"+i+j).attr("name", "prolaz");
    					/*$("#rec"+i+j).attr("onclick", "promenaKonfiguracije()");*/
    					$("#rec"+i+j).on('click', function(d,i) {
    						var idSedista = this.id;
    						if($('#opcijaObicno').is(':checked')) {
    							$("#"+idSedista).css({ fill: "#ffffff", stroke: "#000000" });
    							$("#"+idSedista).attr("name", "obicno"); 
    						}
    						else if($('#opcijaBrza').is(':checked')) {
    							$("#"+idSedista).css({ fill: "#33cc33", stroke: "#000000" });
    							$("#"+idSedista).attr("name", "brza"); 
    						}
    						else if($('#opcijaVip').is(':checked')) {
    							$("#"+idSedista).css({ fill: "#ff9900", stroke: "#000000" });
    							$("#"+idSedista).attr("name", "vip");
    						}
    						else if($('#opcijaProlaz').is(':checked')) {
    							$("#"+idSedista).css({ fill: "#ffffff", stroke: "#ffffff" });
    							$("#"+idSedista).attr("name", "prolaz"); 
    						}
    			        })
    					$("#rec"+i+j).show();
    				}
    				
    				trenutni++;
    			}
    		}
    	})
    }
    else{
    	for(var i = 1; i<= 10; i++){
			for(var j = 1; j<=12; j++){
				$("#rec"+i+j).hide();
			}
		}
    }
	
}

/*function promenaKonfiguracije(){
	var idSedista = $("rect").attr("id");
	if($('#opcijaObicno').is(':checked')) {
		$("#"+idSedista).css({ fill: "#ffffff", stroke: "#000000" });
		$("#"+idSedista).attr("name", "obicno"); 
	}
	else if($('#opcijaBrza').is(':checked')) {
		$("#"+idSedista).css({ fill: "#33cc33", stroke: "#000000" });
		$("#"+idSedista).attr("name", "brza"); 
	}
	else if($('#opcijaVip').is(':checked')) {
		$("#"+idSedista).css({ fill: "#ff9900", stroke: "#000000" });
		$("#"+idSedista).attr("name", "vip");
	}
	else if($('#opcijaProlaz').is(':checked')) {
		$("#"+idSedista).css({ fill: "#ffffff", stroke: "#ffffff" });
		$("#"+idSedista).attr("name", "prolaz"); 
	}
}*/

function sacuvajKonfiguraciju(){
	
	var selektovanaSala = $('#selektovanjeSala').find(":selected").text();
	
	var konfiguracijaDTO={
			"korisnickoIme": ulogovaniAdmin,
		    "sedista": [],
		    "sala": selektovanaSala
		}
	var brojac = 0;
	
	for(var i = 1; i<= 10; i++){
		for(var j = 1; j<=12; j++){
			var sediste={
					"red": i,
					"kolona": j,
					"tip": $("#rec"+i+j).attr("name")
			}
			konfiguracijaDTO.sedista[brojac] = sediste;
			brojac++;			
		}
	}
	
	$.ajax({
	    url: 'http://localhost:8080/'+ulogovaniAdmin+'/'+selektovanaSala+'/izmeniKonfiguraciju',
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