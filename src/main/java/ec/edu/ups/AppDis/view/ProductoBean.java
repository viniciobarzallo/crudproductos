package ec.edu.ups.AppDis.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ec.edu.ups.AppDis.ON.GestionPRoducttoON;
import ec.edu.ups.AppDis.model.Producto;


@ManagedBean
@ViewScoped
public class ProductoBean {
	
	@Inject
	private GestionPRoducttoON on;
	
	private Producto pro;
	
	private int codigo;
	
	private List<Producto> listaproducto;
	
	
	
	
	public Producto getPro() {
		return pro;
	}

	public void setPro(Producto pro) {
		this.pro = pro;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public List<Producto> getListaproducto() {
		return listaproducto;
	}

	public void setListaproducto(List<Producto> listaproducto) {
		this.listaproducto = listaproducto;
	}

	@PostConstruct
	public void init() {
	
		pro =new Producto();
		ListarProducto();
	}
	
	public void ListarProducto() {
		listaproducto=on.listaProducto();
	}

	public String crearProducto() {
		on.insertarProducto(pro);
		System.out.println("Creado usuario");
		return null;
	}

	public void buscarProductos() {
		try {
			
			pro=on.buscarProducto(codigo);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al Listar" +e.getMessage());
		}
		
	}
	
	
}
