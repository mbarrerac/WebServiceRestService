package cl.praxis.webServiceMbc.modelo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "productos")
public class Producto {

	@Id
	@Column(name = "id_producto")
	private Integer idProducto;
	@Column(name = "codigo_producto")
	private String codigoProducto;
    @Column(name = "nombre_producto")
	private String nombreProducto;
	@Column(name = "stock")
	private Integer stock;
	@Column(name = "precio_unitario")
	private Integer precioUnitario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
}
