<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Chess.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajedrez DUAL</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="/js/utils.js"></script>
<script src="/js/functions.js"></script>
<script src="/js/vista.js"></script>
<link href="/css/style.css" rel="stylesheet" />
</head>
<body>
    <%
    Partida partida = Partida.inicializaPartida();
    session.setAttribute("partida", partida);
    
    String color = "#99e8bb";
    String casilla = "";
    char fila = 'A';
    out.println("<main>");     
    out.println("<div id='tablero'>");
    for (int i = 0; i <= 7; i++) {
        out.println("<div class='fila'>");
        for (int j = 0; j <= 7; j++) {
            casilla = fila + String.valueOf(j+1);
            out.println("<div id='" + casilla + "' class='casilla' style='background-color: " + color + "' onclick='comprobarCasilla(\"" + casilla + "\")'>");
            if(partida.getTablero()[i][j] != null){
                out.println("<span id='"+ "span"+ casilla + "'>" + partida.getTablero()[i][j].getAscii() + "</span>");
            }else {out.println("<span id='" + "span" + casilla + "'></span>");}
                out.println("</div>");
            color = color == "#99e8bb" ? "#744941" : "#99e8bb";
        }
        fila++;
        color = color == "#99e8bb" ? "#744941" : "#99e8bb";
        out.println("</div>");  
    }
    out.println("</div>");
    out.println("</main>");   
%>
<!-- Modal -->
<div class="modal fade" id="ascensoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div style="background-color: #dcdcdc;" class="modal-content">        
        <div class="ascensoModal">
            <div style="color: red;" onclick='ascenso("Reina")'>&#9813;</div>
            <div style="color: orange;" onclick='ascenso("Torre")'>&#9814;</div>
            <div style="color: yellow;" onclick='ascenso("Alfil")'>&#9815;</div>
            <div style="color: green;" onclick='ascenso("Caballo")'>&#9816;</div>
        </div>
    </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>