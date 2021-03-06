package com.contrato.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.contrato.demo.exceptions.ExceptionBase;
import com.contrato.demo.service.IProductoService;
import com.contrato.dto.request.ProductoRequest;
import com.contrato.dto.response.ProductoResponse;
/**
 * Controller que administra las operaciones de los productos
 * @author manuel.barea.velez
 *
 */
@RestController
public class ProductoController {

	
	@Autowired
	private IProductoService service;
	
	/**
	 * Consulta producto mediante los criterios informados.
	 * @param nombre
	 * @param tipo
	 * @param noContrato
	 * @return ResponseEntity<List<ProductoResponse>>
	 * @throws ExceptionBase
	 */
	@GetMapping(path = "productos")
	public ResponseEntity<List<ProductoResponse>> consultarProductos(@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String tipo,
			@RequestParam(required = false) String noContrato) throws ExceptionBase{
		
		return new ResponseEntity<List<ProductoResponse>>(service.consultarProductos(nombre, tipo, noContrato), HttpStatus.OK);
		
	}

	@PostMapping(path = "productos")
	public ResponseEntity<Integer> insertaProducto(@Valid @RequestBody(required = true) ProductoRequest producto) throws ExceptionBase{
		
		return new ResponseEntity<Integer>(service.insertarProducto(producto), HttpStatus.CREATED);
	}
	
	@GetMapping(path = "productos/{idProducto}")
	public ResponseEntity<ProductoResponse> consultarProducto(@PathVariable("idProducto") Integer idProducto) throws ExceptionBase{
		
		
		return new ResponseEntity<ProductoResponse>(service.consultarProducto(idProducto), HttpStatus.OK);
	}
	@DeleteMapping(path = "productos/{idProducto}")
	public ResponseEntity<HttpStatus> eliminaProducto(@PathVariable("idProducto") Integer idProducto) throws ExceptionBase{
		
		service.eliminarProducto(idProducto);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
	@PatchMapping(path = "productos/{idProducto}")
	public  ResponseEntity<HttpStatus> modificarProducto(@PathVariable(name = "idProducto", required = true) Integer idProducto,
			@RequestBody(required = true) ProductoRequest producto) throws ExceptionBase{
		
		service.actualizarProducto(idProducto, producto);
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
	
}
