package cl.praxis.webServiceMbc.modelo.controller.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ProductoDto {

	private Integer idProducto;
        private String codigoProducto;
        private String nombreProducto;
        private Integer stock;
        private Integer precioUnitario;
        private CategoriaDto categoria;
}
