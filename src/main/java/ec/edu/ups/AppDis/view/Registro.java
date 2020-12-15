package ec.edu.ups.AppDis.view;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.HttpRetryException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.AppDis.ON.GestionPRoducttoON;
import ec.edu.ups.AppDis.model.Producto;


@WebServlet("/producto")
public class Registro extends HttpServlet {

	@Inject
	private GestionPRoducttoON on;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().println("<h1>Autores Insertados</h1>");

		Producto p1=new Producto();
		p1.setDescripcion("ron");
		p1.setCantidad(45);
		p1.setCategoria("licores");
		p1.setPrecio(21.21);
		
		
		Producto p2=new Producto();
		p2.setDescripcion("galleta");
		p2.setCantidad(5);
		p2.setCategoria("snacks");
		p2.setPrecio(1.50);
		
		
		
	on.insertarProducto(p1);
		on.insertarProducto(p2);
		
		
		
		List<Producto> listap=on.listaProducto();
		
		for (Producto pp : listap) {
			System.out.println("Descripcion" + pp.getDescripcion());
			System.out.println("Precio" + pp.getPrecio());
		}
		
		
		Producto p3=on.buscarProducto(1);
		System.out.println("Descripcion P3" + p3.getDescripcion() );
//		
		
		
		
	}
}
