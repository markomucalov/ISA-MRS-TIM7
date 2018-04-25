function dobaviPozorista() {
    /*var xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/pozorista", true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();
    var resp = xhttp.responseText;
    var response = JSON.parse(xhttp.responseText);*/
	$.getJSON('http://localhost:8080/pozorista', function (data) {
		var response = data;
		var urlConcat = "";
	    for (var counter in response.content) {
	        urlConcat = urlConcat+response.content[counter].naziv+",";
			urlConcat = urlConcat+response.content[counter].rejting+",";
	        var adresaTemp = response.content[counter].adresa;
	        urlConcat = urlConcat+adresaTemp.ulica+",";
	        urlConcat = urlConcat+adresaTemp.broj+",";
	        urlConcat = urlConcat+adresaTemp.grad+",";
	        urlConcat = urlConcat+adresaTemp.zip+";";
	    }
	    window.location.href='/pozorista.html'+'#'+urlConcat;
})
    
}

function parsirajPozorista(){
	var trenutniUrl = window.location.href;
	trenutniUrl = trenutniUrl.split("#")[1];
	var pozorista = trenutniUrl.split(';');
	var brojac = 0;
	
	for(var poz in pozorista){
		brojac++;
		var delovi = pozorista[poz].split(',');
		var naziv = delovi[0];
		var rejting = delovi[1];
		var ulica = delovi[2];
		var broj = delovi[3];
		var grad = delovi[4];
		var zip = delovi[5];
		//$('#tabela').after('<tr><td>'+document.write(naziv)+'</td>'+'<td>'+document.write(rejting)+'</td>'+'<td>'+document.write(ulica)+' '+document.write(broj)+' '+document.write(zip)+' '+document.write(grad)+'</td></tr>');
		var table = document.getElementById("tabela");
		var row = table.insertRow(brojac-1);
		var cell1 = row.insertCell(0);
		var cell2 = row.insertCell(1);
		var cell3 = row.insertCell(2);
		var cell4 = row.insertCell(3);
		var cell5 = row.insertCell(4);
		cell1.innerHTML = brojac;
		cell2.innerHTML = naziv;
		cell3.innerHTML = ulica+" "+broj+" "+zip+" "+grad;
		cell4.innerHTML = "udaljenost";
		cell5.innerHTML = "repertoar";
	}
}