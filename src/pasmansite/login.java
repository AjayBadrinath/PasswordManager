package pasmansite;

import pasman.pwnWrapper;
import pasman.sha1;

import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
@PageTitle("signup")
@Route("login")
public class login extends Composite<VerticalLayout>  {
/*
	public login(){
	
	TextField uname =new TextField("UserName");
	PasswordField pwd=new PasswordField("Password");
	PasswordField cnfp=new PasswordField("Confirm");
	VerticalLayout l= getContent();
	l.setSizeFull();
	l.setAlignItems(Alignment.CENTER);
	l.add(new VerticalLayout(
			new H2("Register"),
			uname,
			pwd,
			cnfp,
			new Button("Register",event-> signup(
					uname.getValue(),
					pwd.getValue(),
					cnfp.getValue()
					))
			));
	
}
*/
	public login() {
		H2 welcome=new H2("Register");
		
		VerticalLayout layout=getContent();
		layout.setSizeFull();
		layout.setSpacing(false);
		TextField Username =new TextField("Username");
		//layout.add(Username);
		layout.setAlignItems(Alignment.CENTER);
		layout.setJustifyContentMode(JustifyContentMode.CENTER);
		PasswordField pwd=new PasswordField("Password");
		//layout.add(pwd);
		PasswordField cnf=new PasswordField("Confirm Password");
		//TabSheet ts=new TabSheet();
		
		RadioButtonGroup<String>rg=new RadioButtonGroup<>();
		rg.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
		rg.setItems("Check for 2 Factor Authentication");
		
		layout.add( 
				new H2("Register"),
				Username,
				pwd,
				cnf,
				new Button("Register",event -> signup(
						Username.getValue(),
						pwd.getValue(),
						cnf.getValue(),
				 
						rg.isEnabled()
						)),
				rg
				
				
				
				
				);
		Span stat=new Span();
		stat.setVisible(false);
		ConfirmDialog dlg=new ConfirmDialog();
		dlg.setHeader("Note");
		dlg.setText(
				new Html(
					"<p>This is a Password Manager Built Purely on the users' leverage<b> We do not store any users' data or collect any information as such </b>,As a result for you to use this site fruitfully you are<b> required to have my sql installed beforehand</b> and you are required to enter your My Sql credentials </p>"
						)
				);
		dlg.setConfirmText("OK");
		dlg.getElement().getThemeList().add("dark");
		layout.getElement().getThemeList().add("dark");
		
		dlg.open();
		FlexComponent.Alignment alm=Alignment.CENTER;
		layout.setAlignSelf(alm);
		
		
		
	}
	@SuppressWarnings("deprecation")
	public static   Notification error (String err) {
		Notification err1=new Notification();
		err1.addThemeVariants(NotificationVariant.LUMO_ERROR);
		Div theme=new Div(new Text(err));
		err1.setDuration(5000);
		//Button ec=new Button(new Icon("lumo","cross"));
		//ec
		Button close=new Button(new Icon("lumo","cross"));
		close.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
		close.getElement().setAttribute("aria-label", "Close");
		close.addClickListener(event ->{
			err1.close();
		});
		
		HorizontalLayout lay=new HorizontalLayout(theme,close);
		lay.setAlignItems(Alignment.CENTER);
		err1.add(lay);
		
		return err1;
	}
	
private void signup(String uname,String pwd,String cnfp,boolean chkbtn ) {
	//l.add(new RouterLink("Sign in" ,MainView.class));
	sha1 enc=new sha1(cnfp);
	final String pvk=enc.encrypt();
	//System.out.println(pvk);
	pwnWrapper wrap=new pwnWrapper(pvk);
	wrap.check();

	if(wrap.assertion==true) {
		Notification errormsg= error("Password is Breached!");
		errormsg.open();
		
		
		//getUI().ifPresent(ui ->ui.navigate("login"));
		
		
	}
	else {
	if( chkbtn&&!pwd.equals("") && pwd.equals(cnfp)) {
		getUI().ifPresent(ui -> ui.navigate("2fa"));
	}
	
	
	if(!pwd.equals("") && pwd.equals(cnfp) ) {
		
		
		Notification notification = new Notification();
		notification.setPosition(Notification.Position.TOP_CENTER);
		Notification.show("Master Password Registered Successfully!");
		getUI().ifPresent(ui -> ui.navigate("hello"));
		
	}
	}
}

}
