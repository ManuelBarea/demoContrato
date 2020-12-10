package com.contrato.demo.repositories;

import java.util.List;

import com.contrato.demo.entities.Producto;
import com.contrato.demo.model.CriteriaProducto;
/**
 * Repositorio para las Querys personalizadas de productos
 * @author manuel.barea.velez
 *
 */
public interface ProductoCustomRepository {

	/**
	 * Consulta productos con los criterios informados en el objeto recibido.
	 * @param criteria
	 * @return List<Producto>
	 */
	List<Producto> consultaProductosByCriteria(CriteriaProducto criteria);
	
}
