package com.controllers;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.models.Rapport;
import com.services.RapportService;

@Produces("text/xml")
public class RapportController {
	
 private RapportService rapportHomeService;
 
 @Autowired(required=true)
 @Qualifier(value="rapportHomeService") 
 public void setRapportHomeService(RapportService as){
  this.rapportHomeService = as;
 }
 
 @GET
 @Path("/rapports/")
 @Produces({"application/json","application/xml"})
 public List<Rapport> listRapports()
 { 
	 System.out.println("invoked in listing all rapports");
	 List<Rapport> rapports = this.rapportHomeService.listRapports();
	 for(Rapport a: rapports) System.out.println(a.toString());
	 return rapports;
 }
 
 @GET
 @Path("/rapportsDuJour/")
 @Produces({"application/json","application/xml"})
 public List<Rapport> listRapportsDuJour()
 { 
	 System.out.println("invoked in listing all rapports");
	 List<Rapport> rapports = this.rapportHomeService.listRapportsDuJour();
	 for(Rapport a: rapports) System.out.println(a.toString());
	 return rapports;
 }
 
 @POST
 @Path("/rapports/add")
 @Produces({"application/json","application/xml"})
 @Consumes({"application/json","application/xml"})
 public void addRapport(Rapport rapport)
 { 
	 System.out.println("invoked in adding rapport");
	 System.out.println("l'rapport" + rapport);
	 this.rapportHomeService.persistRapport(rapport);
 }
 
}