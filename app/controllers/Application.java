package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
  public static Result index() {
    return ok(index.render());
  }
  
  public static Result dashboard() {
	    return ok(dashboard.render());
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
  
  public static Result test(String start, String end, String title, String body) {
  
	  Logger.info ( "start: " + start + " end: " + end );
	  return ok();
  
  }  
}