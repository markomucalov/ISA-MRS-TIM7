$(document).ready(function () {




    $("#customerForm").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

});
//var emailSad;
function fire_ajax_submit() {

    var search = {}
    search["email"] = $("#loginusername").val();
    search["lozinka"] = $("#loginpassword").val();
    console.log( $("#loginusername").val());

    $("#login").prop("disabled", true);
    
    

    $.ajax({
    	data: JSON.stringify(search),
        dataType: 'json',
        url: 'http://localhost:8080/login/provjeri',
        type: 'POST',
        contentType: 'application/json',
        statusCode: {
            400: function() {
              alert("Niste uneli podatke");
              $("#login").prop("disabled", false);
              $("#loginusername").val("");
              $("#loginpassword").val("");
            }
          },
          statusCode: {
              500: function() {
                alert("Pogresno ste uneli email ili lozinku");
                $("#login").prop("disabled", false);
                $("#loginusername").val("");
                $("#loginpassword").val("");
              }
            },
        success: function (data) {
        	
        	var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
        	
        		
        		console.log("SUCCESS : ", data.email);
                $("#login").prop("disabled", false);
                
                //emailSad=data.result[0].email;
                window.location = "http://localhost:8080/profilStranica.html";
                
                    
                	
                	
                	
        	},
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
           
           /* alert("Niste uneli dobar email ili korisničko ime!")
            //console.log("ERROR : ", e);
            $("#login").prop("disabled", false);
            $("#loginusername").val("");
            $("#loginpassword").val("");*/

        }
    });
}
