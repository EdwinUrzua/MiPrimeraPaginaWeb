package org.colpos.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
	PreparedStatement ps;
	ResultSet rs;
	Conexion c = new Conexion();
	Connection con;

	@SuppressWarnings("rawtypes")
	public List listar() {
		return null;
	

	List<Producto> lista=new ArrayList<>();
	try	{
		Conexion.connectDB();
		String s;
		ps = con.prepareStatement(s);
		rs = ps.executeQuery();
		while (rs.next()) {
			Producto p = new Producto(0, s, s, s, s, s);
			p.setId(rs.getInt(1));
			p.setNombreProducto(rs.getString(2));
			p.setPrecioUnitario(rs.getString(3));
			p.setPrecioMayoreo(rs.getString(4));
			p.setNombreCliente(rs.getString(5));
			p.setTelefono(rs.getString(7));
			lista.add(p);
		}

	}catch(Exception e)
	{

	}return lista;
	
}

	public int agregar(Producto p) {
		int r = 0;
		String sql = "insert into persona (id, nombreProducto, precioUnitario, precioMayoreo, nombreCliente,telefono) values (?,?,?,?,?,?)";
		try {
			Conexion.connectDB();
			ps = con.prepareStatement(sql);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getNombreProducto());
			ps.setString(3, p.getPrecioUnitario());
			ps.setString(4, p.getPrecioMayoreo());
			ps.setString(5, p.getNombreCliente());
			ps.setString(3, p.getTelefono());
			r = ps.executeUpdate();
			if (r == 1) {
				r = 1;
			} else {
				r = 0;
			}
		} catch (Exception e) {
		}
		return r;
	}

	public Producto listarId(String id) {
		String sql = "select * from producto" + id;
		Producto produc = new Producto(0, sql, sql, sql, sql, sql);
		try {
			Conexion.connectDB();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				produc.setId(rs.getInt(1));
				produc.setNombreProducto(rs.getString(2));
				produc.setPrecioUnitario(rs.getString(3));
				produc.setPrecioMayoreo(rs.getString(4));
				produc.setNombreCliente(rs.getString(5));
				produc.setTelefono(rs.getString(6));
			}

		} catch (Exception e) {
			System.out.println("Exception in Producto Class: "+e.getMessage());
		}
		/*Necesitas crear una lista por ejemplo ArrayList<Producto> listaProducto = new ArrayList<Producto>();
		 * La lista puede ser una opción tentativa para almacenar una lista de objetos*/
		return produc;
	}


	public int Actualizar(Producto p) {
		int r = 0;
		String sql = "update persona setnombreProducto=?, precioUnitario=?, precioMayoreo=?, nombreCliente=?, settelefono=?";
		try {
			Conexion.connectDB();
			ps = con.prepareStatement(sql);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getNombreProducto());
			ps.setString(3, p.getPrecioUnitario());
			ps.setString(4, p.getPrecioMayoreo());
			ps.setString(5, p.getNombreCliente());
			ps.setString(3, p.getTelefono());
			r = ps.executeUpdate();
			if (r == 1) {
				r = 1;
			} else {
				r = 0;
			}
		} catch (Exception e) {
		}
		return r;
	}
}
