 	package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import com.sun.org.apache.regexp.internal.recompile;

import model.Profesorskola;
import model.Studentskola;

/**
 * Session Bean implementation class StudentProfesorStateless
 */
@Stateless
@LocalBean
public class StudentProfesorStateless implements StudentProfesorStatelessLocal {
	@EJB 
	Statistika statistika;
	
	@PersistenceContext
	EntityManager em;

    /**
     * Default constructor. 
     */
    public StudentProfesorStateless() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Studentskola pronadjiPoIndeksu(String index) {
		statistika.brojPoziva();
		Studentskola student=em.find(Studentskola.class, index);
		return student;
	}

	@Override
	public List<Studentskola> pronadjiPoImenuIPrezimenuStudent(String ime, String prezime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dodajStudenta(Studentskola studentskola) {
		statistika.brojPoziva();
		em.persist(studentskola);
		
	}

	@Override
	public Profesorskola pronadjiPoImenuIPrezimenuProfesor(String ime, String prezime) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int autorizovan(String username, String password) {
		try {
			Profesorskola p=(Profesorskola)em.createQuery("Select p from ProfesorSkola p where p.username=:x and p.password=:y")
			.setParameter("x", username)
			.setParameter("y", password).getSingleResult();
			return 1;
		}catch(NoResultException nre) {}
		try {
			Studentskola s=(Studentskola)em.createQuery("Select s from StudentSkola s where s.username=:x and s.password=:y")
					.setParameter("x", username)
					.setParameter("y", password)
					.getSingleResult();
			return 2;
		}catch (NoResultException nre2) {}
		return 0;
	}
	/*
	@Override
	public Object login(String username, String password) {
		try {
			Profesorskola p=(Profesorskola)em.createQuery("Select p from ProfesorSkola p where p.username=:x and p.password=:y")
			.setParameter("x", username)
			.setParameter("y", password).getSingleResult();
			return p;
		}catch(NoResultException nre) {
		}
		try {
			Studentskola s=(Studentskola)em.createQuery("Select s from StudentSkola s where s.username=:x and s.password=:y")
					.setParameter("x", username)
					.setParameter("y", password)
					.getSingleResult();
			return s;
		}catch (NoResultException nre2) {}
		return null;
		
	}*/

}
