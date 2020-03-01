package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Dogadjajskola;
import model.Ispitnopitanjeskola;
import model.Obavestenjeskola;
import model.Predmetskola;
import model.Profesorskola;
import model.Studentskola;

@Local
public interface PredmetStatelessLocal {

	public List<Predmetskola> sviPredmet();
	
	public List<Predmetskola> predmetiStudenta(int idStudent);
	
	public List<Predmetskola> predmetiProfesora(int idProfesor);
	
	public List<Predmetskola> predmetiPoEspbPoenima(int espb);
	
	public Predmetskola pronadjiPoImenu(String ime);
	
	public void novPredmet(Predmetskola predmetskola);
	
	public void ubaciObavestenjePredmet(Predmetskola predmetskola,Obavestenjeskola obavestenjeskola);
	
	public void dodajIspitnoPitanje(int idPredmet,Ispitnopitanjeskola ispitnopitanjeskola);
	
	public void dodajDogadjaj(Predmetskola predmetskola,Dogadjajskola dogadjajskola);
	
	public List<Obavestenjeskola>svaObavestenjaPredmeta(int idpredmet);
	
	
	
}
