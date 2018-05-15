var error_broj = false;
var error_zip = false;

var error_ime = false;
var error_prezime = false;
var error_email = false;
var error_korIme = false;
var error_lozinka = false;
var error_potvrdaLozinke = false;



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
		izmeniPodatkeAdminaPB(korIme);
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

function izmeniPodatkeAdminaPB(korIme){
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
	    url: 'http://localhost:8080/'+korIme+'/izmenaPodatakaAdminaPB',
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
	
	$.get('http://localhost:8080/'+korImeAdmina+'/bioskopPozoristeAdmin', function (data) {
		var response = data;
		$("#ime").val(response.ime);
		$("#prezime").val(response.prezime);
		$("#korisnickoIme").val(response.korisnickoIme);
		$("#eMailAdresa").val(response.mailAdresa);
		$("#lozinka").val(response.lozinka);
		$("#potvrdaLozinke").val(response.lozinka);
		nazivBioskopa = response.bioskop.naziv;
		postaviPodatkeNaFormu(nazivBioskopa);
	})
}

/*function proveriDaLiMenjaLozinku(){
	if($("#omoguciPromenuLozinke").checked == true){
		
	}
	else{
		
	}
}*/