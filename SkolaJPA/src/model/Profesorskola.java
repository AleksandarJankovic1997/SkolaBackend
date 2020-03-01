	package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the profesorskola database table.
 * 
 */
@Entity
@NamedQuery(name="Profesorskola.findAll", query="SELECT p FROM Profesorskola p")
public class Profesorskola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProfesor;

	@Temporal(TemporalType.DATE)
	private Date datumRodjenja;

	private String imeProfesora;

	private String password;

	private String prezimePrefosora;

	private String username;

	//bi-directional many-to-one association to Predmetskola
	@OneToMany(mappedBy="profesorskola", fetch = FetchType.EAGER)
	private List<Predmetskola> predmetskolas;

	public Profesorskola() {
	}

	public int getIdProfesor() {
		return this.idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	public Date getDatumRodjenja() {
		return this.datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getImeProfesora() {
		return this.imeProfesora;
	}

	public void setImeProfesora(String imeProfesora) {
		this.imeProfesora = imeProfesora;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezimePrefosora() {
		return this.prezimePrefosora;
	}

	public void setPrezimePrefosora(String prezimePrefosora) {
		this.prezimePrefosora = prezimePrefosora;
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

	public Predmetskola addPredmetskola(Predmetskola predmetskola) {
		getPredmetskolas().add(predmetskola);
		predmetskola.setProfesorskola(this);

		return predmetskola;
	}

	public Predmetskola removePredmetskola(Predmetskola predmetskola) {
		getPredmetskolas().remove(predmetskola);
		predmetskola.setProfesorskola(null);

		return predmetskola;
	}

}