package com.contrato.demo.service;

import java.util.List;

import com.contrato.demo.exceptions.ExceptionBase;
import com.contrato.dto.request.ProductoRequest;
import com.contrato.dto.response.ProductoResponse;

public interface IProductoService {

	Integer insertarProducto(ProductoRequest request) throws ExceptionBase;
	
	ProductoResponse consultarProducto(Integer idProducto)throws ExceptionBase;
	
	List<ProductoResponse> consultarProductos(String direccion, String valor)throws ExceptionBase;
	
	void actualizarProducto(Integer idProducto, ProductoRequest request)throws ExceptionBase;
	
	void eliminarProducto(Integer idProducto)throws ExceptionBase;
}
