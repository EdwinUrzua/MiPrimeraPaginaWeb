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
			<form action="Controlador" method="POST">
				<input type="submit" name="accion" value="Listar"> <input
					type="submit" name="accion" value="Nuevo">
			</form>
		</div>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOMBREPRODUCTO</th>
						<th>PRECIO UNITARIO</th>
						<th>PRECIO MAYOREO</th>
						<th>NOMBRE CLIENTE</th>
						<th>TELEFONO</th>
						<tH>ACCIONES</tH>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dato" items="$(datos)">
						<tr>
							<td>$(dato.getId())</td>
							<td>$(dato.getNomProducto())</td>
							<td>$(dato.getPecioU())</td>
							<td>$(dato.getPrecioM())</td>
							<td>$(dato.getNombreC())</td>
							<td>$(dato.getTelefono())</td>
							<td>
								<form>
									<input type="submit" value="Editar"> <input
										type="submit" value="Delete">
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