package pl.rea.client.bean;

import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pl.rea.client.service.OfferServices;
import pl.rea.client.webmethods.offers.OfferCanonical;

@SessionScoped
@ManagedBean(name="favouritesBean")
public class FavouritesBean {
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	private List<OfferCanonical> offerList;
	
	private Long offerId;
	
	//----- metody wykonujace akcje -----
	
	public void loadFavourites(){
		OfferServices service = new OfferServices();
		offerList = service.getUserFavouritesOffers(loginBean.getLogin(), loginBean.getSessionId(), loginBean.getLogin());
		if (offerList==null){
			offerList = new LinkedList<OfferCanonical>();
		}
		System.out.println("Offer list size: " + offerList.size());
	}
	
	public void deleteOffer(){
		OfferServices service = new OfferServices();
		if (service.deleteOfferFromUserFavourites(loginBean.getLogin(), loginBean.getSessionId(), offerId, loginBean.getLogin())){
			offerList = service.getUserFavouritesOffers(loginBean.getLogin(), loginBean.getSessionId(), loginBean.getLogin());
		}
	}
	
	
	//----- gettery i settery -----

	public List<OfferCanonical> getOfferList() {
		return offerList;
	}

	public void setOfferList(List<OfferCanonical> offerList) {
		this.offerList = offerList;
	}


	public LoginBean getLoginBean() {
		return loginBean;
	}


	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

}
