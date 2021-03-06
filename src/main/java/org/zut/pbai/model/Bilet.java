package org.zut.pbai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Bilet generated by hbm2java
 */
@Entity
@Table(name = "bilet", catalog = "pbai2016db")
public class Bilet implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idbilet;
	private Film film;
	private Seans seans;
	private Uzytkownik uzytkownik;
	private String stan;
	private String miejsce;
	private String cena;
	private String typ;

	public Bilet() {
	}

	public Bilet(int idbilet, Film film, Seans seans, Uzytkownik uzytkownik) {
		this.idbilet = idbilet;
		this.film = film;
		this.seans = seans;
		this.uzytkownik = uzytkownik;
	}

	public Bilet(int idbilet, Film film, Seans seans, Uzytkownik uzytkownik, String stan,
			String miejsce, String cena, String typ) {
		this.idbilet = idbilet;
		this.film = film;
		this.seans = seans;
		this.uzytkownik = uzytkownik;
		this.stan = stan;
		this.miejsce = miejsce;
		this.cena = cena;
		this.typ = typ;
	}

	@Id

	@Column(name = "idbilet", unique = true, nullable = false)
	public int getIdbilet() {
		return this.idbilet;
	}

	public void setIdbilet(int idbilet) {
		this.idbilet = idbilet;
	}


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idfilm", nullable = false)
	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idseans", nullable = false)
	public Seans getSeans() {
		return this.seans;
	}

	public void setSeans(Seans seans) {
		this.seans = seans;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idklient", nullable = false)
	public Uzytkownik getUzytkownik() {
		return this.uzytkownik;
	}

	public void setUzytkownik(Uzytkownik uzytkownik) {
		this.uzytkownik = uzytkownik;
	}

	@Column(name = "stan", length = 45)
	public String getStan() {
		return this.stan;
	}

	public void setStan(String stan) {
		this.stan = stan;
	}

	@Column(name = "miejsce", length = 45)
	public String getMiejsce() {
		return this.miejsce;
	}

	public void setMiejsce(String miejsce) {
		this.miejsce = miejsce;
	}

	@Column(name = "cena", length = 45)
	public String getCena() {
		return this.cena;
	}

	public void setCena(String cena) {
		this.cena = cena;
	}

	@Column(name = "typ", length = 45)
	public String getTyp() {
		return this.typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}

}
