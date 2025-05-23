package co.edu.unbosque.casadevalores.gestionusuarios;

import jakarta.persistence.*;

@Entity
@Table(name = "inversionista")
public class Inversionista {

	@Id
	@Column(name = "nickname")
	private String nickname;

	@Column(name = "password", length = 50)
	private String password;

	@Column(name = "name", length = 50)
	private String name;
	
	@Column(name = "comisionista", length = 50)
	private String comisionista;

	@Column(name = "subscription", length = 50)
	private String subscription;

	@Column(name = "id_portafolio", length = 50)
	private int id_portafolio;

	@Column(name = "correo", length = 50)
	private String correo;

	public Inversionista() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Inversionista(String nickname, String password, String name, String comisionista, String correo) {
		super();
		this.nickname = nickname;
		this.password = password;
		this.name = name;
		this.comisionista = comisionista;
		this.correo = correo;
	}



	public Inversionista(String nickname, String password, String name, String subscription, int id_portafolio,
			String correo) {
		super();
		this.nickname = nickname;
		this.password = password;
		this.name = name;
		this.subscription = subscription;
		this.id_portafolio = id_portafolio;
		this.correo = correo;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
