package cl.praxis.webServiceMbc.modelo.dao;

import java.util.List;
import java.util.Optional;

import cl.praxis.webServiceMbc.modelo.entity.Producto;

public interface ProductoDao {
	
	List<Producto> findAll();
	
	Optional<Producto> findById(Integer id);
}
