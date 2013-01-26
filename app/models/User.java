package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

@Entity
public class User extends Model {

	@Id
	public Long id;

	public String email;
	
	public static Finder<Long, User> find = new Finder(Long.class, User.class);

	public static List<User> all() {
		return find.all();
	}

	public static void create(User user) {
		user.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}

}