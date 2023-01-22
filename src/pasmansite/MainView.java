package pasmansite;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
/**
 * The main view contains a button and a click listener.
 */
@PageTitle("Hello World")
@Route(value = "hello")
public class MainView extends Composite<VerticalLayout>{
	private String uid;
	private String pwd;
    public MainView() {
    	LoginForm frm=new LoginForm();
    	
    	frm.setAction("2fa");
    	VerticalLayout l=getContent();
    	Label fm=new Label("UserId"+uid);
    	//Avatar aname=new Avatar("Ajay");
    	//aname.setAbbreviation("BJ");
    	l.add(frm);
    	l.setSizeFull();
    	l.setAlignItems(Alignment.CENTER);
    	l.setAlignItems(Alignment.CENTER);
    	frm.addLoginListener(event ->{
    		uid=event.getUsername();
    		pwd=event.getPassword();
    		Notification.show(pwd, 5, Position.TOP_END);
    		UI.getCurrent().navigate("2fa");
    	}
    			);
    	l.add(new RouterLink("Register",login.class));
    	
    }
}


