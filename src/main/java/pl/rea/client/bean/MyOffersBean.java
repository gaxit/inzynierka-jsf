package pl.rea.client.bean;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import pl.rea.client.service.OfferServices;
import pl.rea.client.service.UserServices;
import pl.rea.client.webmethods.offers.OfferCanonical;

@ManagedBean(name="myOffersBean")
public class MyOffersBean {
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	private List<OfferCanonical> myOfferList;
	
	//----- metody wykonujace akcje -----
	
	public void checkIfLogged(){
		UserServices userService = new UserServices();
		boolean logged = false;
		try{
			logged = userService.isAnybodyLogged(loginBean.getLogin(), loginBean.getSessionId());
		}
		catch(Exception e){
			FacesMessage facesMessage = new FacesMessage("Błąd");
			facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			System.out.println("MyOffersBean checkIfLogged: Błąd podczas logowania " + e.getMessage());
		}
		if (logged){
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
		FacesContext context = FacesContext.getCurrentInstance();
		int offerId = Integer.parseInt(context.getExternalContext().getRequestParameterMap().get("offerToDelete"));
		String owner = context.getExternalContext().getRequestParameterMap().get("offerOwner");
		OfferServices service = new OfferServices();
		try{
			if (service.deleteOffer(loginBean.getLogin(), loginBean.getSessionId(), (long)offerId, owner)){
				
			}
			else{
				FacesMessage facesMessage = new FacesMessage("Nie można usunąć oferty");
				facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
				FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			}
		}
		catch(Exception e){
			FacesMessage facesMessage = new FacesMessage("Błąd");
			facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			System.out.println("MyOffersBean deleteOffer: Błąd podczas usuwania oferty " + e.getMessage());
		}
	}
	
	public List<OfferCanonical> getMyOfferList() {
		OfferServices service = new OfferServices();
		try{
			myOfferList = service.getUserOffers(loginBean.getLogin(), loginBean.getSessionId(), loginBean.getLogin());
		}
		catch(Exception e){
			FacesMessage facesMessage = new FacesMessage("Błąd");
			facesMessage.setSeverity(FacesMessage.SEVERITY_FATAL);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			System.out.println("MyOffersBean getMyOfferList: Błąd podczas pobierania listy ofert użytkownika " + e.getMessage());
		}
		return myOfferList;
	}

	//----- settery i gettery -----

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public void setMyOfferList(List<OfferCanonical> myOfferList) {
		this.myOfferList = myOfferList;
	}

}
