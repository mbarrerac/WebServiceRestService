package cl.praxis.webServiceMbc.modelo.dao;

import java.util.Optional;

import org.springframework.stereotype.Component;

import cl.praxis.webServiceMbc.modelo.entity.Categoria;
import cl.praxis.webServiceMbc.modelo.entity.Producto;
import cl.praxis.webServiceMbc.modelo.repository.CategoriaRepository;

@Component
public class CategoriaDaoImp implements CategoriaDao{

	CategoriaRepository categoriaRepository;
	
	CategoriaDaoImp(CategoriaRepository categoriaRepository){
		this.categoriaRepository = categoriaRepository;
	}
	
	@Override
	public Optional<Categoria> findByNombreCategoria(String nombre) {
		// TODO Auto-generated method stub
		return categoriaRepository.findByNombreCategoria(nombre);
	}

}
