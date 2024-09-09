package cl.praxis.webServiceMbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cl.praxis.webServiceMbc.WebServiceMbcApplication;

import cl.praxis.webServiceMbc.modelo.repository.ProductoRepository;
//import cl.praxis.webServiceMbc.modelo.dao.CategoriaDaoImp;
//import cl.praxis.webServiceMbc.modelo.dao.ProductoDaoImp;
import cl.praxis.webServiceMbc.modelo.repository.CategoriaRepository;

@SpringBootApplication
public class WebServiceMbcApplication {

	//public static void main(String[] args) {
	//	SpringApplication.run(WebServiceMbcApplication.class, args);
	//}
    public static void main(String[] args) {
      //  SpringApplication.run(WebServiceApplication.class, args);
        
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class);
        //esto es para la primera prueba
        ProductoRepository productoRepo = acac.getBean(ProductoRepository.class);
        CategoriaRepository categoriaRepo = acac.getBean(CategoriaRepository.class);
        //esto es para la segunda prueba
       // ProductoDaoImp productoRepo = acac.getBean(ProductoDaoImp.class);
      //  CategoriaDaoImp categoriaRepo = acac.getBean(CategoriaDaoImp.class);
        
       System.out.println(productoRepo.findAll());
       System.out.println(categoriaRepo.findByNombreCategoria("platos"));
    }
}
