package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
  public static Result index() {
    return ok(index.render("Your new application is ready."));
  }
  
  
  public static Result admin() {
	  return ok(admin.render(""));
  }
  
  public static Result clinician() {
	  return ok(patient.render(""));
  }
    
  public static Result patient() {
	  return ok(patient.render(""));
  }
  
  
}