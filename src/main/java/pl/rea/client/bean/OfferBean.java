package pl.rea.client.bean;

import java.io.ByteArrayInputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import pl.rea.client.service.OfferServices;
import pl.rea.client.webmethods.offers.OfferCanonical;

@SessionScoped
@ManagedBean(name="offerBean")
public class OfferBean {
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	private OfferCanonical offer;
	
	public StreamedContent getImage(){
        FacesContext context = FacesContext.getCurrentInstance();

        if (context.getRenderResponse()) {
            return new DefaultStreamedContent();
        }
        else {
        	byte[] byteArray = null;
        	String id = context.getExternalContext().getRequestParameterMap().get("name");
        	for (int i=0;i<offer.getImages().size();i++){
        		if (offer.getImages().get(i).getFileName().equals(id)){
        			byteArray = offer.getImages().get(i).getImage();
        		}
        	}
            return new DefaultStreamedContent(new ByteArrayInputStream(byteArray));
        }
    }
	
	public boolean getFavouriteRender(){
		OfferServices service = new OfferServices();
		return service.isOfferInUserFavourites(loginBean.getLogin(), loginBean.getSessionId(), offer.getId(), loginBean.getLogin());
	}
	
	//----- settery i gettery -----

	public OfferCanonical getOffer() {
		return offer;
	}

	public void setOffer(OfferCanonical offer) {
		this.offer = offer;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	
}
