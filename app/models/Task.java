package models;

import java.util.List;

import javax.persistence.*;

import play.data.validation.Constraints.MinLength;
import play.db.ebean.Model;

@Entity
public class Task extends Model {
	@Id
	public int id;
	
	@MinLength(2)
	public String name;
	
	static Finder<Integer, Task> find = new Finder<Integer, Task>(Integer.class, Task.class);
	
	public static void create(Task t){
		t.save();
	}
	
	public static List<Task> all(){
		return find.all();
	}
	
}
