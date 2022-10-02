package no.hvl.dat107;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "ansatt", name = "Avdeling")
public class Avdeling {
	
	@Id
	private int avdId;
	private String navn;
	
	@OneToOne
	@JoinColumn(name = "sjef", referencedColumnName = "id")
	private Ansatt sjef;
	
	public Avdeling() {
		
	}
	public Avdeling(int avdId, String navn, Ansatt sjef) {
		this.avdId = avdId;
		this.navn = navn;
		this.sjef = sjef;
	}
	public int getAvdId() {
		return avdId;
	}
	public void setAvdId(int avdId) {
		this.avdId = avdId;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public Ansatt getSjef() {
		return sjef;
	}
	public void setSjef(Ansatt sjef) {
		this.sjef = sjef;
	}
	@Override
	public String toString() {
		return "Avdeling [avdId=" + avdId + ", navn=" + navn + ", sjef=" + sjef + "]";
	}
	
	
	
	
}
