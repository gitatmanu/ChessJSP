<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prototipo tablero ajedrez</title>
<style type="text/css">

	body {
		background-color: pink;
	}

	#tablero {
		width: 560px;
		height: 560px;
	}


	.casilla {
		width: 70px;
		height: 70px;
		float: left;
  		text-align: center;
  		margin: auto;
  		font-size:4em;
  	}

	.tenue {background-color: white;}

	.opaca {background-color: gray;}

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
			console.error(error)
		})
		
	}

</script>
</head>
<body>

	<main id="tablero">
		<div class="fila8">
			<div class="casilla tenue"></div>
			<div class="casilla opaca"></div>
			<div class="casilla tenue"></div>
			<div class="casilla opaca"></div>
			<div class="casilla tenue"></div>
			<div class="casilla opaca"></div>
			<div class="casilla tenue"></div>
			<div class="casilla opaca"></div>		
		</div>
		<div class="fila7">
			<div class="casilla opaca"></div>
			<div class="casilla tenue"></div>
			<div class="casilla opaca"></div>
			<div class="casilla tenue"></div>
			<div class="casilla opaca"></div>
			<div class="casilla tenue"></div>
			<div class="casilla opaca"></div>
			<div class="casilla tenue"></div>		
		</div>
		<div class="fila6">
			<div class="casilla tenue"></div>
			<div class="casilla opaca"></div>
			<div class="casilla tenue"></div>
			<div class="casilla opaca"></div>
			<div class="casilla tenue"></div>
			<div class="casilla opaca"></div>
			<div class="casilla tenue"></div>
			<div class="casilla opaca"></div>		
		</div>
		<div class="fila5">
			<div class="casilla opaca"></div>
			<div class="casilla tenue"></div>
			<div class="casilla opaca"></div>
			<div class="casilla tenue"></div>
			<div class="casilla opaca"></div>
			<div class="casilla tenue"></div>
			<div class="casilla opaca"></div>
			<div class="casilla tenue"></div>		
		</div>
		<div class="fila4">
			<div class="casilla tenue"></div>
			<div class="casilla opaca"></div>
			<div class="casilla tenue"></div>
			<div class="casilla opaca"></div>
			<div class="casilla tenue"></div>
			<div class="casilla opaca"></div>
			<div class="casilla tenue"></div>
			<div class="casilla opaca"></div>		
		</div>
		<div class="fila3">
			<div class="casilla opaca"></div>
			<div class="casilla tenue"></div>
			<div class="casilla opaca"></div>
			<div class="casilla tenue"></div>
			<div class="casilla opaca"></div>
			<div class="casilla tenue"></div>
			<div class="casilla opaca"></div>
			<div class="casilla tenue"></div>		
		</div>
		<div class="fila2">
			<div id="A2" class="casilla tenue">&#9817;</div>
			<div id="B2" class="casilla opaca">&#9817;</div>
			<div id="C2" class="casilla tenue">&#9817;</div>
			<div id="D2" class="casilla opaca">&#9817;</div>
			<div id="E2" class="casilla tenue">&#9817;</div>
			<div id="F2" class="casilla opaca">&#9817;</div>
			<div id="G2" class="casilla tenue">&#9817;</div>
			<div id="H2" class="casilla opaca">&#9817;</div>		
		</div>
		<div class="fila1">
			<div id="A1" class="casilla opaca" onclick="clickCasilla('A1')">&#9814;</div>
			<div id="B1" class="casilla tenue" onclick="clickCasilla('B1')">&#9816;</div>
			<div id="C1" class="casilla opaca" onclick="clickCasilla('C1')">&#9815;</div>
			<div id="D1" class="casilla tenue" onclick="clickCasilla('D1')">&#9813;</div>
			<div id="E1" class="casilla opaca" onclick="clickCasilla('E1')">&#9812;	</div>
			<div id="F1" class="casilla tenue" onclick="clickCasilla('F1')">&#9815;	</div>
			<div id="G1" class="casilla opaca" onclick="clickCasilla('G1')">&#9816;	</div>
			<div id="H1" class="casilla tenue" onclick="clickCasilla('H1')">&#9814;	</div>		
		</div>
	</main>

</body>
</html>