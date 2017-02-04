package com.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.models.Livre;

//@Path("/bibliothequeservice/")
@Produces("text/xml")
public class BibliothequeService {
    long currentIsbn = 123;
    Map<Long, Livre> livres = new HashMap<Long, Livre>();

    public BibliothequeService() {
        init();
    }

    @GET
    @Path("/livres/{isbn}/")
    public Livre getLivre(@PathParam("isbn") String isbn) {
    	  System.out.println("----invoking getLivre, Livre isbn is: " + isbn);
          long isbnNumber = Long.parseLong(isbn);
          Livre l = livres.get(isbnNumber);
          return l;
    }
    
    @GET
    @Path("/livres/")
    @Produces({"application/json","application/xml"})
    public Collection<Livre> getAllLivre() {
    	  System.out.println("----invoking getAllLivre !");
          return livres.values();
    }

    /*@PUT
    @Path("/livres/")
    public Response updateLivre(Livre livre) {
      
    }*/

    @POST
    @Path("/livres/")
    public Response addLivre(Livre livre) {
    	System.out.println("----invoking addLivre, Livre title is: " + livre.getTitre());
        livres.put(livre.getISBN(), livre);

        return Response.ok(livre).build();
    }

    @DELETE
    @Path("/livres/{isbn}/")
    public Response deleteLivre(@PathParam("isbn") String isbn) {
    	   System.out.println("----invoking deleteLivre, Livre isbn is: " + isbn);
           long isbnNumber = Long.parseLong(isbn);
           Livre c = livres.get(isbnNumber);

           Response r;
           if (c != null) {
               r = Response.ok().build();
               livres.remove(isbnNumber);
           } else {
               r = Response.notModified().build();
           }

           return r;
    }

    final void init() {
        Livre l = new Livre("Toto joue au foot","John",123);
        livres.put(l.getISBN(), l);

    }

}