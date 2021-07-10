package org.colpos.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
	PreparedStatement ps;
	ResultSet rs;
	Conexion c = new Conexion();
	Connection con;
	
	@SuppressWarnings("rawtypes")
	public List listar() {
		return null;
	}

		List<Persona> lista=new ArrayList<>();
		try {
			Conexion.connectDB();
			String s;
			ps = con.prepareStatement (s);
			rs = ps.executeQuery();
			while (rs.next()) {
				Persona p = new Persona();
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setApellidoPaterno(rs.getString(3));
				p.setApellidoMaterno(rs.getString(4));
				p.setCorreo(rs.getString(5));
				p.setTelefono(rs.getString(6));
				lista.add(p);
			}
			
		}catch (Exception e) {
			
		}
		return lista;
	}
}


	public int agregar (Persona p) {
		int r=0;
		String sql="insert into persona (id, nombre, apellidoPaterno, apellidoMaterno, correo, telefono) values (?,?,?,?,?,?)";
		try {
			Conexion.connectDB();
			ps=con.prepareStatement(sql);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getNombre());
			ps.setString(3, p.getApellidoPaterno());
			ps.setString(4, p.getApellidoMaterno());
			ps.setString(5, p.getCorreo());
			ps.setString(6, p.getTelefono());
			r=ps.executeUpdate();
			if(r==1) {
				r=1;
			}else {
				r=0;
			}
		}catch (Exception e) {
		}
		return r;
	}
	public Persona listarId(String id) {
		String sql="select * from persona" + id;
		Persona p=new Persona();
		try {
			Conexion.connectDB();
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setApellidoPaterno(rs.getString(3));
				p.setApellidoMaterno(rs.getString(4));
				p.setCorreo(rs.getString(5));
				p.setTelefono(rs.getString(6));
			}
			
		}catch (Exception e) {
		}
		return p;
	}
	public int Actualizar (Persona p) {
		int r=0;
		String sql="update persona setnombre=?, setapellidoPaterno=?, setapellidoMaterno=?, setcorreo=?, settelefono=?";
		try {
			Conexion.connectDB();
			ps=con.prepareStatement(sql);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getNombre());
			ps.setString(3, p.getApellidoPaterno());
			ps.setString(4, p.getApellidoMaterno());
			ps.setString(5, p.getCorreo());
			ps.setString(6, p.getTelefono());
			r=ps.executeUpdate();
			if(r==1) {
				r=1;
			}else {
				r=0;
			}	
		}catch (Exception e) {
		}
		return r;
	}
}
	
