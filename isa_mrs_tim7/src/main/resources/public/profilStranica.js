var im;
var pre;
var em;
var id;
var loz;
var emails=[];
var imenaPrezimena=[];
var prijatelj={}; 
var nova;





$(window).load(function() {
	
	
	
	
	$.get('http://localhost:8080/korisnici', function (data) {
		for(var i in data.content){
			console.log(data.content[i].email);
			emails.push(data.content[i].email);
			var spoji=data.content[i].ime+" "+data.content[i].prezime;
			imenaPrezimena.push(spoji);
			
			
		}
		prikaziProfilnu();
		
	
      });
	
	
	
    
      
});




$("#prikaziZah").on("click", function() {
	prikaziZahteve();
	});

$("#dobavi").on("click", function() {
	dobaviPoz();
	});




$('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
	
		
		
		
	prikaziProfilnu();
	
		
	});
	
	


function fokusiraj(){
	
	
	let options='';
	if($('#selected').text()=="Email"){
		
		emails.forEach( imena => {
			options += `<option value="${imena}">`
			})
			let datalist = document.querySelector('#lista-imena');
			datalist.innerHTML = options;
	}
	else{
		imenaPrezimena.forEach( imena => {
			options += `<option value="${imena}">`
			})
			let datalist = document.querySelector('#lista-imena');
			datalist.innerHTML = options;
		
		
		
	}
	options='';
	
}

function prikaziProfilnu() {
	
	$.get('http://localhost:8080/login/ulogovani', function (data) {
		document.getElementById("ime").innerHTML=data.ime+" "+data.prezime;
		document.getElementById("email").innerHTML=data.email;
		im=data.ime;
		pre=data.prezime;
		em=data.email;
		loz=data.lozinka;
		id=data.id;
		
	    nova=data.email;
		$("#promenaIme").val(im);
        $("#promenaPrezime").val(pre);
        $("#promenaLozinka").val(loz);
		
		
		
		
		
	});
	
	
	
	
	
}
$('.dropdown-menu a').click(function(){
    $('#selected').text($(this).text());
  });
function pretraga(){
	//alert($( "#selected" ).text());
	var countRow = 0;
	var table = document.getElementById("tabela");
	$("#tabela").empty();
	var row = table.insertRow(countRow);
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	var cell4 = row.insertCell(3);
	if($('#selected').text()=="Email"){
		countRow = 0;
		$.get('http://localhost:8080/korisnici', function (data) {
			
			

			
		
			for(var i in data.content){
				if(data.content[i].email==$('input[name=imena]').val()){
					
					cell1.innerHTML = countRow+1;
					cell2.innerHTML = data.content[i].ime+" "+data.content[i].prezime;
					cell3.innerHTML = data.content[i].email;
					prijatelj['poslao']=em;
					prijatelj['prihvatio']=data.content[i].email;
					cell4.innerHTML = '<button class="btn btn-primary" onclick="dodajPrijateljaEm()">Dodaj</button>';
					countRow++;
					
				}}
			countRow = 0;
			
		});
				
		
		
		
		
		
	}
	else{
		
		
		countRow = 0;
		$.get('http://localhost:8080/korisnici', function (data) {	
			
		
		
		
		for(var i in data.content){
			var imePre=data.content[i].ime+" "+data.content[i].prezime;
			if(imePre==$('input[name=imena]').val()){
				
				cell1.innerHTML = countRow+1;
				cell2.innerHTML = data.content[i].ime+" "+data.content[i].prezime;
				cell3.innerHTML = data.content[i].email;
				prijatelj['poslao']=em;
				prijatelj['prihvatio']=data.content[i].email;
				cell4.innerHTML = '<button class="btn btn-primary" onclick="dodajPrijateljaEm()">Dodaj</button>';
				countRow++;
				
			}}
		countRow = 0;
		
		
		
	});
		}
	
	
	
	
	
}

function promeniPodatke(){
	var search = {}
	search["id"]=id;
    search["ime"] =im;
	search["prezime"] =pre;
    search["lozinka"] =loz;
    search["email"]=em;
   
    if ($("#promenaIme").val()!=""){
    	search["ime"]=$("#promenaIme").val();
    	
    }
    if ($("#promenaPrezime").val()!=""){
    	search["prezime"]=$("#promenaPrezime").val();
    	
    }
    if ($("#promenaLozinka").val()!=""){
    	search["lozinka"]=$("#promenaLozinka").val();
    	
    }
    console.log(search["id"] );

    $("#submit").prop("disabled", true);
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "http://localhost:8080/login/ulogovani",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
        	
        	alert("Uspesno ste izmenili podatke")
        	$("#submit").prop("disabled", false);
            
        
        

        },
        error: function (e) {

            
           

            console.log("ERROR : ", e);
            $("#submit").prop("disabled", false);

        }
    });
	
	
	
}


function dodajPrijateljaEm(){
	
	var emailP = $(event.target).parent().siblings().first().next().next().text();
	
	search={};
	search['poslao']=em;
	search['prihvatio']=emailP;
	search['opcija']='1';
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "http://localhost:8080/kreiranjePrijatelja",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        statusCode: {
            400: function() {
              alert("Korisnika ste vec dodali");
             
            }
          },
          statusCode: {
              201: function() {
                alert("Korisnik uspesno dodat.");
               
              }
            },
        success: function (data) {
        	
        	alert("Uspesno ste dodali prijatelja")
        	
        
        

        },
        error: function (e) {

            
           

            console.log("ERROR : ", e);
            

        }
    });
	
	
	
	
}


function prikaziZahteve(){
	
	
	var countRow = 0;
	alert(nova);
	search={}
	search['poslao']=nova;
	$.ajax({
        type: "POST",
        contentType: "application/json",
        url: "http://localhost:8080/primljeniZahtevi",
        data:JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
        	
        	
        	var table = document.getElementById("tabela1");

			var row = table.insertRow(countRow);
			var cell1 = row.insertCell(0);
			var cell2 = row.insertCell(1);
			var cell3 = row.insertCell(2);
			var cell4 = row.insertCell(3);
			for(var i in data){
				
				
				cell1.innerHTML = countRow+1;
				cell2.innerHTML = data[i].poslao;
				
				cell3.innerHTML ='<button class="btn btn-primary" onclick="prihvatiPrijatelja()">Prihvati</button>';
				cell4.innerHTML ='<button class="btn btn-primary" onclick="odbijPrijatelja()">Odbij</button>';
				countRow++;
				
				
			}
        	
            
			countRow = 0;
        

        },
        error: function (e) {

            
           

            console.log("ERROR : ", e);
            

        }
    });
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

function prihvatiPrijatelja(){
var emailP = $(event.target).parent().siblings().first().next().text();
    
	search={};
	search['poslao']=emailP;
	search['prihvatio']=em;
	search['opcija']='2';
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "http://localhost:8080/updatePrijatelja",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        statusCode: {
            400: function() {
              alert("Greska");
             
            }
          },
          statusCode: {
              200: function() {
                alert("Uspesno ste prihvatili zahtev.");
               
              }
            },
        success: function (data) {
        	
        	alert("Uspesno ste prihvatili zahtev.");
        	
        
        

        },
        error: function (e) {

            
           

            console.log("ERROR : ", e);
            

        }
    });
	
	
	
	
	
	
}


function odbijPrijatelja(){
var emailP = $(event.target).parent().siblings().first().next().text();

	search={};
	search['poslao']=emailP;
	search['prihvatio']=em;
	search['opcija']='1';
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "http://localhost:8080/obrisiPrijatelja",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        statusCode: {
            400: function() {
              alert("Greska");
             
            }
          },
          statusCode: {
              200: function() {
                alert("Uspesno ste obrisali zahtev.");
               
              }
            },
        success: function (data) {
        	
        	alert("Uspesno ste obrisali zahtev.");
        	
        
        

        },
        error: function (e) {

            
           

            console.log("ERROR : ", e);
            

        }
    });
	
	
	
	
}

