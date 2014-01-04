package pl.rea.client.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pl.rea.client.webmethods.users.UserCanonical;

@SessionScoped
@ManagedBean(name="viewUserBean")
public class ViewUserBean {
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	private UserCanonical user;
	
	//----- settery i gettery -----

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public UserCanonical getUser() {
		return user;
	}

	public void setUser(UserCanonical user) {
		this.user = user;
	}

}
