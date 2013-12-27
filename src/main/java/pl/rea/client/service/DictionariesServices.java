package pl.rea.client.service;

import java.util.List;

import pl.rea.client.webmethods.dictionaries.DicsService;
import pl.rea.client.webmethods.dictionaries.DicsService_Service;

public class DictionariesServices {
	
	public List<String> getEstateTypeList(){
		DicsService_Service dicsService = new DicsService_Service();
		DicsService service = dicsService.getDicsServicePort();
		return service.getEstateTypeList();
	}
	
	public List<String> getTransactionTypeList(){
		DicsService_Service dicsService = new DicsService_Service();
		DicsService service = dicsService.getDicsServicePort();
		return service.getTransactionTypeList();
	}
	
	public List<String> getRoleList(){
		DicsService_Service dicsService = new DicsService_Service();
		DicsService service = dicsService.getDicsServicePort();
		return service.getRoleList();
	}

}
