package no.hvl.dat107;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "ansatt", name = "Prosjekt")
public class Prosjekt {
	
	@Id
	private int prosjektId;
	private String navn;
	private String beskrivelse;
	
	public Prosjekt() {
		
	}
	
	public Prosjekt(int prosjektId, String navn, String beskrivelse) {
		this.prosjektId = prosjektId;
		this.navn = navn;
		this.beskrivelse = beskrivelse;
	}

	public int getProsjektId() {
		return prosjektId;
	}

	public void setProsjektId(int prosjektId) {
		this.prosjektId = prosjektId;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	@Override
	public String toString() {
		return "Prosjekt [prosjektId=" + prosjektId + ", navn=" + navn + ", beskrivelse=" + beskrivelse + "]";
	}
	
	
}
