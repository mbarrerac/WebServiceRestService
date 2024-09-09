package cl.praxis.webServiceMbc.modelo.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.praxis.webServiceMbc.modelo.entity.Categoria;



@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer>{

	Optional<Categoria> findByNombreCategoria(String nombre);
	
}