<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EXELENTE DIA</title>
</head>
<body>
	<center>
		<div>
			<h3>Personas</h3>
			<form action="Controlador" method = "POST">
				<input type = "submit" name = "accion" value = "Listar">
				<input type = "submit" name = "accion" value = "Nuevo">
			</form>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOMBRE</th>
						<th>APELLIDO PATERNO</th>
						<th>APELLIDO MATERNO</th>
						<th> CORREO</th>
						<th>TELEFONO</th>
						<tH>ACCIONES</tH>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dato" items="$(datos)">
					<tr>
						<td>$(dato.getId())</td>
						<td>$(dato.getNombre())</td>
						<td>$(dato.getApellidoPaterno())</td>
						<td>$(dato.getApellidoMaterno())</td>
						<td>$(dato.getCorreo())</td>
						<td>$(dato.getTelefono())</td>
						<td>
							<form accion= "Controlador" method= "POST">
								<input type="hidden" name="id" value="${dato.getId }">
								<input type="submit" name="accion" value="Editar">
								<input type="submit" name="accion" value="Delete">
							</form>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</center>
</body>
</html>