$("#btnEntrar").click(function(){

    console.log("SE HA PULSADO EL BOTON");
        $("#mensajeError").remove();

        $.ajax({
            method: "POST",
            url: "./../tienda",
            data: {email: $("#email").val(), contrasenha: $("#contrasenha").val(), opcion: "chequearErroresCredenciales"},
            success: function(respuesta){
                if(respuesta == "false"){
                    $("#formulario").append("<p class='text-center' style='color: red;' id='mensajeError'>Contraseña o email incorrectos.</p>");
                }
                else{
                    $("#formulario")[0].submit();
                }
            }
        });
    }
);