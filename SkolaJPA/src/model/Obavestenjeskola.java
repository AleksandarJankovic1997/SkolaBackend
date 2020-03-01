package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the obavestenjeskola database table.
 * 
 */
@Entity
@NamedQuery(name="Obavestenjeskola.findAll", query="SELECT o FROM Obavestenjeskola o")
public class Obavestenjeskola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idObavestenje;

	@Temporal(TemporalType.DATE)
	private Date datumPostavljanja;

	private String naslov;

	private String tekst;

	//bi-directional many-to-one association to Predmetskola
	@ManyToOne
	@JoinColumn(name="Predmet_idPredmet")
	private Predmetskola predmetskola;

	public Obavestenjeskola() {
	}

	public int getIdObavestenje() {
		return this.idObavestenje;
	}

	public void setIdObavestenje(int idObavestenje) {
		this.idObavestenje = idObavestenje;
	}

	public Date getDatumPostavljanja() {
		return this.datumPostavljanja;
	}

	public void setDatumPostavljanja(Date datumPostavljanja) {
		this.datumPostavljanja = datumPostavljanja;
	}

	public String getNaslov() {
		return this.naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getTekst() {
		return this.tekst;
	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	public Predmetskola getPredmetskola() {
		return this.predmetskola;
	}

	public void setPredmetskola(Predmetskola predmetskola) {
		this.predmetskola = predmetskola;
	}

}