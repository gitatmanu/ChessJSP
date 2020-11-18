function tableroModificado(tablero) {
    var casilla = "";
    var fila = 'A';

    for (var i = 0; i <= 7; i++) {
        for (var j = 0; j <= 7; j++) {
            casilla = fila + (j+1);
            if (tablero[i][j] !== null) {
                document.getElementById("span" + casilla).innerHTML = tablero[i][j]["ascii"];
            }else {
                document.getElementById("span" + casilla).innerHTML = "";
            }
        }
        fila = nextChar(fila);
    }
}

function pintaCasillasValidas(movimientosValidos) {
    var fila = 'A';

    for (var i = 0; i <= 7; i++) {
        for (var j = 0; j <= 7; j++) {
            casilla = fila + (j+1);
            if (movimientosValidos[i][j] === true) {
                document.getElementById(casilla).style.boxShadow = "inset 0 0 0 5px #cf779b";
                document.getElementById(casilla).style.backgroundColor = "#f4bad2";                            
            }
        }
        fila = nextChar(fila);
    }
}

function pintaTableroEstandar() {
    var color = "#99e8bb";
    var casilla = "";
    var fila = 'A';

    for (var i = 0; i <= 7; i++) {
        for (var j = 0; j <= 7; j++) {
            casilla = fila + (j+1);
            document.getElementById(casilla).style.backgroundColor = color;
            document.getElementById(casilla).style.boxShadow = "none";
            color = (color === "#99e8bb") ? "#744941" : "#99e8bb";
        }
        fila = nextChar(fila);
        color = (color === "#99e8bb") ? "#744941" : "#99e8bb";
    }
}

