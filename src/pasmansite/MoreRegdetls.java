package pasmansite;


import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.router.Route;

import pasman.sha1;

@Route("Furthermore")
public class MoreRegdetls extends Composite<VerticalLayout> {
public MoreRegdetls() {
	/*
	VerticalLayout lay=getContent();
	EmailField fld=new EmailField();
	fld.setLabel("Email Address");
	
	lay.add(fld);
	*/
	sha1 s=new sha1("ss");
	System.out.print(s.encrypt());
}

}
