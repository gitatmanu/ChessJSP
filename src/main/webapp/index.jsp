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
<link href="/css/style.css" rel="stylesheet" />
<script src="/js/utils.js"></script>
<script src="/js/functions.js"></script>
<script src="/js/vista.js"></script>
</head>
<body>
    <%
    Partida partida = new Partida(Partida.tableroDefault());

    String color = "white";
    String casilla = "";
    char fila = 'A';
    out.println("<main>");     
    out.println("<div id ='recuadro'>");     
    out.println("<div id='tablero'>");
    for (int i = 0; i <= 7; i++) {
        out.println("<div class='fila'>");
        for (int j = 0; j <= 7; j++) {
            casilla = fila + String.valueOf(j+1);
            out.println("<div id='" + casilla + "' class='casilla' style='background-color: " + color + "' onclick='comprobarCasilla(\"" + casilla + "\")'>");
            if(partida.getTablero()[i][j] != null){
                out.println("<span id='"+ "span"+ casilla + "'>" + partida.getTablero()[i][j] + "</span>");
            }else {out.println("<span id='" + "span" + casilla + "'></span>");}
                out.println("</div>");
            color = color == "white" ? "brown   " : "white";
        }
        fila++;
        color = color == "white" ? "brown" : "white";
        out.println("</div>");  
    }
    out.println("</div>");
    out.println("</div>");
    out.println("</main>");
        
    session.setAttribute("partida", partida);
%>

</body>
</html>