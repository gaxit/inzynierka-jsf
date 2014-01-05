package pl.rea.client.bean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pl.rea.client.service.UserServices;
import pl.rea.client.webmethods.users.UserCanonical;

@SessionScoped
@ManagedBean(name="registrationBean")
public class RegistrationBean {
	
	private String login;
	private String password;
	private String passwordRepeat;
	private String name;
	private String phone;
	private String email;
	private String town;
	private String street;
	private Integer houseNo;
	private Integer apartmentNo;
	private String postalCode;
	
	//----- metody wykonujace akcje -----
	
	public void register(){
		boolean ok = true;
		if (!password.equals(passwordRepeat)){
			FacesMessage facesMessage = new FacesMessage("Podane hasła są różne");
			facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
	        FacesContext.getCurrentInstance().addMessage("registration", facesMessage);
	        ok = false;
		}
		
		UserServices service = new UserServices();
		if (service.userExists(login)){
			FacesMessage facesMessage = new FacesMessage("Użytkownik o podanym loginie istnieje");
			facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
	        FacesContext.getCurrentInstance().addMessage("registration", facesMessage);
	        ok = false;
		}
		
		if (ok){			
			UserCanonical user = new UserCanonical();
			user.setApartmentNo(apartmentNo);
			user.setEmail(email);
			user.setHouseNo(houseNo);
			user.setLogin(login);
			user.setName(name);
			user.setPassword(password);
			user.setPhoneNumber(phone);
			user.setPostalCode(postalCode);
			user.setRole("Uzytkownik");
			user.setStreet(street);
			user.setTown(town);
			
			if (service.createUser(user)){
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
				} catch (IOException e) {
					System.out.println("RegistrationBean register exception: " + e.getMessage());
				}
			}
			else{
				FacesMessage facesMessage = new FacesMessage("Rejestracja nie powiodła się");
				facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
		        FacesContext.getCurrentInstance().addMessage("registration", facesMessage);
			}
			login = null;
			password = null;
			passwordRepeat = null;
			name = null;
			phone = null;
			email = null;
			town = null;
			street = null;
			houseNo = null;
			apartmentNo = null;
			postalCode = null;
		}
	}
	
	
	//----- gettery i settery -----
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
	public String getPasswordRepeat() {
		return passwordRepeat;
	}
	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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
