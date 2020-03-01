package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the studentskola database table.
 * 
 */
@Entity
@NamedQuery(name="Studentskola.findAll", query="SELECT s FROM Studentskola s")
public class Studentskola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String brojIndeksa;

	@Temporal(TemporalType.DATE)
	private Date datumRodjenja;

	private String imeStudenta;

	private String password;

	private String prezimeStudenta;

	private String smer;

	private String username;

	//bi-directional many-to-many association to Predmetskola
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name="predmetskola_has_studentskola"
		, joinColumns={
			@JoinColumn(name="StudentSkola_brojIndeksa")
			}
		, inverseJoinColumns={
			@JoinColumn(name="PredmetSkola_idPredmet")
			}
		)
	private List<Predmetskola> predmetskolas;

	public Studentskola() {
	}

	public String getBrojIndeksa() {
		return this.brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public Date getDatumRodjenja() {
		return this.datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getImeStudenta() {
		return this.imeStudenta;
	}

	public void setImeStudenta(String imeStudenta) {
		this.imeStudenta = imeStudenta;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezimeStudenta() {
		return this.prezimeStudenta;
	}

	public void setPrezimeStudenta(String prezimeStudenta) {
		this.prezimeStudenta = prezimeStudenta;
	}

	public String getSmer() {
		return this.smer;
	}

	public void setSmer(String smer) {
		this.smer = smer;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Predmetskola> getPredmetskolas() {
		return this.predmetskolas;
	}

	public void setPredmetskolas(List<Predmetskola> predmetskolas) {
		this.predmetskolas = predmetskolas;
	}

}