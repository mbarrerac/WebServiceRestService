package cl.praxis.webServiceMbc.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import cl.praxis.webServiceMbc.modelo.controller.dto.ProductoDto;
import cl.praxis.webServiceMbc.modelo.controller.dto.CategoriaDto;
import cl.praxis.webServiceMbc.modelo.dao.ProductoDao;
import cl.praxis.webServiceMbc.modelo.entity.Producto;

@Service
public class ProductoServiceImp implements ProductoService {
    
    private final ProductoDao productoDao;
    
    public ProductoServiceImp(ProductoDao productoDao) {
        this.productoDao = productoDao;
    }

    
    

    @Override
    public List<ProductoDto> findAll() {
        List<Producto> productosEntity = productoDao.findAll();

        	List<ProductoDto> productosDto = productosEntity.stream().map(productoTemporal -> {
        	    return ProductoDto.builder()
        	            .idProducto(productoTemporal.getIdProducto() != null ? productoTemporal.getIdProducto() : null)
        	            .codigoProducto(Optional.ofNullable(productoTemporal.getCodigoProducto()).orElse(null))
        	            .nombreProducto(Optional.ofNullable(productoTemporal.getNombreProducto()).orElse(null))
        	            .stock(Optional.ofNullable(productoTemporal.getStock()).orElse(null))
        	            .precioUnitario(Optional.ofNullable(productoTemporal.getPrecioUnitario()).orElse(null))
        	            .categoria(CategoriaDto.builder()
        	           	.idCategoria(productoTemporal.getCategoria().getIdCategoria())
        	            .nombreCategoria(productoTemporal.getCategoria().getNombreCategoria())
                       .build())	            

        	            .build();
        	            
        	}).toList();
        	return productosDto;
	}
    
 //   .categoria(CategoriaDto.builder()
 //   		.idCategoria(productoTemporal.getCategoria().getIdCategoria())
 //   		.nombreCategoria(productoTemporal.getCategoria().getNombreCategoria())
//            .build())



    @Override
    public List<ProductoDto> filtro(String id, String nombre) {
        List<Producto> productosEntregar = new ArrayList<>();
        if (!id.isEmpty() && nombre.isEmpty()) {
            Optional<Producto> optionalProducto = productoDao.findById(Integer.parseInt(id));
            productosEntregar.add(optionalProducto.orElse(new Producto()));
        } else if (id.isEmpty() && !nombre.isEmpty()) {
            List<Producto> productos = productoDao.findAll();
            List<Producto> productosFiltrada = productos.stream().filter(productoTemporal -> 
                productoTemporal.getCategoria().getNombreCategoria().equals(nombre)
            ).toList();
            if (!productosFiltrada.isEmpty()) {
                productosEntregar = productosFiltrada;
            }
        } else if (!id.isEmpty() && !nombre.isEmpty()) {
            List<Producto> productos = productoDao.findAll();
            List<Producto> productoFiltrada = productos.stream().filter(productoTemporal -> 
                productoTemporal.getIdProducto() == Integer.parseInt(id) && 
                productoTemporal.getCategoria().getNombreCategoria().equals(nombre)
            ).toList();
            productosEntregar = productoFiltrada;
        } else {
            productosEntregar = productoDao.findAll();
        }

        List<ProductoDto> productosDto = productosEntregar.stream().map(productoTemporal -> {
            return ProductoDto.builder()
    	            .idProducto(productoTemporal.getIdProducto() != null ? productoTemporal.getIdProducto() : null)
    	            .codigoProducto(Optional.ofNullable(productoTemporal.getCodigoProducto()).orElse(null))
    	            .nombreProducto(Optional.ofNullable(productoTemporal.getNombreProducto()).orElse(null))
    	            .stock(Optional.ofNullable(productoTemporal.getStock()).orElse(null))
    	            .precioUnitario(Optional.ofNullable(productoTemporal.getPrecioUnitario()).orElse(null))
    	            .categoria(CategoriaDto.builder()
    	           	.idCategoria(productoTemporal.getCategoria().getIdCategoria())
    	            .nombreCategoria(productoTemporal.getCategoria().getNombreCategoria())
                            .build())
                    .build();
        }).toList();

        return productosDto;
    }
}
