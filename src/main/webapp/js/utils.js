var piezaAlzada = false;

function comprobarCasilla(casilla) {
        
        const data = new FormData();        
        var clave = piezaAlzada !== true ? "alzarPieza" : "jugada";
    
        data.append("clave", clave);
        data.append("casilla", casilla);

        fetch('Move', {
                method: 'POST',
                body: data
        })
        .then(function(response) {
           if(response.ok) {
                return response.json();
           } else {
               throw "Error en la llamada Ajax";
           }

        })
        .then(function(text) {
            if(typeof(text[0][0]) === "boolean") {
                imprimirMovimientosValidos(text);
            } else if (text === "no valido") {
                pintaTableroEstandar();
            }else{
                tableroModificado(text);
                pintaTableroEstandar();
            } 
            piezaAlzada = false;
    })
        .catch(function(err) {
           console.log(err);
        });
}

