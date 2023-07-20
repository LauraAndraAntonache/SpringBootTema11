package ro.digitalnation.jpa;

import javax.persistence.Entity;

@Entity
public class Explorer extends Persoana {
	public Explorer() {}
	public Explorer(String nume, String prenume, String oras, Integer varsta, boolean casatorita) {
		super(nume, prenume, oras, varsta, casatorita);
	}

	@Override
	public String obtineIdentificator() {
		// TODO Auto-generated method stub
		return "explorer_" + super.obtineIdentificator();
	}

	@Override
	public String getResponsabilitati() {
		return "Parcurgerea materialelor, rezolvarea temelor, participarea la activitati";
	}

}
	