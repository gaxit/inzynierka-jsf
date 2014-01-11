package pl.rea.client.bean;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.faces.application.FacesMessage;
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
		boolean logged = false;
		try{
			logged = userService.isAnybodyLogged(loginBean.getLogin(), loginBean.getSessionId());
		}
		catch(Exception e){
			FacesMessage facesMessage = new FacesMessage("Błąd");
			facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			System.out.println("FavouritesBean loadFavourites: Błąd podczas sprawdzania zalogowania " + e.getMessage());
		}
		if (logged){
			OfferServices service = new OfferServices();
			try{
				offerList = service.getUserFavouritesOffers(loginBean.getLogin(), loginBean.getSessionId(), loginBean.getLogin());
			}
			catch(Exception e){
				FacesMessage facesMessage = new FacesMessage("Błąd");
				facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
				FacesContext.getCurrentInstance().addMessage(null, facesMessage);
				System.out.println("FavouritesBean loadFavourites: Błąd podczas wczytywania ulubionych ofert " + e.getMessage());
			}
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
		try{
			if (service.deleteOfferFromUserFavourites(loginBean.getLogin(), loginBean.getSessionId(), offerId, loginBean.getLogin())){
				offerList = service.getUserFavouritesOffers(loginBean.getLogin(), loginBean.getSessionId(), loginBean.getLogin());
			}
			else{
				FacesMessage facesMessage = new FacesMessage("Nie można usunąć oferty z ulubionych");
				facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
				FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			}
		}
		catch(Exception e){
			FacesMessage facesMessage = new FacesMessage("Błąd");
			facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			System.out.println("FavouritesBean deleteOffer: Błąd podczas usuwania oferty z ulubionych " + e.getMessage());
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
