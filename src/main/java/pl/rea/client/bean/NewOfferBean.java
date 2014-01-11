package pl.rea.client.bean;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import pl.rea.client.service.OfferServices;
import pl.rea.client.service.UserServices;
import pl.rea.client.webmethods.offers.ImageCanonical;
import pl.rea.client.webmethods.offers.OfferCanonical;

@SessionScoped
@ManagedBean(name="newOfferBean")
public class NewOfferBean {
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	private String offerName;
	
	private Integer area;
	private String description;
	private String estateType;
	private Integer price;
	private String transactionType;
	private Integer floor;
	private Boolean garage;
	
	private Integer apartmentNo;
	private String street;
	private String town;
	private Integer houseNo;
	private String postalCode;
	
	private List<ImageCanonical> imagesList = new LinkedList<ImageCanonical>();
	
	//----- metody wykonujące akcje -----
	
	public void checkIfLogged(){
		UserServices userService = new UserServices();
		boolean logged = false;
		try{
			logged = userService.isAnybodyLogged(loginBean.getLogin(), loginBean.getSessionId());
		}
		catch(Exception e){
			FacesMessage facesMessage = new FacesMessage("Błąd");
			facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			System.out.println("NewOfferBean ckeckIfLogged: Błąd podczas sprawdzania zalogowania " + e.getMessage());
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
	
	public void uploadFile(FileUploadEvent event){
		ImageCanonical img = new ImageCanonical();
		String[] tab = event.getFile().getFileName().split("\\.");
		String newName = tab[0] + "_" + System.currentTimeMillis() + "." + tab[1];
		img.setFileName(newName);
		img.setImage(event.getFile().getContents());
		imagesList.add(img);
	}
	
	public void addOffer(){		
		OfferCanonical offer = new OfferCanonical();
		offer.setApartmentNo(apartmentNo);
		offer.setArea(area);
		offer.setDescription(description);
		offer.setEstateType(estateType);
		offer.setFloor(floor);
		offer.setGarage(garage);
		offer.setHouseNo(houseNo);
		offer.setOfferName(offerName);
		offer.setOwner(loginBean.getLogin());
		offer.setPostalCode(postalCode);
		offer.setPrice(price);
		offer.setStreet(street);
		offer.setTown(town);
		offer.setTransactionType(transactionType);
		
		OfferServices service = new OfferServices();
		boolean ok = false;
		try{
			ok = service.addOffer(loginBean.getLogin(), loginBean.getSessionId(), offer, loginBean.getLogin(), imagesList);
		}
		catch(Exception e){
			FacesMessage facesMessage = new FacesMessage("Błąd");
			facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			System.out.println("NewOfferBean addOffer: Błąd podczas dodawania oferty " + e.getMessage());
		}
		if (!ok){
			FacesMessage facesMessage = new FacesMessage("Nie można dodać oferty");
			facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		
		offerName = null;
		area = null;
		description = null;
		estateType = null;
		price = null;
		transactionType = null;
		floor = null;
		garage = null;
		apartmentNo = null;
		street = null;
		town = null;
		houseNo = null;
		postalCode = null;
		imagesList = new LinkedList<ImageCanonical>();
	}
	
	public void cancel(){
		offerName = null;
		area = null;
		description = null;
		estateType = null;
		price = null;
		transactionType = null;
		floor = null;
		garage = null;
		apartmentNo = null;
		street = null;
		town = null;
		houseNo = null;
		postalCode = null;
		imagesList = new LinkedList<ImageCanonical>();
	}
	
	public void deleteImage(){
		FacesContext context = FacesContext.getCurrentInstance();
		int imgId = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("imgIndex"));
		imagesList.remove(imgId);
	}
	
	//----- settery i gettery -----
	
	public String getOfferName() {
		return offerName;
	}
	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEstateType() {
		return estateType;
	}
	public void setEstateType(String estateType) {
		this.estateType = estateType;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public Boolean getGarage() {
		return garage;
	}
	public void setGarage(Boolean garage) {
		this.garage = garage;
	}
	public Integer getApartmentNo() {
		return apartmentNo;
	}
	public void setApartmentNo(Integer apartmentNo) {
		this.apartmentNo = apartmentNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public Integer getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(Integer houseNo) {
		this.houseNo = houseNo;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public List<ImageCanonical> getImagesList() {
		return imagesList;
	}

	public void setImagesList(List<ImageCanonical> imagesList) {
		this.imagesList = imagesList;
	}

}
