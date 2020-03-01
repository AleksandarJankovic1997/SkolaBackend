package ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import model.Dogadjajskola;
import model.Ispitnopitanjeskola;
import model.Obavestenjeskola;
import model.Predmetskola;
import model.Profesorskola;
import model.Studentskola;

/**
 * Session Bean implementation class PredmetStateless
 */
@Stateless
@LocalBean
public class PredmetStateless implements PredmetStatelessLocal {
	@PersistenceContext
	EntityManager em;
    
	@EJB 
	Statistika statistika;
	
    public PredmetStateless() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Predmetskola> sviPredmet() {
		statistika.brojPoziva();
		return em.createQuery("Select p from Predmetskola p").getResultList();
	}

	@Override
	public List<Predmetskola> predmetiStudenta(int idStudent) {
		statistika.brojPoziva();
		Studentskola student=em.find(Studentskola.class,idStudent);
		return student.getPredmetskolas();
	}

	@Override
	public List<Predmetskola> predmetiProfesora(int idProfesor) {
		statistika.brojPoziva();
		Profesorskola profesor=em.find(Profesorskola.class, idProfesor);
		return profesor.getPredmetskolas();
		
	}
	@Override
	public List<Predmetskola> predmetiPoEspbPoenima(int espb) {
		statistika.brojPoziva();
		List<Predmetskola> predmeti=em.createQuery("Select p from Predmetskola p where p.espbPoeni=:x").setParameter("x", espb).getResultList();
		return predmeti;
	}

	@Override
	public Predmetskola pronadjiPoImenu(String ime) {
		statistika.brojPoziva();
		Predmetskola predmet;
		try {
			predmet=(Predmetskola)em.createQuery("Select p from Predmetskola p where p.imePredmeta=:x").setParameter("x", ime).getSingleResult();
		}catch (NoResultException e) {
			return null;
		}
		return predmet;
	}

	@Override
	public void novPredmet(Predmetskola predmetskola) {
		statistika.brojPoziva();
		em.persist(predmetskola);
		
	}
	@Override
	public List<Obavestenjeskola>svaObavestenjaPredmeta(int idpredmet){
		statistika.brojPoziva();
		return em.createQuery("Select o from Obavestenjeskola o where o.predmetskola.idPredmet=:x").setParameter("x", idpredmet).getResultList();
	}
	
	@Override
	public void ubaciObavestenjePredmet(Predmetskola predmetskola, Obavestenjeskola obavestenjeskola) {
		statistika.brojPoziva();
		predmetskola=em.merge(predmetskola);
		obavestenjeskola.setPredmetskola(predmetskola);
		em.persist(obavestenjeskola);
		predmetskola.addObavestenjeskola(obavestenjeskola);		
		em.merge(predmetskola);
	}
	@Override
	public void dodajIspitnoPitanje(int idPredmet, Ispitnopitanjeskola ispitnopitanjeskola) {
		statistika.brojPoziva();
		Predmetskola predmet=em.find(Predmetskola.class, idPredmet);
		ispitnopitanjeskola.setPredmetskola(predmet);
		em.persist(ispitnopitanjeskola);
		predmet.addIspitnopitanjeskola(ispitnopitanjeskola);
		em.merge(predmet);
	}

	@Override
	public void dodajDogadjaj(Predmetskola predmetskola, Dogadjajskola dogadjajskola) {
		// TODO Auto-generated method stub
		
	}

}
