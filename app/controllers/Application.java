package controllers;

import play.*;
import play.mvc.*;
import play.data.Form;
import models.*;
import views.html.*;

import views.html.*;

public class Application extends Controller {

	
	static Form<Task> submitForm  = new Form<Task>(Task.class);
	
    public static Result index() {
        return ok(index.render("Welcome to Todo,", submitForm, Task.all()));
    }

    public static Result createTask(){
    Form<Task> bindForm = submitForm.bindFromRequest();
    submitForm.discardErrors();
    if( bindForm.hasErrors() == false){
    	Task.create(bindForm.get());
    	submitForm = new Form<Task>(Task.class);
    	return redirect("/");
    }  	
    return ok(index.render("Welcome to Todo", bindForm, Task.all()));
    }
    
    public static Result deleteTask(int id){
    	return ok(delete.render(id));
    }
    
    public static Result deleteTask(){
    	return TODO;
    }
}
