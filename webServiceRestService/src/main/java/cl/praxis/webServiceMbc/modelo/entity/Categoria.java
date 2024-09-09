package cl.praxis.webServiceMbc.modelo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "categorias")
public class Categoria {
	@Id
	@Column(name = "id_categoria")
	private Integer idCategoria;
	@Column(name = "nombre_categoria")
	private String nombreCategoria;
	
}