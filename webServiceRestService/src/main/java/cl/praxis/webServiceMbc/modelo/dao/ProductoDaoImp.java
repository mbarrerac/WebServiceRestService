package cl.praxis.webServiceMbc.modelo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import cl.praxis.webServiceMbc.modelo.entity.Producto;
import cl.praxis.webServiceMbc.modelo.repository.ProductoRepository;

@Component
public class ProductoDaoImp implements ProductoDao{

	ProductoRepository productoRepository;
	
	ProductoDaoImp(ProductoRepository productoRepository){
		this.productoRepository = productoRepository;
	}
	
	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return (List<Producto>) productoRepository.findAll();
	}

	@Override
	public Optional<Producto> findById(Integer id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id);
	}

}