package rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejb.PredmetStatelessLocal;
import model.Obavestenjeskola;
import model.Predmetskola;

@Path("/predmet")
public class PredmetRest {
	@EJB(lookup ="ejb:SkolaEAR/SkolaEJB//PredmetStateless!ejb.PredmetStatelessLocal" )
	PredmetStatelessLocal predmetStatelessLocal;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/predmetiStudenta/{idstudent}")
	public List<Predmetskola> predmetiStudenta(@PathParam("idstudent") int idstudent){
		return predmetStatelessLocal.predmetiStudenta(idstudent);
	}
	
	@GET
	@Path("/predmetiEspb/{imepredmeta}")
	@Produces(MediaType.APPLICATION_JSON)
	public Predmetskola predmetPoImenu(@PathParam("imepredmeta")String imepredmeta){
		return predmetStatelessLocal.pronadjiPoImenu(imepredmeta);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/obavestenja/{idpredmet}")
	public List<Obavestenjeskola> svaObavestenjaPredmet(@PathParam("idpredmet") int idpredmet){
		return predmetStatelessLocal.svaObavestenjaPredmeta(idpredmet);
	}

}
