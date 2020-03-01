package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ispitnopitanjeskola database table.
 * 
 */
@Entity
@NamedQuery(name="Ispitnopitanjeskola.findAll", query="SELECT i FROM Ispitnopitanjeskola i")
public class Ispitnopitanjeskola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIspitnoPitanje;

	private String pitanje;

	//bi-directional many-to-one association to Predmetskola
	@ManyToOne
	@JoinColumn(name="Predmet_idPredmet")
	private Predmetskola predmetskola;

	public Ispitnopitanjeskola() {
	}

	public int getIdIspitnoPitanje() {
		return this.idIspitnoPitanje;
	}

	public void setIdIspitnoPitanje(int idIspitnoPitanje) {
		this.idIspitnoPitanje = idIspitnoPitanje;
	}

	public String getPitanje() {
		return this.pitanje;
	}

	public void setPitanje(String pitanje) {
		this.pitanje = pitanje;
	}

	public Predmetskola getPredmetskola() {
		return this.predmetskola;
	}

	public void setPredmetskola(Predmetskola predmetskola) {
		this.predmetskola = predmetskola;
	}

}