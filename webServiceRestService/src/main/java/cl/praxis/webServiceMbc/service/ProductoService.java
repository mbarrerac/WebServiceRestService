package cl.praxis.webServiceMbc.service;

import java.util.List;

import cl.praxis.webServiceMbc.modelo.controller.dto.ProductoDto;
public interface ProductoService {
    List<ProductoDto> findAll();
	
	List<ProductoDto> filtro(String id, String nombre);

}
