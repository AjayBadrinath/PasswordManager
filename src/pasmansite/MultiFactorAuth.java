package pasmansite;

import pasman.*;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
@PageTitle("2fa")
@Route(value="2fa")
public class MultiFactorAuth extends Composite<VerticalLayout>{
	public MultiFactorAuth() {
		
		LoginOverlay lay=new LoginOverlay();
		lay.getElement().getThemeList().add("dark");
		LoginI18n inter=LoginI18n.createDefault();
		lay.setTitle("TwoFactorAuth");
		lay.setDescription("Hello!!");
		lay.setOpened(true);
		VerticalLayout l=getContent();
		l.add(lay);
		l.setAlignItems(Alignment.CENTER);
		l.setSizeFull();
		
		
	}
}
