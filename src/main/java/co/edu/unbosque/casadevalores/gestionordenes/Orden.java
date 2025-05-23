package co.edu.unbosque.casadevalores.gestionordenes;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orden {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idorden")
	private Long idorden;

	@Column(name = "tipoorden", nullable = false, length = 50)
	private String tipoorden;

	@Column(name = "estado", nullable = false, length = 50)
	private String estado;

	@Column(name = "cantidadacciones", nullable = false)
	private int cantidadacciones;

	@Column(name = "valoraccion", nullable = false)
	private Double valoraccion;

	public Orden() {
		// TODO Auto-generated constructor stub
	}

	public Orden(Long id_orden, String tipoorden, String estado, int cantidadacciones, Double valoraccion) {
		super();
		this.idorden = id_orden;
		this.tipoorden = tipoorden;
		this.estado = estado;
		this.cantidadacciones = cantidadacciones;
		this.valoraccion = valoraccion;
	}

	public Long getId_orden() {
		return idorden;
	}

	public void setId_orden(Long id_orden) {
		this.idorden = id_orden;
	}

	public String getTipoorden() {
		return tipoorden;
	}

	public void setTipoorden(String tipoorden) {
		this.tipoorden = tipoorden;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCantidadacciones() {
		return cantidadacciones;
	}

	public void setCantidadacciones(int cantidadacciones) {
		this.cantidadacciones = cantidadacciones;
	}

	public Double getValoraccion() {
		return valoraccion;
	}

	public void setValoraccion(Double valoraccion) {
		this.valoraccion = valoraccion;
	}

}