package pl.rea.client.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;

import pl.rea.client.service.UserServices;
import pl.rea.client.webmethods.users.UserCanonical;

@SessionScoped
@ManagedBean(name="userManagementBean")
public class UserManagementBean {
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	//----- metody wykonujace akcje -----
	
	public List<UserCanonical> getUserList(){
		UserServices service = new UserServices();
		return service.getUserList(loginBean.getLogin(), loginBean.getSessionId());
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
			service.deleteUser(loginBean.getLogin(), loginBean.getSessionId(), login);
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
