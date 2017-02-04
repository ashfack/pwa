package com.controllers;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.models.Automate;
import com.services.AutomateService;

//@Path("/automateservice/")
@Produces("text/xml")
public class AutomateController {
 private AutomateService automateService;
 
 @Autowired(required=true)
 @Qualifier(value="automateService") 
 public void setAutomateService(AutomateService as){
  this.automateService = as;
 }
 
 @GET
 @Path("/automates/")
 @Produces({"application/json","application/xml"})
 public List<Automate> listAutomates()
 { 
	 System.out.println("invoked in listing all automates");
	 List<Automate> automates = this.automateService.listAutomates();
	 for(Automate a: automates) System.out.println(a.toString());
	 return automates;
 }
 @GET
 @Path("/automates/{id}/")
 @Produces({"application/json","application/xml"})
 //@RequestMapping(value="/automateService/automate/list",params={"num"}, method = RequestMethod.GET, produces = "application/json")
 public Automate listAutomate(@PathParam("id")Integer num)
 { 
	 //System.out.println("invoked in listing specific automate");
	 Automate automate = this.automateService.getAutomateByNum(num);
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
 //@RequestMapping(value="/automateService/automate/add", method = RequestMethod.POST)
 public void addAutomate(Automate automate)
 { 
	 System.out.println("invoked in adding automate");
	 System.out.println("l'automate" + automate);
	 this.automateService.persistAutomate(automate);
 }
 
 @RequestMapping(value="/automateService/automate/delete", method = RequestMethod.POST)
 public void deleteAutomate(@RequestParam("id") Integer id)
 { 
	 System.out.println("invoked in deleting automate");
	 System.out.println("l'automate" + id);
	 this.automateService.deleteAutomateByNum(id);
 }
}