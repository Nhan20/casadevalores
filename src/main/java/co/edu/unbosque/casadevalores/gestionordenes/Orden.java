package co.edu.unbosque.casadevalores.gestionordenes;

import jakarta.persistence.*;

@Entity
@Table(name = "ordenes")
public class Orden {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_orden")
	private Long idOrden;

	@Column(name = "tipo_orden", nullable = false, length = 50)
	private String tipoOrden;

	@Column(name = "estado", nullable = false, length = 50)
	private String estado;

	@Column(name = "cantidad_acciones", nullable = false)
	private int cantidadAcciones;

	@Column(name = "valor_accion", nullable = false)
	private Double valorAccion;

	public Orden() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param idOrden
	 * @param tipoOrden
	 * @param estado
	 * @param cantidadAcciones
	 * @param valorAccion
	 */
	public Orden(Long idOrden, String tipoOrden, String estado, int cantidadAcciones, Double valorAccion) {
		super();
		this.idOrden = idOrden;
		this.tipoOrden = tipoOrden;
		this.estado = estado;
		this.cantidadAcciones = cantidadAcciones;
		this.valorAccion = valorAccion;
	}

	/**
	 * @return the idOrden
	 */
	public Long getIdOrden() {
		return idOrden;
	}

	/**
	 * @param idOrden the idOrden to set
	 */
	public void setIdOrden(Long idOrden) {
		this.idOrden = idOrden;
	}

	/**
	 * @return the tipoOrden
	 */
	public String getTipoOrden() {
		return tipoOrden;
	}

	/**
	 * @param tipoOrden the tipoOrden to set
	 */
	public void setTipoOrden(String tipoOrden) {
		this.tipoOrden = tipoOrden;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the cantidadAcciones
	 */
	public int getCantidadAcciones() {
		return cantidadAcciones;
	}

	/**
	 * @param cantidadAcciones the cantidadAcciones to set
	 */
	public void setCantidadAcciones(int cantidadAcciones) {
		this.cantidadAcciones = cantidadAcciones;
	}

	/**
	 * @return the valorAccion
	 */
	public Double getValorAccion() {
		return valorAccion;
	}

	/**
	 * @param valorAccion the valorAccion to set
	 */
	public void setValorAccion(Double valorAccion) {
		this.valorAccion = valorAccion;
	}

}