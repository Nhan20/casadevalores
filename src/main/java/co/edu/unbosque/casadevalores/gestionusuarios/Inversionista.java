package co.edu.unbosque.casadevalores.gestionusuarios;

import jakarta.persistence.*;

@Entity
@Table(name = "inversionista")
public class Inversionista {

	@Id
	@Column(name = "nickname")
	private String nickname;

	@Column(name = "password", nullable = false, length = 50)
	private String password;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@Column(name = "subscription", nullable = false, length = 50)
	private String subscription;

	@Column(name = "id_portafolio", nullable = false, length = 50)
	private int id_portafolio;

	@Column(name = "correo", nullable = false, length = 50)
	private int correo;

	public Inversionista() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param nickname
	 * @param password
	 * @param name
	 * @param subscription
	 * @param id_portafolio
	 */
	public Inversionista(String nickname, String password, String name, String subscription, int id_portafolio) {
		super();
		this.nickname = nickname;
		this.password = password;
		this.name = name;
		this.subscription = subscription;
		this.id_portafolio = id_portafolio;
	}

	/**
	 * @param nickname
	 * @param password
	 */
	public Inversionista(String nickname, String password) {
		super();
		this.nickname = nickname;
		this.password = password;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the subscription
	 */
	public String getSubscription() {
		return subscription;
	}

	/**
	 * @param subscription the subscription to set
	 */
	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}

	/**
	 * @return the id_portafolio
	 */
	public int getId_portafolio() {
		return id_portafolio;
	}

	/**
	 * @param id_portafolio the id_portafolio to set
	 */
	public void setId_portafolio(int id_portafolio) {
		this.id_portafolio = id_portafolio;
	}

	/**
	 * @return the correo
	 */
	public int getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(int correo) {
		this.correo = correo;
	}

}
