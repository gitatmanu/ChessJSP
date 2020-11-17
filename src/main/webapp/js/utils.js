var piezaAlzada = true;
var esAscenso = false;

function comprobarCasilla(casilla) {
    if(esAscenso) {
        $('#ascensoModal').modal('show');
    } else {
        piezaAlzada = !piezaAlzada;
        piezaAlzada ? jugada(casilla) : alzarPieza(casilla);
    }
}

function ascenso(piezaElegida) {
        const data = new FormData();
        data.append("clave", "ascenso");
        data.append("piezaElegida", piezaElegida);
        fetch('ascenso', {
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
            tableroModificado(text['ascenso']);
            esAscenso = false;
            $('#ascensoModal').modal('hide');
        })
        .catch(function(err) {
           console.log(err);
        });
}

function jugada(casilla) {
        const data = new FormData();
        data.append("clave", "jugada");
        data.append("casilla", casilla);
        
        fetch('jugada', {
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
            console.log(text);
            if(text['estado'] == "no válido") {
                console.log("entra");
                pintaTableroEstandar();
            } else {
                tableroModificado(text['tableroModificado']);
                pintaTableroEstandar();
                if (text['ascenso'] == true) {
                    esAscenso = true;
                    $('#ascensoModal').modal('show');
                }                
            }
        })
        .catch(function(err) {
           console.log(err);
        });
}

function alzarPieza(casilla) {
        const data = new FormData();    
        data.append("clave", "alzarPieza");
        data.append("casilla", casilla);
        
        fetch('alzarPieza', {
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
            pintaCasillasValidas(text['movimientosValidos']);
        })
        .catch(function(err) {
           console.log(err);
        });
}