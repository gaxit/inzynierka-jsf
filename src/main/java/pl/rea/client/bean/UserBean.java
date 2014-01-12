package pl.rea.client.bean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pl.rea.client.service.UserServices;
import pl.rea.client.webmethods.users.UserCanonical;

@SessionScoped
@ManagedBean(name="userBean")
public class UserBean {
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	private boolean editingMode = false;
	
	private UserCanonical user;
	private String login;
	
	private UserCanonical copyUser;
	
	private String email;
	private String name;
	private String phone;
	private String oldPassword;
	private String newPassword;
	private String repeatPassword;
	private String town;
	private String postalCode;
	private String street;
	private Integer houseNo;
	private Integer apartmentNo;
	
	
	//----- metody wykonujace akcje -----
	public void loadUser(){
		UserServices userService = new UserServices();
		boolean logged = false;
		logged = userService.isAnybodyLogged(loginBean.getLogin(), loginBean.getSessionId());
		if (logged){
			login = loginBean.getLogin();
			try{
				user = userService.getUser(loginBean.getLogin(), loginBean.getSessionId(), login);
			}
			catch(Exception e){
				FacesMessage facesMessage = new FacesMessage("Błąd");
				facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
				FacesContext.getCurrentInstance().addMessage(null, facesMessage);
				System.out.println("UserBean loadUser: Błąd podczas pobierania użytkownika " + e.getMessage());
			}
			if (user == null){
				FacesMessage facesMessage = new FacesMessage("Nie udało się pobrać użytkownika");
				facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
				FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			}
			editingMode = false;
		}
		else{
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
			} catch (IOException e) {
				System.out.println("Błąd podczas przekierowywania do strony logowania " + e.getMessage());
			}
		}
		
	}
	
	public void edit(){
		editingMode = true;
		
		copyUser = new UserCanonical();
		copyUser.setAddressId(user.getAddressId());
		copyUser.setApartmentNo(user.getApartmentNo());
		copyUser.setEmail(user.getEmail());
		copyUser.setHouseNo(user.getHouseNo());
		copyUser.setId(user.getId());
		copyUser.setLogin(user.getLogin());
		copyUser.setName(user.getName());
		copyUser.setPassword(user.getPassword());
		copyUser.setPhoneNumber(user.getPhoneNumber());
		copyUser.setPostalCode(user.getPostalCode());
		copyUser.setRole(user.getRole());
		copyUser.setSessionId(user.getSessionId());
		copyUser.setStreet(user.getStreet());
		copyUser.setTown(user.getTown());
		
		email = user.getEmail();
		name = user.getName();
		phone = user.getPhoneNumber();
		town = user.getTown();
		postalCode = user.getPostalCode();
		street = user.getStreet();
		houseNo = user.getHouseNo();
		apartmentNo = user.getApartmentNo();
	}
	
	public void save(){
		boolean ok = true;
		
		if (!((oldPassword == null  || oldPassword.equals("")) && (newPassword == null || newPassword.equals("")) && (repeatPassword == null || repeatPassword.equals("")))){
			if (oldPassword.equals(user.getPassword())){
				if (newPassword.equals(repeatPassword)){
					user.setPassword(newPassword);
				}
				else{
					ok = false;
					FacesMessage facesMessage = new FacesMessage("Podane hasła są różne");
					facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			        FacesContext.getCurrentInstance().addMessage("registration", facesMessage);
				}
			}
			else{
				ok = false;
				FacesMessage facesMessage = new FacesMessage("Niepoprawne hasło");
				facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
		        FacesContext.getCurrentInstance().addMessage("registration", facesMessage);
			}
		}
		
		UserServices service = new UserServices();
		if (ok){
			user.setEmail(email);
			user.setName(name);
			user.setPhoneNumber(phone);
			user.setTown(town);
			user.setPostalCode(postalCode);
			user.setStreet(street);
			user.setHouseNo(houseNo);
			user.setApartmentNo(apartmentNo);
			boolean editUser = false;
			try{
				editUser = service.editUser(loginBean.getLogin(), loginBean.getSessionId(), user);
			}
			catch(Exception e){
				FacesMessage facesMessage = new FacesMessage("Błąd");
				facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
				FacesContext.getCurrentInstance().addMessage(null, facesMessage);
				System.out.println("UserBean save: Błąd podczas edytowania użytkownika " + e.getMessage());
			}
			if (!editUser){
				user = copyUser;
				FacesMessage facesMessage = new FacesMessage("Nie można edytować użytkownika");
				facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
				FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			}
			else{
				copyUser = null;
			}
			editingMode = false;
		}
	}
	
	public void cancel(){
		editingMode = false;
	}
	
	
	//----- settery i gettery -----
	
	public UserCanonical getUser() {
		return user;
	}
	public void setUser(UserCanonical user) {
		this.user = user;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public LoginBean getLoginBean() {
		return loginBean;
	}
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	public boolean getEditingMode() {
		return editingMode;
	}
	public void setEditingMode(boolean editingMode) {
		this.editingMode = editingMode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getRepeatPassword() {
		return repeatPassword;
	}
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(Integer houseNo) {
		this.houseNo = houseNo;
	}
	public Integer getApartmentNo() {
		return apartmentNo;
	}
	public void setApartmentNo(Integer apartmentNo) {
		this.apartmentNo = apartmentNo;
	}
}
