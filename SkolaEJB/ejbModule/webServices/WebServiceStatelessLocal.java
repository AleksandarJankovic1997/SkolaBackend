package webServices;

import java.util.List;

import javax.ejb.Local;

import model.Predmetskola;

@Local
public interface WebServiceStatelessLocal {

	List<Predmetskola>sviPredmeti();
	
}
