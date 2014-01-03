package pl.rea.client.service;

import java.util.List;

import pl.rea.client.webmethods.offers.ImageCanonical;
import pl.rea.client.webmethods.offers.OfferCanonical;
import pl.rea.client.webmethods.offers.OfferService;
import pl.rea.client.webmethods.offers.OfferService_Service;

public class OfferServices {
	
	public boolean addOffer(String login, String sessionId, OfferCanonical offer, String loginToAddOffer, List<ImageCanonical> imageList){
		OfferService_Service offerService = new OfferService_Service();
		OfferService service = offerService.getOfferServicePort();
		return service.addOffer(login, sessionId, offer, loginToAddOffer, imageList);
	}
	
	public boolean addOfferToUserFavourites(String login, String sessionId, Long offerId, String loginToAddOffer){
		OfferService_Service offerService = new OfferService_Service();
		OfferService service = offerService.getOfferServicePort();
		return service.addOfferToUserFavourites(login, sessionId, offerId, loginToAddOffer);
	}
	
	public boolean deleteOffer(String login, String sessionId, Long offerId, String loginToDeleteOffer){
		OfferService_Service offerService = new OfferService_Service();
		OfferService service = offerService.getOfferServicePort();
		return service.deleteOffer(login, sessionId, offerId, loginToDeleteOffer);
	}
	
	public boolean deleteOfferFromUserFavourites(String login, String sessionId, Long offerId, String loginToDeleteOffer){
		OfferService_Service offerService = new OfferService_Service();
		OfferService service = offerService.getOfferServicePort();
		return service.deleteOfferFromUserFavourites(login, sessionId, offerId, loginToDeleteOffer);
	}
	
	public List<OfferCanonical> findOffersByCriteria(Integer minPrice, Integer maxPrice,
			Integer minArea, Integer maxArea, Integer minFloor, Integer maxFloor,  Integer isGarage,
			String town, String estateType, String transactionType){
		OfferService_Service offerService = new OfferService_Service();
		OfferService service = offerService.getOfferServicePort();
		Boolean garage = null;
		if (minPrice==null){
			minPrice = 0;
		}
		if (maxPrice==null){
			maxPrice = 0;
		}
		if (minArea == null){
			minArea = 0;
		}
		if (maxArea == null){
			maxArea = 0;
		}
		if (minFloor == null){
			minFloor = 0;
		}
		if (maxFloor == null){
			maxFloor = 0;
		}
		if (town==null){
			town="";
		}
		if (estateType==null){
			estateType="";
		}
		if (transactionType==null){
			transactionType="";
		}
		if (isGarage==null || isGarage==0){
			garage = null;
		}
		else{
			if (isGarage==1){
				garage=true;
			}
			if (isGarage==2){
				garage=false;
			}
		}
		return service.findOffersByCriteria(minPrice, maxPrice, minArea, maxArea, minFloor, maxFloor, garage, town, estateType, transactionType);
	}
	
	public List<OfferCanonical> getAllOffers(){
		OfferService_Service offerService = new OfferService_Service();
		OfferService service = offerService.getOfferServicePort();
		return service.getAllOffers();
	}
	
	public OfferCanonical getOffer(Long id){
		OfferService_Service offerService = new OfferService_Service();
		OfferService service = offerService.getOfferServicePort();
		return service.getOffer(id);
	}
	
	public List<OfferCanonical> getUserFavouritesOffers(String login, String sessionId, String userFavouritesLogin){
		OfferService_Service offerService = new OfferService_Service();
		OfferService service = offerService.getOfferServicePort();
		return service.getUserFavouritesOffers(login, sessionId, userFavouritesLogin);
	}
	
	public boolean isOfferInUserFavourites(String login, String sessionId, Long offerId, String userFavouritesLogin){
		OfferService_Service offerService = new OfferService_Service();
		OfferService service = offerService.getOfferServicePort();
		return service.isOfferInUserFavourites(login, sessionId, offerId, userFavouritesLogin);
	}
	
	public boolean updateOffer(String login, String sessionId, OfferCanonical offer, String userLoginToUpdateOffer, List<ImageCanonical> imageList){
		OfferService_Service offerService = new OfferService_Service();
		OfferService service = offerService.getOfferServicePort();
		return service.updateOffer(login, sessionId, offer, userLoginToUpdateOffer, imageList);
	}
	
	public List<OfferCanonical> getUserOffers(String login, String sessionId, String userLoginToGetOffers){
		OfferService_Service offerService = new OfferService_Service();
		OfferService service = offerService.getOfferServicePort();
		return service.getUserOffers(login, sessionId, userLoginToGetOffers);
	}
	
	public List<ImageCanonical> getOfferImages(Long offerId){
		OfferService_Service offerService = new OfferService_Service();
		OfferService service = offerService.getOfferServicePort();
		return service.getOfferImages(offerId);
	}

}
