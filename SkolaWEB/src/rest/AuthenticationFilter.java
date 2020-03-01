package rest;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.annotation.Priority;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.util.Base64;

import ejb.StudentProfesorStatelessLocal;


//@Provider
//@Priority(Priorities.AUTHENTICATION) 
public class AuthenticationFilter implements ContainerRequestFilter {

	
	
	@EJB
	StudentProfesorStatelessLocal studentProfesorStatelessLocal;
	
	@Context
	private ResourceInfo resourceInfo;
	
	private static final String AUTHORIZATION_PROPERTY = "Authorization";
    private static final String AUTHENTICATION_SCHEME = "Basic";
    
	
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		Method method=resourceInfo.getResourceMethod();
		if(! method.isAnnotationPresent(PermitAll.class)) {
			if(method.isAnnotationPresent(DenyAll.class)) {
				requestContext.abortWith(Response.status(Response.Status.FORBIDDEN)
						.entity("Acess blocked for all users").build());
				return;
			}
			final MultivaluedMap<String, String > headers=requestContext.getHeaders();
			final List<String> authorization=headers.get(AUTHORIZATION_PROPERTY);
			if(authorization==null||authorization.isEmpty()) {
				requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
	                    .entity("You cannot access this resource").build());
	                return;
			}
			final String encodedUserPassword=authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME+ " ", "");
			String usernameAndPassword=null;
			usernameAndPassword=new String(Base64.decode(encodedUserPassword.getBytes()));
			
			final StringTokenizer tokenizer=new StringTokenizer(usernameAndPassword,":");
			final String username=tokenizer.nextToken();
			final String password=tokenizer.nextToken();
			
			
			if(method.isAnnotationPresent(RolesAllowed.class)) {
				RolesAllowed rolesAnnotation=method.getAnnotation(RolesAllowed.class);
				Set<String> rolesSet=new HashSet<String>(Arrays.asList(rolesAnnotation.value()));
				
				if(! isUserAllowed(username,password,rolesSet)) {
					requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
							.entity("You cannot acess this resource").build());
					return;
				}
			}
		}
	}



	private boolean isUserAllowed(String username, String password, Set<String> rolesSet) {
		boolean isAllowed=false;
		String userRole="prazno";
		if(studentProfesorStatelessLocal.autorizovan(username, password)==1) {
			 userRole="PROFESOR";
		}
		else if(studentProfesorStatelessLocal.autorizovan(username, password)==2) {
			userRole="STUDENT";
		}
		if(rolesSet.contains(userRole)) {
			isAllowed=true;
		}
		return isAllowed;
	}

}
