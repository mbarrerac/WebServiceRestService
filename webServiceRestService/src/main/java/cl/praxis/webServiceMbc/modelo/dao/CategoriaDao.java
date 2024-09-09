package cl.praxis.webServiceMbc.modelo.dao;

import java.util.Optional;



import cl.praxis.webServiceMbc.modelo.entity.Categoria;

public interface CategoriaDao {
	Optional<Categoria> findByNombreCategoria(String nombre);
	
}
