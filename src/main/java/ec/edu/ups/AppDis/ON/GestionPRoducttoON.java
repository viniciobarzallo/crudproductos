package ec.edu.ups.AppDis.ON;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;

import ec.edu.ups.AppDis.dao.ProductoDao;
import ec.edu.ups.AppDis.model.Producto;

@Stateless
public class GestionPRoducttoON {

	@Inject
	private ProductoDao pdao;
	
	public void insertarProducto(Producto p) {
		pdao.insertarProducto(p);
	}
	
	
	
	
	public Producto buscarProducto(int idproducto) {
		return pdao.buscarProducto(idproducto);
	}
	
	
	public List<Producto> listaProducto(){
		
		return pdao.listaProducto();
	}
	
	
	
	public void Actualizar(Producto pr) {
		
	pdao.Actualizar(pr);	
	}
	
}
