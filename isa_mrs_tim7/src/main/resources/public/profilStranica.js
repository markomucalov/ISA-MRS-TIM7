$(window).load(function() {
      prikaziProfilnu();
});
function prikaziProfilnu() {
	
	$.get('http://localhost:8080/login/ulogovani', function (data) {
		document.getElementById("ime").innerHTML=data.ime+" "+data.prezime;
		document.getElementById("email").innerHTML=data.email;
		
		
		
		
	});
	
	
	
	
}