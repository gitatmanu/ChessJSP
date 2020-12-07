function modifiedCemetery(whiteCemetery, blackCemetery)
{
    document.getElementById("cemetery").innerHTML = "";
    for (let j = 0; j <= whiteCemetery.length; j++) {
        const white = document.createElement("span");
        white.setAttribute("class", "square");
        white.innerHTML = whiteCemetery[j]['asciiCode'];
        document.getElementById("cemetery").appendChild(white);
    }
    for (let i = 0; i <= blackCemetery.length; i++) {
        const black = document.createElement("span");
        black.setAttribute("class", "square");
        black.innerHTML = blackCemetery[i]['asciiCode'];
        document.getElementById("cemetery").appendChild(black);
    }
}

function modifiedBoard(board)
{
    var square = "";
    var row = 'A';

    for (var i = 0; i <= 7; i++) 
    {
        for (var j = 0; j <= 7; j++) 
        {
            square = row + (j+1);
            if (board[i][j] !== null) 
            {
                document.getElementById("span" + square).innerHTML = board[i][j]["asciiCode"];
            }else 
            {
                document.getElementById("span" + square).innerHTML = "";
            }
        }
        row = nextChar(row);
    }
}

function paintValidMovements(validMovements) 
{
    var row = 'A';

    for (var i = 0; i <= 7; i++) 
    {
        for (var j = 0; j <= 7; j++) 
        {
            square = row + (j+1);
            if (validMovements[i][j] === true) 
            {
                document.getElementById(square).style.boxShadow = "inset 0 0 0 5px #cf779b";
                document.getElementById(square).style.backgroundColor = "#f4bad2";                            
            }
        }
        row = nextChar(row);
    }
}

function paintDefaultBoard() 
{
    var colour = "#99e8bb";
    var square = "";
    var row = 'A';

    for (var i = 0; i <= 7; i++) 
    {
        for (var j = 0; j <= 7; j++) 
        {
            square = row + (j+1);
            document.getElementById(square).style.backgroundColor = colour;
            document.getElementById(square).style.boxShadow = "none";
            colour = (colour === "#99e8bb") ? "#744941" : "#99e8bb";
        }
        row = nextChar(row);
        colour = (colour === "#99e8bb") ? "#744941" : "#99e8bb";
    }
}

