package pl.rea.client.bean;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pl.rea.client.service.UserServices;
import pl.rea.client.webmethods.users.UserCanonical;

@SessionScoped
@ManagedBean(name="userManagementBean")
public class UserManagementBean {
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	//----- metody wykonujace akcje -----
	
	public void checkIfLogged(){
		UserServices userService = new UserServices();
		boolean logged = false;
		try{
			logged = userService.isAdminLogged(loginBean.getLogin(), loginBean.getSessionId());
		}
		catch(Exception e){
			FacesMessage facesMessage = new FacesMessage("Błąd");
			facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			System.out.println("UserManagementBean save: Błąd podczas sprawdzania zalogowania użytkownika " + e.getMessage());
		}
		if (logged){
			
		}
		else{
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
			} catch (IOException e) {
				System.out.println("Błąd podczas przekierowywania do strony logowania " + e.getMessage());
			}
		}
	}
	
	public List<UserCanonical> getUserList(){
		UserServices service = new UserServices();
		List<UserCanonical> userList = null;
		try{
			userList = service.getUserList(loginBean.getLogin(), loginBean.getSessionId());
		}
		catch(Exception e){
			FacesMessage facesMessage = new FacesMessage("Błąd");
			facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			System.out.println("UserManagementBean getUserList: Błąd podczas pobierania listy użytkowników " + e.getMessage());
		}
		return userList;
	}
	
	public void deleteUser(){
		FacesContext context = FacesContext.getCurrentInstance();
		String login = context.getExternalContext().getRequestParameterMap().get("userLogin");
		if (loginBean.getLogin().equals(login)){
			FacesMessage facesMessage = new FacesMessage("Nie można usunąć własnego konta");
			facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
	        FacesContext.getCurrentInstance().addMessage("registration", facesMessage);
		}
		else{
			UserServices service = new UserServices();
			boolean delete = false;
			try{
				delete = service.deleteUser(loginBean.getLogin(), loginBean.getSessionId(), login);
			}
			catch(Exception e){
				FacesMessage facesMessage = new FacesMessage("Błąd");
				facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
				FacesContext.getCurrentInstance().addMessage(null, facesMessage);
				System.out.println("UserManagementBean deleteUser: Błąd podczas usuwania użytkownika " + e.getMessage());
			}
			if (!delete){
				FacesMessage facesMessage = new FacesMessage("Nie można usunąć użytkownika");
				facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
				FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			}
		}
	}
	
	//----- settery i gettery -----

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

}
