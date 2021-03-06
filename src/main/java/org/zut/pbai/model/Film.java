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
 * Film generated by hbm2java
 */
@Entity
@Table(name = "film", catalog = "pbai2016db")
public class Film implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Integer idfilm;
	private String tytul;
	private String tytulOryginal;
	private String premiera;
	private Integer wiek;
	private String czasTrwania;
	private String produkcja;
	private String gatunek;
	private String wersja;
	private Integer odLat;
	private String opis;
	private String aktorzy;
	private Set<Seans> seanses = new HashSet<Seans>(0);
	private Set<Bilet> bilets = new HashSet<Bilet>(0);

	public Film() {
	}

	public Film(String tytul, String tytulOryginal, String premiera, Integer wiek, String czasTrwania, String produkcja,
			String gatunek, String wersja, Integer odLat, String opis, String aktorzy, Set<Seans> seanses,
			Set<Bilet> bilets) {
		this.tytul = tytul;
		this.tytulOryginal = tytulOryginal;
		this.premiera = premiera;
		this.wiek = wiek;
		this.czasTrwania = czasTrwania;
		this.produkcja = produkcja;
		this.gatunek = gatunek;
		this.wersja = wersja;
		this.odLat = odLat;
		this.opis = opis;
		this.aktorzy = aktorzy;
		this.seanses = seanses;
		this.bilets = bilets;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idfilm", unique = true, nullable = false)
	public Integer getIdfilm() {
		return this.idfilm;
	}

	public void setIdfilm(Integer idfilm) {
		this.idfilm = idfilm;
	}

	@Column(name = "tytul", length = 45)
	public String getTytul() {
		return this.tytul;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	@Column(name = "tytul_oryginal", length = 45)
	public String getTytulOryginal() {
		return this.tytulOryginal;
	}

	public void setTytulOryginal(String tytulOryginal) {
		this.tytulOryginal = tytulOryginal;
	}

	@Column(name = "premiera", length = 45)
	public String getPremiera() {
		return this.premiera;
	}

	public void setPremiera(String premiera) {
		this.premiera = premiera;
	}

	@Column(name = "wiek")
	public Integer getWiek() {
		return this.wiek;
	}

	public void setWiek(Integer wiek) {
		this.wiek = wiek;
	}

	@Column(name = "czas_trwania", length = 45)
	public String getCzasTrwania() {
		return this.czasTrwania;
	}

	public void setCzasTrwania(String czasTrwania) {
		this.czasTrwania = czasTrwania;
	}

	@Column(name = "produkcja", length = 45)
	public String getProdukcja() {
		return this.produkcja;
	}

	public void setProdukcja(String produkcja) {
		this.produkcja = produkcja;
	}

	@Column(name = "gatunek", length = 45)
	public String getGatunek() {
		return this.gatunek;
	}

	public void setGatunek(String gatunek) {
		this.gatunek = gatunek;
	}

	@Column(name = "wersja", length = 45)
	public String getWersja() {
		return this.wersja;
	}

	public void setWersja(String wersja) {
		this.wersja = wersja;
	}

	@Column(name = "od_lat")
	public Integer getOdLat() {
		return this.odLat;
	}

	public void setOdLat(Integer odLat) {
		this.odLat = odLat;
	}

	@Column(name = "opis", length = 45)
	public String getOpis() {
		return this.opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@Column(name = "aktorzy", length = 45)
	public String getAktorzy() {
		return this.aktorzy;
	}

	public void setAktorzy(String aktorzy) {
		this.aktorzy = aktorzy;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "film")
	public Set<Seans> getSeanses() {
		return this.seanses;
	}

	public void setSeanses(Set<Seans> seanses) {
		this.seanses = seanses;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "film")
	public Set<Bilet> getBilets() {
		return this.bilets;
	}

	public void setBilets(Set<Bilet> bilets) {
		this.bilets = bilets;
	}

}
