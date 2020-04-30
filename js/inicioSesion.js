$("#btnEntrar").click(function(){
        $("#mensajeError").remove();

        $.ajax({
            method: "POST",
            url: "../comprobarLogin",
            data: {email: $("#email").val(), contrasenha: $("#contrasenha").val()},
            success: function(respuesta){
                if(respuesta == "false"){
                    $("#formulario").append("<p style='color: red;' id='mensajeError'>Contraseña o email incorrectos.</p>");
                }
                else{
                    $("#formulario")[0].submit();
                }
            }
        });
    }
);