package es.cic.taller.ejercicio05;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        final TextField name = new TextField();
        //name.setCaption("Name");
        name.setPlaceholder("Name");
        name.setMaxLength(30);
        
        final TextField  surname= new TextField();
        //surname.setCaption("Surname");
        surname.setPlaceholder("Surname");
        surname.setMaxLength(30);
        
        final TextField  age= new TextField();
        //age.setCaption("Age");
        age.setPlaceholder("Age");
        age.setMaxLength(3);
        
        final TextField  adress= new TextField();
        //adress.setCaption("Adress");
        adress.setPlaceholder("Adress");
        adress.setMaxLength(50);
        
        

        Button button = new Button("Enter data");
        button.addClickListener( e -> {
            layout.addComponent(new Label("Hello " + name.getValue() 
                    + surname.getValue() + " you are " + age.getValue()+ " years old, and your adress is "+ adress.getValue()));
        });
        
        layout.addComponents(name, surname, age, adress, button);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
