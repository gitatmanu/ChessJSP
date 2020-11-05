function tableroModificado(tablero) {
    var casilla = "";
    var fila = 'A';

    for (i = 0; i <= 7; i++) {
        for (j = 0; j <= 7; j++) {
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

    for (i = 0; i <= 7; i++) {
        for (j = 0; j <= 7; j++) {
            casilla = fila + (j+1);
            if (movimientosValidos[i][j] === true) {
                document.getElementById(casilla).style.boxShadow = "inset 0 0 0 4px #3BEB6C";
                document.getElementById(casilla).style.transition = ".03s ease";
                document.getElementById(casilla).style.animation = "tiembla 0.5s infinite";
                document.getElementById(casilla).style.backgroundColor = "#00942A";                            
            }
        }
        fila = nextChar(fila);
    }
}

function pintaTableroEstandar() {
    var color = "white";
    var casilla = "";
    var fila = 'A';

    for (i = 0; i <= 7; i++) {
        for (j = 0; j <= 7; j++) {
            casilla = fila + (j+1);
            document.getElementById(casilla).style.backgroundColor = color;
            document.getElementById(casilla).style.boxShadow = "none";
            document.getElementById(casilla).style.animation = "none";
            color = (color === "white") ? "brown" : "white";
        }
        fila = nextChar(fila);
        color = (color === "white") ? "brown" : "white";
    }
}

