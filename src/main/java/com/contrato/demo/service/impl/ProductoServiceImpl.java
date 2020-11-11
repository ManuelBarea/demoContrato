package com.contrato.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.contrato.demo.entities.Producto;
import com.contrato.demo.exceptions.ExceptionBase;
import com.contrato.demo.models.ProductoRequest;
import com.contrato.demo.models.ProductoResponse;
import com.contrato.demo.repositories.ProductoRepository;
import com.contrato.demo.service.IProductoService;
import com.contrato.demo.utils.Mappers;
@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private ProductoRepository repoProducto;

	@Override
	public Integer insertarProducto(ProductoRequest request) throws ExceptionBase {

		Producto entity = Mappers.mapperProductoRequestToProducto(request);
		repoProducto.save(entity);
		return entity.getIdProducto();
	}

	@Override
	public ProductoResponse consultarProducto(Integer idProducto) throws ExceptionBase {

		Optional<Producto> entity = repoProducto.findById(idProducto);
		ProductoResponse response = null;
		if (entity.isPresent()) {
			response = Mappers.mapperProductoToProductoResponse(entity.get());
		} else {
			throw new ExceptionBase("No existe producto con el id indicado", HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@Override
	public List<ProductoResponse> consultarProductos(String direccion, String valor) throws ExceptionBase {
		List<ProductoResponse> response = null;
		List<Producto> entitiesProducto = repoProducto.findAll();
		if (!CollectionUtils.isEmpty(entitiesProducto)) {
			response = new ArrayList<ProductoResponse>();
			for (Producto entity : entitiesProducto) {
				ProductoResponse producto = Mappers.mapperProductoToProductoResponse(entity);
				response.add(producto);
			}
		} else {
			throw new ExceptionBase("No existen productos coin los criterios indicados", HttpStatus.NOT_FOUND);
		}

		return response;
	}

	@Override
	public void actualizarProducto(Integer idProducto, ProductoRequest request) throws ExceptionBase {
		if (repoProducto.existsById(idProducto)) {
			Optional<Producto> entity = repoProducto.findById(idProducto);
			mapperNoNulosProductoRequest(entity.get(), request);
			repoProducto.save(entity.get());
		} else {
			throw new ExceptionBase("No existe producto con el id indicado", HttpStatus.NOT_FOUND);
		}

	}

	private void mapperNoNulosProductoRequest(Producto entity, ProductoRequest request) {
		if (!StringUtils.isEmpty(request.getDireccion())) {
			entity.setDireccion(request.getDireccion());
		}
		if (!StringUtils.isEmpty(request.getValor())) {
			entity.setValor(request.getValor());
		}
	}

	@Override
	public void eliminarProducto(Integer idProducto) throws ExceptionBase {
		if (repoProducto.existsById(idProducto)) {
			repoProducto.deleteById(idProducto);
		} else {
			throw new ExceptionBase("No existe producto con el id indicado", HttpStatus.NOT_FOUND);
		}
	}

}
