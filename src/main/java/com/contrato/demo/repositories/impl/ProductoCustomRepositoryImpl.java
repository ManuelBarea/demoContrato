package com.contrato.demo.repositories.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.contrato.demo.entities.Producto;
import com.contrato.demo.model.CriteriaProducto;
import com.contrato.demo.repositories.ProductoCustomRepository;
import com.contrato.demo.utils.Constants;

/**
 * Clase que implementa a la interfaz ProductoCustomRepository
 * @author manuel.barea.velez 
 *
 */
public class ProductoCustomRepositoryImpl implements ProductoCustomRepository{

	@Autowired
	EntityManager em;
	
	@Override
	public List<Producto> consultaProductosByCriteria(CriteriaProducto criteria) {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Producto> cq = cb.createQuery(Producto.class);
		
		Root<Producto> producto = cq.from(Producto.class);
		
		List<Predicate> predicates = new ArrayList<>();
		
		if(!StringUtils.isEmpty(criteria.getNoContrato())) {
			predicates.add(cb.like(producto.get(Constants.TABLE_PRODUCTO_CAMP_NOCONTRATO), criteria.getNoContrato()));
		}
		if(!StringUtils.isEmpty(criteria.getNombre())) {
			predicates.add(cb.like(producto.get(Constants.TABLE_PRODUCTO_CAMP_NOMBRE), criteria.getNombre()));
		}
		if(!StringUtils.isEmpty(criteria.getTipo())) {
			predicates.add(cb.like(producto.get(Constants.TABLE_PRODUCTO_CAMP_TIPO), criteria.getTipo()));
		}
		
		cq.where(predicates.toArray(new Predicate[0]));
	      
	     List<Producto> productos = em.createQuery(cq).getResultList();
		
		return productos;
	}

}
