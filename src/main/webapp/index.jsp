<%@page import="Chess.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DUAL Chess on JSP</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="/js/ajax.js"></script>
<script src="/js/functions.js"></script>
<script src="/js/view.js"></script>
<link href="/css/style.css" rel="stylesheet" />
</head>
<body>
    <%
    Game game = new Game(Game.setDefaultBoard());
    session.setAttribute("game", game);
    
    String colour = "#99e8bb";
    String square = "";
    char row = 'A';
    out.println("<main>");
    out.println("<div id='board'>");
    for (int i = 0; i <= 7; i++) {
        out.println("<div class='row'>");
        for (int j = 0; j <= 7; j++) {
            square = row + String.valueOf(j+1);
            out.println("<div id='" + square + "' class='square' style='background-color: " + colour + "' onclick='checkSquare(\"" + square + "\")'>");
            if(game.getBoard()[i][j] != null){
                out.println("<span id='"+ "span"+ square + "'>" + game.getBoard()[i][j].getAsciiCode()+ "</span>");
            }else {out.println("<span id='" + "span" + square + "'></span>");}
                out.println("</div>");
            colour = colour.equals("#99e8bb") ? "#744941" : "#99e8bb";
        }
        row++;
        colour = colour.equals("#99e8bb") ? "#744941" : "#99e8bb";
        out.println("</div>");  
    }
    out.println("</div>");
    %>
        <div id="cemetery"></div>
    <%
    out.println("</main>");   
    %>



<div class="modal fade" id="ascendModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
      <div style="background-color: #dcdcdc;" class="modal-content">        
          <div class="ascendModal">
              <div onclick='promotion("Queen")'>&#9813;</div>
              <div onclick='promotion("Rook")'>&#9814;</div>
              <div onclick='promotion("Bishop")'>&#9815;</div>
              <div onclick='promotion("Knight")'>&#9816;</div>
          </div>
      </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
</body>
</html>