package org.colpos.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.colpos.modelo.Producto;
import org.colpos.modelo.ProductoDAO;



@WebServlet("/ControladorProducto")
public class ControladorProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductoDAO dao=new ProductoDAO();
	Producto p=new Producto(0, null, null, null, null, null);
       
    /**
     * @return 
     * @see HttpServlet#HttpServlet()
     */
    public ControladorProducto() {
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
			List<Producto>datos=((ProductoDAO) dao).listar();
			request.setAttribute("datos", datos);
			request.getRequestDispatcher("ProductoIndex.jsp").forward(request, response);
			break;
		case "Nuevo":
			request.getRequestDispatcher("ProductoAdd.jsp").forward(request, response);
			break;
		case "Guardar":
			String id=request.getParameter("txtid");
			String nombreProducto=request.getParameter("txtnombreProducto");
			String precioUnitario=request.getParameter("txtprecioUnitario");
			String precioMayoreo=request.getParameter("txtprecioMayoreo");
			String nombreCliente=request.getParameter("txtnombreCliente");
			String telefono=request.getParameter("txttelefono");
			p.setId(id);
			p.setNombreProducto(nombreProducto);
			p.setPrecioUnitario(precioUnitario);
			p.setPrecioMayoreo(precioMayoreo);
			p.setNombreCliente(nombreCliente);
			p.setTelefono(telefono);
			dao.agregar(p);
			request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
			break;
		case "Editar":
			String ide=request.getParameter("id");
			Producto p1=dao.listarId(ide);
			request.setAttribute("producto", p);
			request.getRequestDispatcher("ProductoEditar.jsp").forward(request, response);
			break;
		case "Actualizar":
			String id1=request.getParameter("txtid");
			String nombreProducto1=request.getParameter("txtnombreProducto");
			String precioUnitario1=request.getParameter("txtprecioUnitario");
			String precioMayoreo1=request.getParameter("txtprecioMayoreo");
			String nombreCliente1=request.getParameter("txtnombreCliente");
			String telefono1=request.getParameter("txttelefono");
			p.setId(id);
			p.setNombreProducto(nombreProducto1);
			p.setPrecioUnitario(precioUnitario1);
			p.setPrecioMayoreo(precioMayoreo1);
			p.setNombreCliente(nombreCliente1);
			p.setTelefono(telefono1);
			dao.Actualizar(p1);
			request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
			break;
		default:
			throw new AssertionError();
		}
	}


}
