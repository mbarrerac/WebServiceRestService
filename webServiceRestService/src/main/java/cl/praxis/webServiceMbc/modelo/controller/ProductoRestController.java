package cl.praxis.webServiceMbc.modelo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.praxis.webServiceMbc.service.ProductoService;
import cl.praxis.webServiceMbc.modelo.controller.dto.ProductoDto;
@RestController
@RequestMapping("/productos")
public class ProductoRestController {

    private final ProductoService productoService;

    @Autowired
    public ProductoRestController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        // Utilizar para realizar pruebas con Postman
        // System.out.println("pasando por raíz");

        List<ProductoDto> productos = productoService.findAll();

        // Verifica si la lista de productos está vacía
        if (productos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        // Retorna un código de respuesta 200 (OK) junto con la lista de productos
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/filtro")
    public ResponseEntity<?> findByIdProductoAndRutCategoria(@RequestParam(required = false) String rutCategoria, @RequestParam(required = false) String idProducto) {
    	//utilzar para realizar pruebas con postman
        System.out.println(rutCategoria);
        System.out.println(idProducto);
    	
    	if (idProducto==null) {
    		idProducto="";
    	}
    	if (rutCategoria==null) {
    		rutCategoria="";
    	}
    	   System.out.println(rutCategoria);
           System.out.println(idProducto);
    	 List<ProductoDto> productos = productoService.filtro(idProducto, rutCategoria);
         if (productos.isEmpty()) {
             return ResponseEntity.noContent().build();
         }

         // Retorna un código de respuesta 200 (OK) junto con la lista de productos
         return ResponseEntity.ok(productos);
    }
}