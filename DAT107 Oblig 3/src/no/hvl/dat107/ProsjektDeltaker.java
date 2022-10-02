package no.hvl.dat107;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "ansatt", name = "prosjektdeltaker")
public class ProsjektDeltaker {
	
	@Id
	private int prosjektDelId;
	
	@ManyToOne
	@JoinColumn(name = "id", referencedColumnName = "id")
	private Ansatt id;
	
	@ManyToOne
	@JoinColumn(name = "prosjektId", referencedColumnName = "prosjektId")
	private Prosjekt prosjektId;
	
	private String rolle;
	private int timer;
	
	public ProsjektDeltaker() {
		
	}
	
	public ProsjektDeltaker(Ansatt id, Prosjekt prosjektId, String rolle, int timer) {
		this.id = id;
		this.prosjektId = prosjektId;
		this.rolle = rolle;
		this.timer = timer;
	}

	public int getProsjektDelId() {
		return prosjektDelId;
	}

	public void setProsjektDelId(int prosjektDelId) {
		this.prosjektDelId = prosjektDelId;
	}

	public Ansatt getId() {
		return id;
	}

	public void setId(Ansatt id) {
		this.id = id;
	}

	public Prosjekt getProsjektId() {
		return prosjektId;
	}

	public void setProsjektId(Prosjekt prosjektId) {
		this.prosjektId = prosjektId;
	}

	public String getRolle() {
		return rolle;
	}

	public void setRolle(String rolle) {
		this.rolle = rolle;
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	@Override
	public String toString() {
		return "ProsjektDeltaker [prosjektDelId=" + prosjektDelId + ", id=" + id + ", prosjektId=" + prosjektId
				+ ", rolle=" + rolle + ", timer=" + timer + "]";
	}
	
	
}
