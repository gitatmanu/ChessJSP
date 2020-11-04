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
            if(text[0][0] === true || text[0][0] === false) {
                pintaCasillasValidas(text);
            } else if (text === "no valido") {
                pintaTableroEstandar();
            }else{
                tableroModificado(text);
                pintaTableroEstandar();
            } 
            piezaAlzada = piezaAlzada === true ? false : true;
    })
        .catch(function(err) {
           console.log(err);
        });
     
       
}

