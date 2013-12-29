package pl.rea.client.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

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
		editingMode = false;
		
		login = loginBean.getLogin();
		UserServices service = new UserServices();
		user = service.getUser(loginBean.getLogin(), loginBean.getSessionId(), login);
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
		editingMode = false;
		
		user.setEmail(email);
		user.setName(name);
		user.setPhoneNumber(phone);
		user.setTown(town);
		user.setPostalCode(postalCode);
		user.setStreet(street);
		user.setHouseNo(houseNo);
		user.setApartmentNo(apartmentNo);
		
		UserServices service = new UserServices();
		if (!service.editUser(loginBean.getLogin(), loginBean.getSessionId(), user)){
			user = copyUser;
		}
		else{
			copyUser = null;
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
