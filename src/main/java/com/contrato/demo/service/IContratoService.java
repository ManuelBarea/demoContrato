package com.contrato.demo.service;

import java.util.List;

import com.contrato.demo.exceptions.ExceptionBase;
import com.contrato.dto.request.ContratoRequest;
import com.contrato.dto.response.ContratoResponse;

public interface IContratoService {

	List<ContratoResponse> consultarContratos()throws ExceptionBase;
	
	ContratoResponse consultarContrato(Integer idContrato) throws ExceptionBase;
	
	Integer insertaContrato(ContratoRequest contrato) throws ExceptionBase;
	
	void eliminaContrato(Integer idContrato) throws ExceptionBase;
	
	void modificarContrato(Integer idContrato, ContratoRequest contrato) throws ExceptionBase;
}
