package pe.edu.utp.dentalservice.controllers;

import javax.faces.bean.*;

/**
 * Created by JUAN CARLOS on 20/03/2017.
 */
@ManagedBean(name="TemplateController")
@SessionScoped
public class TemplateController {

    private String title = "";

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String hospital(){
        this.title = "Hospitales";
        return "list_hospitals";
    }

    public String turn(){
        this.title = "Turnos";
        return "list_turns";
    }

    public String AddTurn(){
        this.title = "Agregar Turnos";
        return "AddTurn";
    }
}
