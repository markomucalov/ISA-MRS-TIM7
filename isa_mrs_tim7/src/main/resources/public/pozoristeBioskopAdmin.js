var error_broj = false;
var error_zip = false;



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

function check_form(nazivBioskopa) {
											
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