package controllers;

import java.util.List;

import org.w3c.dom.Document;

import models.Appointment;
import play.*;
import play.libs.F.Function;
import play.libs.F.Promise;
import play.libs.WS;
import play.libs.XPath;
import play.mvc.*;

import views.html.*;

import play.data.DynamicForm;

import com.typesafe.plugin.*;


public class Application extends Controller {

	public static Result index() {
		return ok(index.render());
	}

	public static Result login() {
		return ok(login.render());
	}

	public static Result logout() {
		session().clear();
		return ok(index.render());
	}

	public static Result authenticate() {

		final DynamicForm form = form().bindFromRequest();
		final String name = form.get("username");

		session("connected", name);

		Logger.info(name);

		return redirect(controllers.routes.Application.dashboard());

	}

	public static Result dashboard() {

		String name = null;

		name = session("connected");

		Logger.info("Connected as: " + name);

		if (name == null) {
			return redirect(controllers.routes.Application.login());
		} else {
			name = session("connected");
		}

		if (name.toLowerCase().equals("admin")) {
			return redirect(controllers.routes.Application.admin());
		}
		if (name.toLowerCase().equals("clinician")) {
			return redirect(controllers.routes.Application.clinician());
		}

		return redirect(controllers.routes.Application.patient());
	}
	

	public static Result admin() {
		List<Appointment> appointments = Appointment.all();
		return ok(admin.render(appointments));
	}

	public static Result clinician() {
		List<Appointment> appointments = Appointment.all();
		return ok(clinician.render(appointments));
	}

	public static Result patient() {
		String username = session("connected");
		return ok(patient.render(username));
	}

	public static Result test(String start, String end, String title,
			String body, String username) {

		Logger.info("start: " + start + " end: " + end);

		Appointment appointment = new Appointment();

		appointment.patient = username;
		appointment.start = start;
		appointment.end = end;
		appointment.title = title;
		appointment.body = body;

		appointment.save();

		Logger.info("patient" + appointment.patient + "date"
				+ appointment.start + appointment.end + appointment.title
				+ appointment.body);

		return ok();

	}

	public static Result list() {
		List<Appointment> appointments = Appointment.all();
		// Appointment appointment = new Appointment();

		Logger.info("lenth " + appointments.size());

		return ok();

	}

	
	public static Result setupMeeting(Long id) {
		
		//TODO setup the meeting in bbb
		
		Appointment appointment = Appointment.find.byId(id);
	//	appointment.meetingID = "meetingID";
		appointment.save();
		
		//String feedUrl = "http://producthelp.sdl.com/SDL%20Trados%20Studio/client_en/sample.xml";
		String feedUrl = "http://localhost:9000/assets/testResponse.xml";
		
	    return async(
	    	      WS.url(feedUrl).setHeader("Content-type", "text/xml; charset=utf-8").get().map(
	    	        new Function<WS.Response, Result>() {
	    	          public Result apply(WS.Response response) {


	    	        	  // Works ... not overly helpful
	    	        	  // return ok("Feed title:\n" + response.getBody());

	    	        	  // Doesnt work .. although .getChildNodes.getSize() (or something) does return 1
	    	        	  // return ok("Feed title:\n" + response.asXml());

	    	        	  Document dom = response.asXml();
	    	        	  if(dom == null) {
	    	        	    return badRequest("Expecting Xml data");
	    	        	  } else {
	    	        	    String meetingID = XPath.selectText("//meetingID", dom);
	    	        	    if(meetingID == null) {
	    	        	      return badRequest("Missing parameter [meetingID]");
	    	        	    } else {
	    	        	      return ok("Meeting created : " + meetingID);
	    	        	    }
	    	        	  }
    	        	  

	    	          }
	    	        }
	    	      )
	    	     );
	}
	
	
	public static Result approve(Long id) {

		//TODO flesh out appointment approval text

		// Blah .. your email has been appointment.status ... blahh
		
		Appointment appointment = Appointment.find.byId(id);
		appointment.status = "Accepted";
		appointment.save();

		MailerAPI mail = play.Play.application().plugin(MailerPlugin.class).email();
		mail.setSubject("mailer");
		mail.addRecipient("Peter Hausel Junior <noreply@email.com>","example@foo.com");
		mail.addFrom("Peter Hausel <noreply@email.com>");
		//sends html
		mail.sendHtml("<html>html</html>" );
		//sends text/text
		mail.send( "Date: " + appointment.start );
		//sends both text and html
		mail.send( "text", "<html>html</html>");
		
		return ok("mail sent");
	}
	
	public static Result decline(Long id) {

		//TODO flesh out appointment decline text

		// Blah .. your email has been appointment.status ... blahh
		
		Appointment appointment = Appointment.find.byId(id);
		appointment.status = "Declined";
		appointment.save();
		
		MailerAPI mail = play.Play.application().plugin(MailerPlugin.class).email();
		mail.setSubject("mailer");
		mail.addRecipient("Peter Hausel Junior <noreply@email.com>","example@foo.com");
		mail.addFrom("Peter Hausel <noreply@email.com>");
		//sends html
		mail.sendHtml("<html>html</html>" );
		//sends text/text
		mail.send( "Date: " + appointment.start );
		//sends both text and html
		mail.send( "text", "<html>html</html>");
		
		return ok("mail sent");
	}
	
}