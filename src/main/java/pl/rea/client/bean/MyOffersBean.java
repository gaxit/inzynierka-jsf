package pl.rea.client.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import pl.rea.client.service.OfferServices;
import pl.rea.client.webmethods.offers.OfferCanonical;

@ManagedBean(name="myOffersBean")
public class MyOffersBean {
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	private List<OfferCanonical> myOfferList;
	
	//----- metody wykonujace akcje -----
	
	public void loadOffers(){
		OfferServices service = new OfferServices();
		myOfferList = service.getUserOffers(loginBean.getLogin(), loginBean.getSessionId(), loginBean.getLogin());
	}
	
	public void deleteOffer(){
		FacesContext context = FacesContext.getCurrentInstance();
		int offerId = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("offerToDelete"));
		String owner = context.getExternalContext().getRequestParameterMap().get("offerOwner");
		OfferServices service = new OfferServices();
		service.deleteOffer(loginBean.getLogin(), loginBean.getSessionId(), (long)offerId, owner);
	}

	//----- settery i gettery -----

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public List<OfferCanonical> getMyOfferList() {
		OfferServices service = new OfferServices();
		myOfferList = service.getUserOffers(loginBean.getLogin(), loginBean.getSessionId(), loginBean.getLogin());
		return myOfferList;
	}

	public void setMyOfferList(List<OfferCanonical> myOfferList) {
		this.myOfferList = myOfferList;
	}

}
