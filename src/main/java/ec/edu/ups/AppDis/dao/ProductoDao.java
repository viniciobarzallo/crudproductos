package ec.edu.ups.AppDis.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.AppDis.model.Producto;


@Stateless
public class ProductoDao {

	@PersistenceContext
	private EntityManager em;
	
	public void insertarProducto(Producto p) {
		em.persist(p);
	}
	
	public Producto buscarProducto(int idproducto) {
		return em.find(Producto.class, idproducto);
	}
	
	
	public List<Producto> listaProducto(){
		String jpql = "SELECT p FROM Producto p";
		Query q = em.createQuery(jpql, Producto.class);

		return q.getResultList();
	}
	
	
	public void Actualizar(Producto pr) {
		Producto p= buscarProducto(pr.getIdproducto());
		if (p!=null) {
			em.persist(p);
		}else {
			
			em.merge(pr);
		}
		
		
		
	}
	
	
}
