package cl.praxis.webServiceMbc.modelo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.praxis.webServiceMbc.modelo.entity.Producto;



@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer>{
	
}
