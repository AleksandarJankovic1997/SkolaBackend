package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the predmetskola database table.
 * 
 */
@Entity
@NamedQuery(name="Predmetskola.findAll", query="SELECT p FROM Predmetskola p")
public class Predmetskola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPredmet;

	private int espbPoeni;

	private String imePredmeta;

	private String opisPredmeta;

	//bi-directional many-to-one association to Dogadjajskola
	@OneToMany(mappedBy="predmetskola")
	private List<Dogadjajskola> dogadjajskolas;

	//bi-directional many-to-one association to Ispitnopitanjeskola
	@OneToMany(mappedBy="predmetskola")
	private List<Ispitnopitanjeskola> ispitnopitanjeskolas;

	//bi-directional many-to-one association to Obavestenjeskola
	@OneToMany(mappedBy="predmetskola")
	private List<Obavestenjeskola> obavestenjeskolas;

	//bi-directional many-to-one association to Profesorskola
	@ManyToOne
	@JoinColumn(name="Profesor_idProfesor")
	private Profesorskola profesorskola;

	//bi-directional many-to-many association to Studentskola
	@ManyToMany(mappedBy="predmetskolas")
	private List<Studentskola> studentskolas;

	public Predmetskola() {
	}

	public int getIdPredmet() {
		return this.idPredmet;
	}

	public void setIdPredmet(int idPredmet) {
		this.idPredmet = idPredmet;
	}

	public int getEspbPoeni() {
		return this.espbPoeni;
	}

	public void setEspbPoeni(int espbPoeni) {
		this.espbPoeni = espbPoeni;
	}

	public String getImePredmeta() {
		return this.imePredmeta;
	}

	public void setImePredmeta(String imePredmeta) {
		this.imePredmeta = imePredmeta;
	}

	public String getOpisPredmeta() {
		return this.opisPredmeta;
	}

	public void setOpisPredmeta(String opisPredmeta) {
		this.opisPredmeta = opisPredmeta;
	}

	public List<Dogadjajskola> getDogadjajskolas() {
		return this.dogadjajskolas;
	}

	public void setDogadjajskolas(List<Dogadjajskola> dogadjajskolas) {
		this.dogadjajskolas = dogadjajskolas;
	}

	public Dogadjajskola addDogadjajskola(Dogadjajskola dogadjajskola) {
		getDogadjajskolas().add(dogadjajskola);
		dogadjajskola.setPredmetskola(this);

		return dogadjajskola;
	}

	public Dogadjajskola removeDogadjajskola(Dogadjajskola dogadjajskola) {
		getDogadjajskolas().remove(dogadjajskola);
		dogadjajskola.setPredmetskola(null);

		return dogadjajskola;
	}

	public List<Ispitnopitanjeskola> getIspitnopitanjeskolas() {
		return this.ispitnopitanjeskolas;
	}

	public void setIspitnopitanjeskolas(List<Ispitnopitanjeskola> ispitnopitanjeskolas) {
		this.ispitnopitanjeskolas = ispitnopitanjeskolas;
	}

	public Ispitnopitanjeskola addIspitnopitanjeskola(Ispitnopitanjeskola ispitnopitanjeskola) {
		getIspitnopitanjeskolas().add(ispitnopitanjeskola);
		ispitnopitanjeskola.setPredmetskola(this);

		return ispitnopitanjeskola;
	}

	public Ispitnopitanjeskola removeIspitnopitanjeskola(Ispitnopitanjeskola ispitnopitanjeskola) {
		getIspitnopitanjeskolas().remove(ispitnopitanjeskola);
		ispitnopitanjeskola.setPredmetskola(null);

		return ispitnopitanjeskola;
	}

	public List<Obavestenjeskola> getObavestenjeskolas() {
		return this.obavestenjeskolas;
	}

	public void setObavestenjeskolas(List<Obavestenjeskola> obavestenjeskolas) {
		this.obavestenjeskolas = obavestenjeskolas;
	}

	public Obavestenjeskola addObavestenjeskola(Obavestenjeskola obavestenjeskola) {
		getObavestenjeskolas().add(obavestenjeskola);
		obavestenjeskola.setPredmetskola(this);

		return obavestenjeskola;
	}

	public Obavestenjeskola removeObavestenjeskola(Obavestenjeskola obavestenjeskola) {
		getObavestenjeskolas().remove(obavestenjeskola);
		obavestenjeskola.setPredmetskola(null);

		return obavestenjeskola;
	}

	public Profesorskola getProfesorskola() {
		return this.profesorskola;
	}

	public void setProfesorskola(Profesorskola profesorskola) {
		this.profesorskola = profesorskola;
	}

	public List<Studentskola> getStudentskolas() {
		return this.studentskolas;
	}

	public void setStudentskolas(List<Studentskola> studentskolas) {
		this.studentskolas = studentskolas;
	}

}