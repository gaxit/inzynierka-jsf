package test;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;



@ManagedBean(name="testBean")
public class TestBean {
	public void testRedirect(){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
		} catch (IOException e) {
			System.err.println("Błąd podczas przekierowywania");
		}
	}

}