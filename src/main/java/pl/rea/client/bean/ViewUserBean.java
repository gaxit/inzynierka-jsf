package pl.rea.client.bean;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pl.rea.client.service.OfferServices;
import pl.rea.client.service.UserServices;
import pl.rea.client.webmethods.offers.OfferCanonical;
import pl.rea.client.webmethods.users.UserCanonical;

@SessionScoped
@ManagedBean(name="viewUserBean")
public class ViewUserBean {
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	private UserCanonical user;
	
	private boolean editingMode;
	
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
			System.out.println("ViewUserBean checiIfLogged: Błąd podczas sprawdzania zalogowania użytkownika " + e.getMessage());
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
	
	public List<OfferCanonical> getOfferList(){
		OfferServices service = new OfferServices();
		UserServices userService = new UserServices();
		boolean adminLogged = false;
		try{
			adminLogged = userService.isAdminLogged(loginBean.getLogin(), loginBean.getSessionId());
		}
		catch(Exception e){
			FacesMessage facesMessage = new FacesMessage("Błąd");
			facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			System.out.println("ViewUserBean checiIfLogged: Błąd podczas sprawdzania zalogowania użytkownika " + e.getMessage());
		}
		if (adminLogged){
			List<OfferCanonical> offerList = null;
			try{
				offerList = service.getUserOffers(loginBean.getLogin(), loginBean.getSessionId(), user.getLogin());
			}
			catch(Exception e){
				FacesMessage facesMessage = new FacesMessage("Błąd");
				facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
				FacesContext.getCurrentInstance().addMessage(null, facesMessage);
				System.out.println("ViewUserBean getOfferList: Błąd podczas pobierania ofert użytkownika " + e.getMessage());
			}
			return offerList;
		}
		return null;
	}
	
	public void deleteOffer(){
		FacesContext context = FacesContext.getCurrentInstance();
		int offerId = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("offerToDelete"));
		String owner = context.getExternalContext().getRequestParameterMap().get("offerOwner");
		OfferServices service = new OfferServices();
		boolean ok = false;
		try{
			ok = service.deleteOffer(loginBean.getLogin(), loginBean.getSessionId(), (long)offerId, owner);
		}
		catch(Exception e){
			FacesMessage facesMessage = new FacesMessage("Błąd");
			facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			System.out.println("ViewUserBean deleteOffer: Błąd podczas usuwania oferty " + e.getMessage());
		}
		if (!ok){
			FacesMessage facesMessage = new FacesMessage("Nie można usunąć oferty");
			facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
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
			boolean canEdit = false;
			canEdit = service.editUser(loginBean.getLogin(), loginBean.getSessionId(), user);
			if (!canEdit){
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

	public boolean isEditingMode() {
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
