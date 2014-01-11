package pl.rea.client.bean;

import java.io.ByteArrayInputStream;
import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
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
	
	public void deleteImage(){
		FacesContext context = FacesContext.getCurrentInstance();
		int imgId = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("imgInd"));
		imageList.remove(imgId);
	}
	
	public void uploadFile(FileUploadEvent event){
		ImageCanonical img = new ImageCanonical();
		String[] tab = event.getFile().getFileName().split("\\.");
		String newName = tab[0] + "_" + System.currentTimeMillis() + "." + tab[1];
		img.setFileName(newName);
		img.setImage(event.getFile().getContents());
		imageList.add(img);
	}
	
	public void edit(){
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
		
		OfferServices service = new OfferServices();
		try{
			imageList = service.getOfferImages(offer.getId());
		}
		catch(Exception e){
			FacesMessage facesMessage = new FacesMessage("Błąd");
			facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			System.out.println("OfferBean edit: Błąd podczas pobierania zdjęć oferty " + e.getMessage());
		}
		
		if (imageList==null){
			imageList = new LinkedList<ImageCanonical>();
		}
	}
	
	public void update(){
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
		System.out.println("Imagelist size: " + imageList.size());
		
		OfferServices service = new OfferServices();
		boolean ok = false;
		try{
			ok = service.updateOffer(loginBean.getLogin(), loginBean.getSessionId(), offer, offer.getOwner(), imageList);
		}
		catch(Exception e){
			FacesMessage facesMessage = new FacesMessage("Błąd");
			facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			System.out.println("OfferBean update: Błąd podczas aktualizowania oferty " + e.getMessage());
		}
		if (!ok){
			offer = copyOffer;
		}
		else{
			copyOffer = null;
		}
		
		editingMode = false;
	}
	
	public void cancel(){
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
        	for (int i=0;i<imageList.size();i++){
        		if (imageList.get(i).getFileName().equals(id)){
        			byteArray = imageList.get(i).getImage();
        		}
        	}
            return new DefaultStreamedContent(new ByteArrayInputStream(byteArray));
        }
    }
	
	public boolean getFavouriteRender(){
		OfferServices service = new OfferServices();
		boolean ok = false;
		try{
			ok = service.isOfferInUserFavourites(loginBean.getLogin(), loginBean.getSessionId(), offer.getId(), loginBean.getLogin());
		}
		catch(Exception e){
			FacesMessage facesMessage = new FacesMessage("Błąd");
			facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			System.out.println("OfferBean getFavouriteRender: Błąd podczas sprawdzania, czy oferta jest w ulubionych użytkownika " + e.getMessage());
		}		
		return ok;
	}
	
	public void addToFavourites(){
		OfferServices service = new OfferServices();
		boolean ok = false;
		try{
			ok = service.addOfferToUserFavourites(loginBean.getLogin(), loginBean.getSessionId(), offer.getId(), loginBean.getLogin());
		}
		catch(Exception e){
			FacesMessage facesMessage = new FacesMessage("Błąd");
			facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			System.out.println("OfferBean edit: Błąd podczas dodawania oferty do ulubionych " + e.getMessage());
		}
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
	
	public void setOffer(OfferCanonical offer) {
		this.offer = offer;
		editingMode = false;
		OfferServices service = new OfferServices();
		try{
			imageList = service.getOfferImages(offer.getId());
		}
		catch(Exception e){
			FacesMessage facesMessage = new FacesMessage("Błąd");
			facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			System.out.println("OfferBean setOffer: Błąd podczas pobierania zdjęć oferty " + e.getMessage());
		}
	}
	
	//----- settery i gettery -----

	public OfferCanonical getOffer() {
		return offer;
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
