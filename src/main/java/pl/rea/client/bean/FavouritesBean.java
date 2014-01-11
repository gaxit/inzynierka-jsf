package pl.rea.client.bean;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pl.rea.client.service.OfferServices;
import pl.rea.client.service.UserServices;
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
		UserServices userService = new UserServices();
		if (userService.isAnybodyLogged(loginBean.getLogin(), loginBean.getSessionId())){
			OfferServices service = new OfferServices();
			offerList = service.getUserFavouritesOffers(loginBean.getLogin(), loginBean.getSessionId(), loginBean.getLogin());
			if (offerList==null){
				offerList = new LinkedList<OfferCanonical>();
			}
		}
		else{
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
			} catch (IOException e) {
				System.out.println("Błąd podczas przekierowywania do strony logowania " + e.getMessage());
			}
		}		
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
