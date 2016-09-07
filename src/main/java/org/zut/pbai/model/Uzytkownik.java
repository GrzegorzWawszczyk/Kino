package org.zut.pbai.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Uzytkownik generated by hbm2java
 */
@Entity
@Table(name = "uzytkownik", catalog = "pbai2016db")
public class Uzytkownik implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idklient;
	private String haslo;
	private String imie;
	private String nazwisko;
	private String email;
	private Integer tel;
	private String pesel;
	private String rola;
	private Set<Bilet> bilets = new HashSet<Bilet>(0);

	public Uzytkownik() {
	}

	public Uzytkownik(String haslo, String imie, String nazwisko, String email, Integer tel, String pesel, String rola,
			Set<Bilet> bilets) {
		this.haslo = haslo;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.email = email;
		this.tel = tel;
		this.pesel = pesel;
		this.rola = rola;
		this.bilets = bilets;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idklient", unique = true, nullable = false)
	public Integer getIdklient() {
		return this.idklient;
	}

	public void setIdklient(Integer idklient) {
		this.idklient = idklient;
	}

	@Column(name = "haslo", length = 45)
	public String getHaslo() {
		return this.haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	@Column(name = "imie", length = 45)
	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	@Column(name = "nazwisko", length = 45)
	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	@Column(name = "email", length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "tel")
	public Integer getTel() {
		return this.tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	@Column(name = "pesel", length = 45)
	public String getPesel() {
		return this.pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	@Column(name = "rola", length = 45)
	public String getRola() {
		return this.rola;
	}

	public void setRola(String rola) {
		this.rola = rola;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "uzytkownik")
	public Set<Bilet> getBilets() {
		return this.bilets;
	}

	public void setBilets(Set<Bilet> bilets) {
		this.bilets = bilets;
	}

}
