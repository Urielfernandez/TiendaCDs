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

$(document).ready(function(){
    //Obtenemos el valor de la cookie
    var valorCookie = getCookie("email");
    var partes = valorCookie.split("=");
    valorCookie = partes[1];

    // Comprobar si hai cookie para pagar

});