$(document).ready(function () {

    $("#registerForm").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_submit();

    });

});

function fire_submit() {

    var search = {}
    search["ime"] = $("#ime").val();
    search["prezime"] = $("#prezime").val();
    search["email"] = $("#registrujusername").val();
    search["lozinka"] = $("#registrujpassword").val();

    $("#registruj").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/registracija/provjeri",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        statusCode: {
            400: function() {
              alert("Niste unijeli podatke");
            }
          },
        success: function (data) {
        	
        	var json = "<h4>Ajax Response</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
        	if(data.msg=="success"){
        		
        		console.log("SUCCESS : ", data);
                $("#registruj").prop("disabled", false);
        		
        	}
        	else{
            
           

            console.log("ERROR : ", data);
            $("#registruj").prop("disabled", false)};

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
           

            console.log("ERROR : ", e);
            $("#registruj").prop("disabled", false);

        }
    });
}