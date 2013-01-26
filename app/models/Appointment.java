package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity
public class Appointment extends Model {

	@Id
	public Long id;

	public String patient;
	
	public String start;
	public String end;
	
	public String title;
	public String body;

	
	// USE THESE FOR LINKING
	
	public String status;
	public String email;
	public String meetingID;
	
	
	public static Finder<Long, Appointment> find = new Finder(Long.class, Appointment.class);

	public static List<Appointment> all() {
		return find.all();
	}

	public static void create(Appointment appointment) {
		appointment.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}

}