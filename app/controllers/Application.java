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
  
<<<<<<< HEAD
  public static Result test(String foo) {
	  
	  Logger.info("here is foo: " + foo);
	  return ok();
  }
=======
  public static Result test(String start, String end, String title, String body) {
  
	  Logger.info ( "here is foo: " + start);
	  return ok();
  
  }
  
>>>>>>> d4cb179e4b6fb103fca17ee141dc5e41d040009e
  
}