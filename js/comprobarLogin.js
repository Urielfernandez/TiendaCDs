function getCookie(nombreCookie) {
    var nombre = nombreCookie + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var partesCookie = decodedCookie.split(';');
    
    for(var i = 0; i < partesCookie.length; i++) {
        var c = partesCookie[i];
        
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    
    return "";
}

$("#btnLogin").click(function(){
    //Obtenemos el valor de la cookie
    var valorCookie = getCookie("email");
    var partes = valorCookie.split("=");
    valorCookie = partes[1];

    console.log(valorCookie);
    console.log(valorCookie != null);

    if(valorCookie != null){
        $("#formulario").submit();
    }
});