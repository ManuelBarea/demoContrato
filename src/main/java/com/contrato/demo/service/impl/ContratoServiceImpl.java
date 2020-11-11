package com.contrato.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.contrato.demo.entities.Contrato;
import com.contrato.demo.exceptions.ExceptionBase;
import com.contrato.demo.models.ContratoRequest;
import com.contrato.demo.models.ContratoResponse;
import com.contrato.demo.repositories.ContratoRepository;
import com.contrato.demo.repositories.PersonaRepository;
import com.contrato.demo.repositories.ProductoRepository;
import com.contrato.demo.service.IContratoService;
import com.contrato.demo.utils.Mappers;
@Service
public class ContratoServiceImpl implements IContratoService{

	@Autowired
	private ContratoRepository repo;
	
	@Autowired
	private PersonaRepository repoPersona;
	
	@Autowired
	private ProductoRepository repoProducto;
	
	@Override
	public List<ContratoResponse> consultarContratos()throws ExceptionBase {
		List<Contrato> listaContratos = repo.findAll();
		List<ContratoResponse> response = null;
		if(!CollectionUtils.isEmpty(listaContratos)) {
			response = new ArrayList<ContratoResponse>();
			for(Contrato contrato : listaContratos) {
				response.add(Mappers.mappearControToContratoResponse(contrato));
			}
		}else {
			throw new ExceptionBase("No existen contratos", HttpStatus.NOT_FOUND);
		}
		
		return response;
	}

	@Override
	public Integer insertaContrato(ContratoRequest contrato)throws ExceptionBase {
			
		Contrato entity = null;
		if(repoPersona.existsById(contrato.getIdArrendador()) && repoPersona.existsById(contrato.getIdContratante())) {
			if(repoProducto.existsById(contrato.getIdProducto())) {
				entity= Mappers.mapeoContratoRequestToContrato(contrato);
			}else {
				throw new ExceptionBase("No existe el producto indicado", HttpStatus.BAD_REQUEST);
			}
		}else {
			throw new ExceptionBase("Necesita dar de alta a arrendador y contratante antes de continuar.", HttpStatus.BAD_REQUEST);
		}
		
		repo.save(entity);
		
		return entity.getIdContrato();
	}
	
	

	@Override
	public void eliminaContrato(Integer idContrato)throws ExceptionBase {
		
		repo.deleteById(idContrato);
		
	}

	@Override
	public void modificarContrato(Integer idContrato, ContratoRequest contrato)throws ExceptionBase {
		
		Optional<Contrato> entity = repo.findById(idContrato);
		if(entity.isPresent()) {
			mapearNoNulosContrato(entity.get(), contrato);
			repo.save(entity.get());
		}else {
			throw new ExceptionBase("No existe el contrato indicado", HttpStatus.BAD_REQUEST);
		}
		
		
	}

	private void mapearNoNulosContrato(Contrato entity, ContratoRequest contrato)throws ExceptionBase {
		if(contrato.getIdArrendador() != null) {
			if(repoPersona.existsById(contrato.getIdArrendador())) {
				entity.getArrendador().setDni(contrato.getIdArrendador());
			}else {
				throw new ExceptionBase("El arrendador indicado no está dado de alta en el sistema.", HttpStatus.BAD_REQUEST);
			}
		}else {
			
		}
		if(contrato.getIdContratante() != null) {
			if(repoPersona.existsById(contrato.getIdContratante())) {
				entity.getContratante().setDni(contrato.getIdContratante());
			}else {
				throw new ExceptionBase("El contratante indicado no está dado de alta en el sistema.", HttpStatus.BAD_REQUEST);
			}
		}else {
			
		}
		
		if(contrato.getIdProducto() != null) {
			if(repoProducto.existsById(contrato.getIdProducto())) {
				entity.getIdProducto().setIdProducto(contrato.getIdProducto());
			}else {
				throw new ExceptionBase("El producto indicado no está dado de alta en el sistema.", HttpStatus.BAD_REQUEST);
			}
		}
		
	}

	@Override
	public ContratoResponse consultarContrato(Integer idContrato) throws ExceptionBase {
		Optional<Contrato> entity = repo.findById(idContrato);
		ContratoResponse response = null;
		if(entity.isPresent()) {
			response = Mappers.mappearControToContratoResponse(entity.get());
		}else {
			throw new ExceptionBase("No existe contrato con el id indicado", HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
	
	

}
