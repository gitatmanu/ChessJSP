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
                document.getElementById(casilla).style.boxShadow = "inset 0 0 0 4px #3BEB6C";
                document.getElementById(casilla).style.transition = ".03s ease";
                document.getElementById(casilla).style.backgroundColor = "#00942A";                            
            }
        }
        fila = nextChar(fila);
    }
}

function pintaTableroEstandar() {
    var color = "#e3d3db";
    var casilla = "";
    var fila = 'A';

    for (var i = 0; i <= 7; i++) {
        for (var j = 0; j <= 7; j++) {
            casilla = fila + (j+1);
            document.getElementById(casilla).style.backgroundColor = color;
            document.getElementById(casilla).style.boxShadow = "none";
            color = (color === "#e3d3db") ? "#34232c" : "#e3d3db";
        }
        fila = nextChar(fila);
        color = (color === "#e3d3db") ? "#34232c" : "#e3d3db";
    }
}

