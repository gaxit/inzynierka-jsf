package pl.rea.client.bean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pl.rea.client.service.UserServices;

@SessionScoped
@ManagedBean(name="loginBean")
public class LoginBean {
	
	private String login;
	private String password;
	
	private String sessionId;
	private boolean logged = false;
	private boolean userLogged = false;
	private boolean adminLogged = false;
	
	//----- metody wykonujace akcje -----
	
	public void logIn(){
		UserServices service = new UserServices();
		try{
			sessionId = service.logIn(login, password);
		}
		catch(Exception e){
			FacesMessage facesMessage = new FacesMessage("Błąd");
			facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			System.out.println("LoginBean logIn: Błąd podczas logowania");
		}
		if (sessionId != null){
			logged = true;
			adminLogged = service.isAdminLogged(login, sessionId);
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
			} catch (IOException e) {
				System.out.println("LoginBean logIn exception: " + e.getMessage());
			}
		}
		else{
			FacesMessage facesMessage = new FacesMessage("Błędny login lub hasło");
			facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
	        FacesContext.getCurrentInstance().addMessage("login", facesMessage);
		}
	}
	
	public void logout(){
		UserServices service = new UserServices();
		boolean ok = false;
		try{
			ok = service.logOut(login, sessionId);
		}
		catch(Exception e){
			FacesMessage facesMessage = new FacesMessage("Błąd");
			facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			System.out.println("LoginBean logout: Błąd podczas wylogowania");
		}
		if (ok){
			login = null;
			password = null;
			sessionId = null;
			logged = false;
			userLogged = false;
			adminLogged = false;
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
			} catch (IOException e) {
				System.out.println("LoginBean logIn exception: " + e.getMessage());
			}
		}
		else{
			FacesMessage facesMessage = new FacesMessage("Wylogowanie nie było możliwe");
			facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
	}
	
	//----- settery i gettery -----------
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public boolean getUserLogged() {
		return userLogged;
	}

	public void setUserLogged(boolean isUserLogged) {
		this.userLogged = isUserLogged;
	}

	public boolean getAdminLogged() {
		return adminLogged;
	}

	public void setAdminLogged(boolean isAdminLogged) {
		this.adminLogged = isAdminLogged;
	}

	public boolean getLogged() {
		return logged;
	}

	public void setLogged(boolean isLogged) {
		this.logged = isLogged;
	}

}
