package ro.digitalnation.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tema implements Activitate {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	
	@Override
	public String getDescriere() {
		return "Exercitii practice pentru aplicarea cunostintelor noi";
	}

	@Override
	public String getDurata() {
		return "4-6h";
	}

}
