package no.hvl.dat107;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "ansatt", name = "Ansatt")
public class Ansatt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@OneToMany(mappedBy = "ansatt")
	private int id;
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private LocalDate ansdato;
	private String stilling;
	private Integer mndlonn;
	private String avdeling;
	private String prosjekt;
	
	
	public Ansatt() {
		
	}
	
	public Ansatt(int id, String brukernavn, String fornavn, String etternavn, LocalDate ansdato, String stilling, Integer mndlonn, 
					String avdeling, String prosjekt) {
		this.id = id;
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansdato = ansdato;
		this.stilling = stilling;
		this.mndlonn = mndlonn;
		this.avdeling = avdeling;
		this.prosjekt = prosjekt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public LocalDate getAnsdato() {
		return ansdato;
	}

	public void setAnsdato(LocalDate ansdato) {
		this.ansdato = ansdato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public Integer getMndlonn() {
		return mndlonn;
	}

	public void setMndlonn(Integer mndlonn) {
		this.mndlonn = mndlonn;
	}

	public String getAvdeling() {
		return avdeling;
	}

	public void setAvdeling(String avdeling) {
		this.avdeling = avdeling;
	}

	public String getProsjekt() {
		return prosjekt;
	}

	public void setProsjekt(String prosjekt) {
		this.prosjekt = prosjekt;
	}

	@Override
	public String toString() {
		return "Ansatt [id=" + id + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn=" + etternavn
				+ ", ansdato=" + ansdato + ", stilling=" + stilling + ", mndlonn=" + mndlonn + ", avdeling=" + avdeling
				+ ", prosjekt=" + prosjekt + "]";
	}

	
	
	
}
