package org.colpos.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.colpos.modelo.Persona;
import org.colpos.modelo.PersonaDAO;


@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonaDAO dao=new PersonaDAO();
	Persona p=new Persona();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String accion=request.getParameter("accion");
		switch (accion) {
		case "Listar":
			Object dat;
			List<Persona>datos=((PersonaDAO) dao).listar();
			request.setAttribute("datos", datos);
			request.getRequestDispatcher("Index.jsp").forward(request, response);
			break;
		case "Nuevo":
			request.getRequestDispatcher("Add.jsp").forward(request, response);
			break;
		case "Guardar":
			String id=request.getParameter("txtid");
			String nombre=request.getParameter("txtnombre");
			String apellidoPaterno=request.getParameter("txtapellidoPaterno");
			String apellidoMaterno=request.getParameter("txtapellidoMaterno");
			String correo=request.getParameter("txtcorreo");
			String telefono=request.getParameter("txttelefono");
			p.setId(id);
			p.setNombre(nombre);
			p.setApellidoPaterno(apellidoPaterno);
			p.setApellidoMaterno(apellidoMaterno);
			p.setCorreo(correo);
			p.setTelefono(telefono);
			dao.agregar(p);
			request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
			break;
		case "Editar":
			request.getRequestDispatcher("Editar.jsp").forward(request, response);
			break;
		default:
			throw new AssertionError();
		}
	}

}
