package rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ejb.StudentProfesorStatelessLocal;
import model.Profesorskola;
import model.Studentskola;

@Path("/StudentProfesor")
public class StudentProfesorRest {

	@EJB
	StudentProfesorStatelessLocal local;
	
	@GET
	@Path("/studentPoId/{idstudent}")
	@Produces(MediaType.APPLICATION_JSON)
	public Studentskola getStudentIndeks(@PathParam("idstudent") String idstudent) {
		return local.pronadjiPoIndeksu(idstudent);
	}
	
	@GET
	@Path("Sayhello")
	public String sayhello() {
		return "sayhello";
	}
	
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/profesorImePrezime/{ime}/{prezime}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profesorskola getProfesor(@PathParam("ime")String ime,@PathParam("prezime") String prezime) {
		return local.pronadjiPoImenuIPrezimenuProfesor(ime, prezime); 	
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/login/{username}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public int login(@PathParam("username")String username,@PathParam("password") String password) {
		return local.autorizovan(username, password);
	}
	
}
