package cl.praxis.webServiceMbc.modelo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.praxis.webServiceMbc.modelo.controller.dto.ProductoDto;
import cl.praxis.webServiceMbc.service.ProductoService;

@Controller
public class ProductoController {
	
	ProductoService productoService;
	
	ProductoController(ProductoService productoService){
		this.productoService = productoService;
	}

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		List<ProductoDto> productos = productoService.findAll();
		System.out.println("PRINCIPIO");
		System.out.println(productoService.findAll());
		System.out.println("FIN");
		mav.addObject("productos", productos);
		mav.setViewName("/index");
		return mav;
	}
	
	@PostMapping("/filtro")
	public String filtro(Model model, @RequestParam String txtIdProducto, @RequestParam String txtNombreCategoria) {
		List<ProductoDto> productos = productoService.filtro(txtIdProducto, txtNombreCategoria);
		model.addAttribute("productos", productos);
		return "index";
	}
	
}
