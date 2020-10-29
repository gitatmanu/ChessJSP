function comprobarCasilla(casilla) {
        
        const data = new FormData();
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
            imprimirResultados(text);
    })
        .catch(function(err) {
           console.log(err);
        });

}

