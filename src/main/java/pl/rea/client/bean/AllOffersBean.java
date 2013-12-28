package pl.rea.client.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import pl.rea.client.service.OfferServices;
import pl.rea.client.webmethods.offers.OfferCanonical;

@SessionScoped
@ManagedBean(name="allOffersBean")
public class AllOffersBean {
	
	private List<OfferCanonical> offerList;
	
	private String town;
	private Integer areaMin;
	private Integer areaMax;
	private Integer priceMin;
	private Integer priceMax;
	private String estateType;
	private String transactionType;
	private Boolean isGarage;
	private Integer minFloor;
	private Integer maxFloor;
	
	
	//----- metody wykonujace akcje -----
	public void loadOffers(){
		OfferServices service = new OfferServices();
		offerList = service.getAllOffers();
		
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
//		System.out.println("Miasto: " + town);
//		System.out.println("Min powierzchnia: " + areaMin);
//		System.out.println("Max powierzchnia: " + areaMax);
//		System.out.println("Min cena: " + priceMin);
//		System.out.println("Max cena: " + priceMax);
		System.out.println("Typ nieruchomosci: " + estateType);
		System.out.println("Typ transakcji: " + transactionType);
		System.out.println("Garaz: " + isGarage);
//		System.out.println("Pietro min: " + minFloor);
//		System.out.println("Pietro max: " + maxFloor);
		
//		OfferServices service = new OfferServices();
//		offerList = service.findOffersByCriteria(priceMin, priceMax, areaMin, areaMax, minFloor, maxFloor, isGarage, town, estateType, transactionType);
	}
	
	//----- settery i gettery -----

	public List<OfferCanonical> getOfferList() {
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

	public Boolean getIsGarage() {
		return isGarage;
	}

	public void setIsGarage(Boolean isGarage) {
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
	
	

}
