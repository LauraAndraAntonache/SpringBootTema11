package ro.digitalnation.jpa;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curs {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nume, dificultate;
	private String trainerId;
	private ArrayList<String> explorerIds;
	private int cost;
	
	public Curs() {}
	
	public Curs(String nume, String dificultate, String trainer, ArrayList<String> exploreri, int cost) {
		super();
		this.setNume(nume);
		this.setDificultate(dificultate);
		this.trainerId = trainer;
		this.explorerIds = exploreri;
		this.cost = cost;
	}

	public Curs(String nume, String dificultate, int cost) {
		super();
		this.setNume(nume);
		this.setDificultate(dificultate);
		this.cost = cost;
	}

	public String getTrainerId() {
		return trainerId;
	}
	
	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public ArrayList<String> getExplorerIds() {
		return explorerIds;
	}

	public void setExplorerIds(ArrayList<String> exploreri) {
		this.explorerIds = exploreri;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getCost(Persoana p) {
		if(p instanceof Trainer) {
			return 0;
		} else {
			return this.cost;
		}
	}

	public String getDificultate() {
		return dificultate;
	}

	public void setDificultate(String dificultate) {
		this.dificultate = dificultate;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}
	
}
