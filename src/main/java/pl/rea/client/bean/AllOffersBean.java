package pl.rea.client.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pl.rea.client.service.OfferServices;
import pl.rea.client.webmethods.offers.OfferCanonical;

@SessionScoped
@ManagedBean(name="allOffersBean")
public class AllOffersBean {
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	private List<OfferCanonical> offerList;
	
	private String town;
	private Integer areaMin;
	private Integer areaMax;
	private Integer priceMin;
	private Integer priceMax;
	private String estateType;
	private String transactionType;
	private Integer isGarage;
	private Integer minFloor;
	private Integer maxFloor;
	
	
	//----- metody wykonujace akcje -----
	public void loadOffers(){
		OfferServices service = new OfferServices();
		try{
			offerList = service.findOffersByCriteria(priceMin, priceMax, areaMin, areaMax, minFloor, maxFloor, isGarage, town, estateType, transactionType);
		}
		catch(Exception e){
			FacesMessage facesMessage = new FacesMessage("Błąd");
			facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
	        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	        System.out.println("AllOfferBean loadOffers: Błąd podczas wczytywania ofert " + e.getMessage());
		}
		
		town = null;
		areaMin = null;
		areaMax = null;
		priceMin = null;
		priceMax = null;
		estateType = null;
		transactionType = null;
		isGarage = null;
		minFloor = null;
		maxFloor = null;
	}
	
	public void searchOffers(){		
		OfferServices service = new OfferServices();
		try{
			offerList = service.findOffersByCriteria(priceMin, priceMax, areaMin, areaMax, minFloor, maxFloor, isGarage, town, estateType, transactionType);
		}
		catch(Exception e){
			FacesMessage facesMessage = new FacesMessage("Błąd");
			facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			System.out.println("AllOfferBean searchOffers: Błąd podczas wyszukiwania ofert " + e.getMessage());
		}
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
			System.out.println("AllOfferBean deleteOffer: Błąd podczas usuwania oferty " + e.getMessage());
		}
		if (!ok){
			FacesMessage facesMessage = new FacesMessage("Nie można usunąć oferty");
			facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
	}
	
	//----- settery i gettery -----

	public List<OfferCanonical> getOfferList() {
		OfferServices service = new OfferServices();
		try{
			offerList = service.findOffersByCriteria(priceMin, priceMax, areaMin, areaMax, minFloor, maxFloor, isGarage, town, estateType, transactionType);
		}
		catch(Exception e){
			FacesMessage facesMessage = new FacesMessage("Błąd");
			facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			System.out.println("AllOffersBean getOfferList: Błąd podczas pobierania listy ofert " + e.getMessage());
		}
		return offerList;
	}

	public void setOfferList(List<OfferCanonical> offerList) {
		this.offerList = offerList;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public Integer getAreaMin() {
		return areaMin;
	}

	public void setAreaMin(Integer areaMin) {
		this.areaMin = areaMin;
	}

	public Integer getAreaMax() {
		return areaMax;
	}

	public void setAreaMax(Integer areaMax) {
		this.areaMax = areaMax;
	}

	public Integer getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(Integer priceMin) {
		this.priceMin = priceMin;
	}

	public Integer getPriceMax() {
		return priceMax;
	}

	public void setPriceMax(Integer priceMax) {
		this.priceMax = priceMax;
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

	public Integer getIsGarage() {
		return isGarage;
	}

	public void setIsGarage(Integer isGarage) {
		this.isGarage = isGarage;
	}

	public Integer getMinFloor() {
		return minFloor;
	}

	public void setMinFloor(Integer minFloor) {
		this.minFloor = minFloor;
	}

	public Integer getMaxFloor() {
		return maxFloor;
	}

	public void setMaxFloor(Integer maxFloor) {
		this.maxFloor = maxFloor;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	
	

}
