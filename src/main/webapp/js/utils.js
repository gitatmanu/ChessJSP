var piezaAlzada = false;
var esAscenso = false;

function comprobarCasilla(casilla) {
    if(esAscenso) {
        $('#ascensoModal').modal('show');
    } else {
        piezaAlzada ? jugada(casilla) : alzarPieza(casilla);
        piezaAlzada = !piezaAlzada;
    }
}

function ascenso(piezaElegida) {
        const data = new FormData();
        data.append("clave", "ascenso");
        data.append("piezaElegida", piezaElegida);
        fetch('Ascenso', {
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
        })
        .catch(function(err) {
           console.log(err);
        });
}

function jugada(casilla) {
        const data = new FormData();
        data.append("clave", "jugada");
        data.append("casilla", casilla);
        
        fetch('Moves', {
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
            tableroModificado(text['tableroModificado']);
            pintaTableroEstandar();
            if (text['ascenso'] == true) {
                esAscenso = true;
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
        
        fetch('Moves', {
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