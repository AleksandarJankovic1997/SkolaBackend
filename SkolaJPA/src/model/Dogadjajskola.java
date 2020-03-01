package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the dogadjajskola database table.
 * 
 */
@Entity
@NamedQuery(name="Dogadjajskola.findAll", query="SELECT d FROM Dogadjajskola d")
public class Dogadjajskola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDogadjaj;

	@Temporal(TemporalType.DATE)
	private Date datum;

	private String nazivDogadjaj;

	private String opisDogadjaj;

	//bi-directional many-to-one association to Predmetskola
	@ManyToOne
	@JoinColumn(name="Predmet_idPredmet")
	private Predmetskola predmetskola;

	public Dogadjajskola() {
	}

	public int getIdDogadjaj() {
		return this.idDogadjaj;
	}

	public void setIdDogadjaj(int idDogadjaj) {
		this.idDogadjaj = idDogadjaj;
	}

	public Date getDatum() {
		return this.datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getNazivDogadjaj() {
		return this.nazivDogadjaj;
	}

	public void setNazivDogadjaj(String nazivDogadjaj) {
		this.nazivDogadjaj = nazivDogadjaj;
	}

	public String getOpisDogadjaj() {
		return this.opisDogadjaj;
	}

	public void setOpisDogadjaj(String opisDogadjaj) {
		this.opisDogadjaj = opisDogadjaj;
	}

	public Predmetskola getPredmetskola() {
		return this.predmetskola;
	}

	public void setPredmetskola(Predmetskola predmetskola) {
		this.predmetskola = predmetskola;
	}

}