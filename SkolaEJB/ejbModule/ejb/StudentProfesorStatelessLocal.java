package ejb;

import java.util.List;

import javax.ejb.Local;

import model.Profesorskola;
import model.Studentskola;

@Local
public interface StudentProfesorStatelessLocal {
	
	public Studentskola pronadjiPoIndeksu(String index);
	
	public List<Studentskola> pronadjiPoImenuIPrezimenuStudent(String ime, String prezime);
	
	public void dodajStudenta(Studentskola studentskola);
	
	public Profesorskola pronadjiPoImenuIPrezimenuProfesor(String ime, String prezime);

	public int autorizovan(String username, String password);
	
	//public Object login(String username,String password);
	
	
}
