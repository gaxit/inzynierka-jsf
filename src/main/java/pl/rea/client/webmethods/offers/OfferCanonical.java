package pl.rea.client.webmethods.offers;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for offerCanonical complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="offerCanonical">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="addressId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="apartmentNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="area" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estateType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="floor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="garage" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="houseNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="images" type="{offers}imageCanonical" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="offerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="owner" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="postalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="street" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="town" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "offerCanonical", propOrder = {
    "addressId",
    "apartmentNo",
    "area",
    "description",
    "estateType",
    "floor",
    "garage",
    "houseNo",
    "id",
    "images",
    "offerName",
    "owner",
    "postalCode",
    "price",
    "street",
    "town",
    "transactionType"
}, namespace="offerCanonicalClient")
public class OfferCanonical {

    protected long addressId;
    protected int apartmentNo;
    protected int area;
    protected String description;
    protected String estateType;
    protected int floor;
    protected boolean garage;
    protected int houseNo;
    protected long id;
    @XmlElement(nillable = true)
    protected List<ImageCanonical> images;
    protected String offerName;
    protected String owner;
    protected String postalCode;
    protected int price;
    protected String street;
    protected String town;
    protected String transactionType;

    /**
     * Gets the value of the addressId property.
     * 
     */
    public long getAddressId() {
        return addressId;
    }

    /**
     * Sets the value of the addressId property.
     * 
     */
    public void setAddressId(long value) {
        this.addressId = value;
    }

    /**
     * Gets the value of the apartmentNo property.
     * 
     */
    public int getApartmentNo() {
        return apartmentNo;
    }

    /**
     * Sets the value of the apartmentNo property.
     * 
     */
    public void setApartmentNo(int value) {
        this.apartmentNo = value;
    }

    /**
     * Gets the value of the area property.
     * 
     */
    public int getArea() {
        return area;
    }

    /**
     * Sets the value of the area property.
     * 
     */
    public void setArea(int value) {
        this.area = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the estateType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstateType() {
        return estateType;
    }

    /**
     * Sets the value of the estateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstateType(String value) {
        this.estateType = value;
    }

    /**
     * Gets the value of the floor property.
     * 
     */
    public int getFloor() {
        return floor;
    }

    /**
     * Sets the value of the floor property.
     * 
     */
    public void setFloor(int value) {
        this.floor = value;
    }

    /**
     * Gets the value of the garage property.
     * 
     */
    public boolean isGarage() {
        return garage;
    }

    /**
     * Sets the value of the garage property.
     * 
     */
    public void setGarage(boolean value) {
        this.garage = value;
    }

    /**
     * Gets the value of the houseNo property.
     * 
     */
    public int getHouseNo() {
        return houseNo;
    }

    /**
     * Sets the value of the houseNo property.
     * 
     */
    public void setHouseNo(int value) {
        this.houseNo = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the images property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the images property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImageCanonical }
     * 
     * 
     */
    public List<ImageCanonical> getImages() {
        if (images == null) {
            images = new ArrayList<ImageCanonical>();
        }
        return this.images;
    }
    
    public void setImages(List<ImageCanonical> imagesList){
    	this.images = imagesList;
    }

    /**
     * Gets the value of the offerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOfferName() {
        return offerName;
    }

    /**
     * Sets the value of the offerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOfferName(String value) {
        this.offerName = value;
    }

    /**
     * Gets the value of the owner property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Sets the value of the owner property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwner(String value) {
        this.owner = value;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Sets the value of the postalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(int value) {
        this.price = value;
    }

    /**
     * Gets the value of the street property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the value of the street property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreet(String value) {
        this.street = value;
    }

    /**
     * Gets the value of the town property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTown() {
        return town;
    }

    /**
     * Sets the value of the town property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTown(String value) {
        this.town = value;
    }

    /**
     * Gets the value of the transactionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the value of the transactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionType(String value) {
        this.transactionType = value;
    }

}
