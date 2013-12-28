package pl.rea.client.webmethods.dictionaries;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "DicsService", targetNamespace = "dictionaries")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface DicsService {


    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod(action = "getEstateTypeList")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getEstateTypeList", targetNamespace = "dictionaries", className = "dictionaries.GetEstateTypeList")
    @ResponseWrapper(localName = "getEstateTypeListResponse", targetNamespace = "dictionaries", className = "dictionaries.GetEstateTypeListResponse")
    public List<String> getEstateTypeList();

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod(action = "getRoleList")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getRoleList", targetNamespace = "dictionaries", className = "dictionaries.GetRoleList")
    @ResponseWrapper(localName = "getRoleListResponse", targetNamespace = "dictionaries", className = "dictionaries.GetRoleListResponse")
    public List<String> getRoleList();

    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod(action = "getTransactionTypeList")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getTransactionTypeList", targetNamespace = "dictionaries", className = "dictionaries.GetTransactionTypeList")
    @ResponseWrapper(localName = "getTransactionTypeListResponse", targetNamespace = "dictionaries", className = "dictionaries.GetTransactionTypeListResponse")
    public List<String> getTransactionTypeList();

}