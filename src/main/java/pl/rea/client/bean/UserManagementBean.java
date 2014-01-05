package pl.rea.client.bean;

import java.util.List;

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
		UserServices service = new UserServices();
		FacesContext context = FacesContext.getCurrentInstance();
		String login = context.getExternalContext().getRequestParameterMap().get("userLogin");
	}
	
	//----- settery i gettery -----

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

}
