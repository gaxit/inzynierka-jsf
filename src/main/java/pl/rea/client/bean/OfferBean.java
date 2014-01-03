package pl.rea.client.bean;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import pl.rea.client.service.OfferServices;
import pl.rea.client.webmethods.offers.ImageCanonical;
import pl.rea.client.webmethods.offers.OfferCanonical;

@SessionScoped
@ManagedBean(name="offerBean")
public class OfferBean {
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	private OfferCanonical offer;
	private OfferCanonical copyOffer;
	
	private boolean editingMode;
	
	private String offerName;
	private Integer area;
	private Integer price;
	private String estateType;
	private String transactionType;
	private String description;
	private Integer floor;
	private Boolean garage;
	
	private String postalCode;
	private String town;
	private String street;
	private Integer houseNo;
	private Integer apartmentNo;
	private List<ImageCanonical> imageList;
	
	
	//----- metody wykonujace akcje -----
	
//	public void redirectToOffer(){
////		Integer id = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("offerId"));
////		OfferServices service = new OfferServices();
////		offer = service.getOffer((long)id);
//		try {
//			FacesContext.getCurrentInstance().getExternalContext().redirect("offer.xhtml");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public void edit(){
		System.out.println("Edytowanie oferty");
		editingMode = true;
		
		copyOffer = new OfferCanonical();
		
		copyOffer.setAddressId(offer.getAddressId());
		copyOffer.setApartmentNo(offer.getApartmentNo());
		copyOffer.setArea(offer.getArea());
		copyOffer.setDescription(offer.getDescription());
		copyOffer.setEstateType(offer.getEstateType());
		copyOffer.setFloor(offer.getFloor());
		copyOffer.setGarage(offer.isGarage());
		copyOffer.setHouseNo(offer.getHouseNo());
		copyOffer.setId(offer.getId());
		copyOffer.setImages(offer.getImages());
		copyOffer.setOfferName(offer.getOfferName());
		copyOffer.setOwner(offer.getOwner());
		copyOffer.setPostalCode(offer.getPostalCode());
		copyOffer.setPrice(offer.getPrice());
		copyOffer.setStreet(offer.getStreet());
		copyOffer.setTown(offer.getTown());
		copyOffer.setTransactionType(offer.getTransactionType());
		
		offerName = offer.getOfferName();
		area = offer.getArea();
		price = offer.getPrice();
		estateType = offer.getEstateType();
		transactionType = offer.getTransactionType();
		description = offer.getDescription();
		floor = offer.getFloor();
		garage = offer.isGarage();
		postalCode = offer.getPostalCode();
		town = offer.getTown();
		street = offer.getStreet(); 
		houseNo = offer.getHouseNo();
		apartmentNo = offer.getApartmentNo();
		imageList = offer.getImages();
	}
	
	public void update(){
		System.out.println("Zmienianie oferty");
		
		offer.setOfferName(offerName);
		offer.setArea(area);
		offer.setPrice(price);
		offer.setEstateType(estateType);
		offer.setTransactionType(transactionType);
		offer.setDescription(description);
		offer.setFloor(floor);
		offer.setGarage(garage);
		offer.setPostalCode(postalCode);
		offer.setTown(town);
		offer.setStreet(street);
		offer.setHouseNo(houseNo);
		offer.setApartmentNo(apartmentNo);
		offer.setImages(imageList);
		
		OfferServices service = new OfferServices();
		System.out.println("Update ok?: " + service.updateOffer(loginBean.getLogin(), loginBean.getSessionId(), offer, offer.getOwner()));
//		if (!service.updateOffer(loginBean.getLogin(), loginBean.getSessionId(), offer, offer.getOwner())){
//			offer = copyOffer;
//		}
//		else{
//			copyOffer = null;
//		}
		
		editingMode = false;
	}
	
	public void cancel(){
		System.out.println("Anulowanie zmian w ofercie");
		editingMode = false;
	}
	
	public void loadPage(){
		editingMode = false;
	}
	
	public StreamedContent getImage(){
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getRenderResponse()) {
            return new DefaultStreamedContent();
        }
        else {
        	byte[] byteArray = null;
        	String id = context.getExternalContext().getRequestParameterMap().get("name");
        	for (int i=0;i<offer.getImages().size();i++){
        		if (offer.getImages().get(i).getFileName().equals(id)){
        			byteArray = offer.getImages().get(i).getImage();
        		}
        	}
            return new DefaultStreamedContent(new ByteArrayInputStream(byteArray));
        }
    }
	
	public boolean getFavouriteRender(){
		OfferServices service = new OfferServices();
		return service.isOfferInUserFavourites(loginBean.getLogin(), loginBean.getSessionId(), offer.getId(), loginBean.getLogin());
	}
	
	public void addToFavourites(){
		OfferServices service = new OfferServices();
		System.out.println("Dodano do ulubionych?: " + service.addOfferToUserFavourites(loginBean.getLogin(), loginBean.getSessionId(), offer.getId(), loginBean.getLogin()));
	}
	
	public boolean getRenderEdit(){
		if (loginBean.getLogin()==null){
			return false;
		}
		if (loginBean.getLogin().equals(offer.getOwner()) || loginBean.getAdminLogged()){
			return true;
		}
		return false;
	}
	
	//----- settery i gettery -----

	public OfferCanonical getOffer() {
		return offer;
	}

	public void setOffer(OfferCanonical offer) {
		this.offer = offer;
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

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getEstateType() {
		return estateType;
	}

	public void setEstateType(String estateType) {
		this.estateType = estateType;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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

	public List<ImageCanonical> getImageList() {
		return imageList;
	}

	public void setImageList(List<ImageCanonical> imageList) {
		this.imageList = imageList;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}
	
}
