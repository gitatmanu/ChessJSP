var raisedPiece = false;
var isPromotion = false;

function checkSquare(square) {
    if (isPromotion) {
        $('#ascendModal').modal('show');
    } else {
        raisedPiece ? play(square) : liftPiece(square);
    }
}

function promotion(chosenPiece) {
    const data = new FormData();
    data.append("key", "promotion");
    data.append("chosenPiece", chosenPiece);
    fetch('promotion', {
        method: 'POST',
        body: data
    })
        .then(function (response) {
            if (response.ok) {
                return response.json();
            } else {
                throw "Error en la llamada Ajax";
            }
        })
        .then(function (text) {
            modifiedBoard(text['promotion']);
            isPromotion = false;
            $('#ascendModal').modal('hide');
        })
        .catch(function (err) {
            console.log(err);
        });
}

function play(square) {
    const data = new FormData();
    data.append("key", "play");
    data.append("square", square);

    fetch('play', {
        method: 'POST',
        body: data
    })
        .then(function (response) {
            if (response.ok) {
                return response.json();
            } else {
                throw "Error en la llamada Ajax";
            }
        })
        .then(function (text) {
            console.log(text);
            if (text['state'] == "not valid") {
                paintDefaultBoard();
            } else {
                paintDefaultBoard();
                modifiedBoard(text['modifiedBoard']);
                modifiedCemetery(text['whiteCemetery'], text['blackCemetery']);
                if (text['promotion'] == true) {
                    isPromotion = true;
                    $('#ascendModal').modal('show');
                }
            }
            raisedPiece = !raisedPiece;
        })
        .catch(function (err) {
            console.log(err);
        });
}

function liftPiece(square) {
    const data = new FormData();
    data.append("key", "liftPiece");
    data.append("square", square);

    fetch('liftPiece', {
        method: 'POST',
        body: data
    })
        .then(function (response) {
            if (response.ok) {
                return response.json();
            } else {
                throw "Error en la llamada Ajax";
            }
        })
        .then(function (text) {
            console.log(text);
            paintValidMovements(text['validMovements']);
            raisedPiece = !raisedPiece;
        })
        .catch(function (err) {
            console.log(err);
        });
}