<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<div>
			<h3>Agregar Personas</h3>
		</div>
		<div>
			<form action="Controlador" method="POST">
			ID:
			<input type="text" name="txtid"><br>
			NOMBRE:
			<input type="text" name="txtnom"><br>
			APELLIDOP:
			<input type="text" name="txtapep"><br>
			APELLIDOM:
			<input type="text" name="txtapem"><br>
			CORREO:
			<input type="text" name="txtcorreo"><br>
			TELEFONO:
			<input type="text" name="txttelefono"><br>
			<input type="submit" name="accion" value="Actualizar">
			</form>
		</div>
	</center>
</body>
</html>