package pl.rea.client.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import pl.rea.client.service.OfferServices;
import pl.rea.client.webmethods.offers.OfferCanonical;

@ManagedBean(name="myOffersBean")
public class MyOffersBean {
	
	private List<OfferCanonical> offerList;
	
	//----- metody wykonujace akcje -----
	
	public void loadOffers(){
		OfferServices service = new OfferServices();
//		offerList = service.get
	}

	//----- settery i gettery -----
	
	public List<OfferCanonical> getOfferList() {
		return offerList;
	}

	public void setOfferList(List<OfferCanonical> offerList) {
		this.offerList = offerList;
	}

}
