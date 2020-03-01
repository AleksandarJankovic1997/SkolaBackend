package webServices;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;

import ejb.PredmetStateless;
import ejb.PredmetStatelessLocal;
import model.Predmetskola;

/**
 * Session Bean implementation class WebServiceStateless
 */
@WebService
@Stateless
@LocalBean
public class WebServiceStateless implements WebServiceStatelessLocal {

	
	@EJB
	PredmetStatelessLocal predmetStatelessLocal;
    /**
     * Default constructor. 
     */
    public WebServiceStateless() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Predmetskola> sviPredmeti() {
		return predmetStatelessLocal.sviPredmet();
	}

}
