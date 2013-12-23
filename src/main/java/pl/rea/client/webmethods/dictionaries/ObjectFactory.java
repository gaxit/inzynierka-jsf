package pl.rea.client.webmethods.dictionaries;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dictionaries package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetEstateTypeList_QNAME = new QName("dictionaries", "getEstateTypeList");
    private final static QName _GetRoleList_QNAME = new QName("dictionaries", "getRoleList");
    private final static QName _GetRoleListResponse_QNAME = new QName("dictionaries", "getRoleListResponse");
    private final static QName _GetEstateTypeListResponse_QNAME = new QName("dictionaries", "getEstateTypeListResponse");
    private final static QName _GetTransactionTypeList_QNAME = new QName("dictionaries", "getTransactionTypeList");
    private final static QName _GetTransactionTypeListResponse_QNAME = new QName("dictionaries", "getTransactionTypeListResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dictionaries
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetRoleList }
     * 
     */
    public GetRoleList createGetRoleList() {
        return new GetRoleList();
    }

    /**
     * Create an instance of {@link GetEstateTypeList }
     * 
     */
    public GetEstateTypeList createGetEstateTypeList() {
        return new GetEstateTypeList();
    }

    /**
     * Create an instance of {@link GetRoleListResponse }
     * 
     */
    public GetRoleListResponse createGetRoleListResponse() {
        return new GetRoleListResponse();
    }

    /**
     * Create an instance of {@link GetTransactionTypeList }
     * 
     */
    public GetTransactionTypeList createGetTransactionTypeList() {
        return new GetTransactionTypeList();
    }

    /**
     * Create an instance of {@link GetEstateTypeListResponse }
     * 
     */
    public GetEstateTypeListResponse createGetEstateTypeListResponse() {
        return new GetEstateTypeListResponse();
    }

    /**
     * Create an instance of {@link GetTransactionTypeListResponse }
     * 
     */
    public GetTransactionTypeListResponse createGetTransactionTypeListResponse() {
        return new GetTransactionTypeListResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEstateTypeList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "dictionaries", name = "getEstateTypeList")
    public JAXBElement<GetEstateTypeList> createGetEstateTypeList(GetEstateTypeList value) {
        return new JAXBElement<GetEstateTypeList>(_GetEstateTypeList_QNAME, GetEstateTypeList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRoleList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "dictionaries", name = "getRoleList")
    public JAXBElement<GetRoleList> createGetRoleList(GetRoleList value) {
        return new JAXBElement<GetRoleList>(_GetRoleList_QNAME, GetRoleList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRoleListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "dictionaries", name = "getRoleListResponse")
    public JAXBElement<GetRoleListResponse> createGetRoleListResponse(GetRoleListResponse value) {
        return new JAXBElement<GetRoleListResponse>(_GetRoleListResponse_QNAME, GetRoleListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEstateTypeListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "dictionaries", name = "getEstateTypeListResponse")
    public JAXBElement<GetEstateTypeListResponse> createGetEstateTypeListResponse(GetEstateTypeListResponse value) {
        return new JAXBElement<GetEstateTypeListResponse>(_GetEstateTypeListResponse_QNAME, GetEstateTypeListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransactionTypeList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "dictionaries", name = "getTransactionTypeList")
    public JAXBElement<GetTransactionTypeList> createGetTransactionTypeList(GetTransactionTypeList value) {
        return new JAXBElement<GetTransactionTypeList>(_GetTransactionTypeList_QNAME, GetTransactionTypeList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTransactionTypeListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "dictionaries", name = "getTransactionTypeListResponse")
    public JAXBElement<GetTransactionTypeListResponse> createGetTransactionTypeListResponse(GetTransactionTypeListResponse value) {
        return new JAXBElement<GetTransactionTypeListResponse>(_GetTransactionTypeListResponse_QNAME, GetTransactionTypeListResponse.class, null, value);
    }

}
