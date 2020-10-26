<%@page import="Chess.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prototipo tablero ajedrez</title>
<style type="text/css">

	#tablero {
		width: 1000px;
		height: 1000px;
	}

        .fila {
            clear: both;
        }
	.casilla {
		width: 65px;
		height: 65px;
		float: left;
  		text-align: center;
  		font-size:3.5em;
  	}


</style>

<script>

	function clickCasilla(casilla) {
		var data = new FormData();
		data.append("casilla", document.getElementById("A1"));
		fetch('Move', {
			method: 'POST',
			body: data
		})
		.then(function(text){
			console.log(text);
		})
		.catch(function(error){
			console.error(error);
		});
		
	}

</script>
</head>
<body>    
    <%
        Partida partida = new Partida(Partida.tableroDefault());
        String color = "white";
        out.println("<main id='tablero'>");
        for (int i = 0; i <= 7; i++) {
            out.println("<div class='fila'>");
            for (int j = 0; j <= 7; j++) {
                out.println("<div class='casilla' " + "style='background-color: " + color + "' >");
                if(partida.getTablero()[i][j] != null){
                    out.println("<span>" + partida.getTablero()[i][j].toString(partida.getTablero()[i][j].getColor()) + "</span>");
                }
                    out.println("</div>");
                color = color == "white" ? "brown   " : "white";
            }
            color = color == "white" ? "brown" : "white";
            out.println("</div>");  
        }
        out.println("</main>");
    %>

</body>
</html>