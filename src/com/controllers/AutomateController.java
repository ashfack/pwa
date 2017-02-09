package com.controllers;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.models.Automate;
import com.services.AutomateService;

@Produces("text/xml")
public class AutomateController {
 private AutomateService automateHomeService;
 
 @Autowired(required=true)
 @Qualifier(value="automateHomeService") 
 public void setAutomateHomeService(AutomateService as){
  this.automateHomeService = as;
 }
 
 @GET
 @Path("/automates/")
 @Produces({"application/json","application/xml"})
 public List<Automate> listAutomates()
 { 
	 System.out.println("invoked in listing all automates");
	 List<Automate> automates = this.automateHomeService.listAutomates();
	 for(Automate a: automates) System.out.println(a.toString());
	 return automates;
 }
 @GET
 @Path("/automates/{id}/")
 @Produces({"application/json","application/xml"})
 public Automate listAutomate(@PathParam("id")Integer num)
 { 
	 System.out.println("invoked in listing specific automate");
	 Automate automate = this.automateHomeService.getAutomateByNum(num);
	 if (automate != null)
	 {
		 System.out.println(automate);
	 }
	 else
	 {
		 System.out.println("Automate non trouvé");
	 }
	 return automate;
 }
 @POST
 @Path("/automates/add")
 @Produces({"application/json","application/xml"})
 @Consumes({"application/json","application/xml"})
 public void addAutomate(Automate automate)
 { 
	 System.out.println("invoked in adding automate");
	 System.out.println("l'automate" + automate);
	 this.automateHomeService.persistAutomate(automate);
 }
 
 @POST
 @Path("automates/delete/{id}")
 public void deleteAutomate(@PathParam("id") Integer id)
 { 
	 System.out.println("invoked in deleting automate");
	 System.out.println("l'automate" + id);
	 this.automateHomeService.deleteAutomateByNum(id);
 }
}