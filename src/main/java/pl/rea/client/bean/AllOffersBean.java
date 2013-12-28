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
	
	public void loadOffers(){
		OfferServices service = new OfferServices();
		offerList = service.getAllOffers();
	}

	public List<OfferCanonical> getOfferList() {
		return offerList;
	}

	public void setOfferList(List<OfferCanonical> offerList) {
		this.offerList = offerList;
	}
	
	

}
