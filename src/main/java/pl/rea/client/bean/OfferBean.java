package pl.rea.client.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import pl.rea.client.webmethods.offers.OfferCanonical;

@SessionScoped
@ManagedBean(name="offerBean")
public class OfferBean {
	
	private OfferCanonical offer;
	
	//----- settery i gettery -----

	public OfferCanonical getOffer() {
		return offer;
	}

	public void setOffer(OfferCanonical offer) {
		this.offer = offer;
	}
	
	

}
