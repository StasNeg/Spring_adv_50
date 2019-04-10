//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.04.10 at 05:14:28 PM MSK 
//


package xml.models.beans.user_web;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for event complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="event">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rate" type="{http://beans.models.xml/user-web}rate" minOccurs="0"/>
 *         &lt;element name="ticketPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="basePrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="dateTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{http://beans.models.xml/user-web}auditorium"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "event", propOrder = {
    "name",
    "rate",
    "ticketPrice",
    "basePrice",
    "dateTime",
    "auditorium"
})
public class Event {

    protected String name;
    protected Rate rate;
    protected double ticketPrice;
    protected double basePrice;
    protected String dateTime;
    @XmlElement(required = true)
    protected Auditorium auditorium;
    @XmlAttribute(name = "id", required = true)
    protected long id;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the rate property.
     * 
     * @return
     *     possible object is
     *     {@link Rate }
     *     
     */
    public Rate getRate() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rate }
     *     
     */
    public void setRate(Rate value) {
        this.rate = value;
    }

    /**
     * Gets the value of the ticketPrice property.
     * 
     */
    public double getTicketPrice() {
        return ticketPrice;
    }

    /**
     * Sets the value of the ticketPrice property.
     * 
     */
    public void setTicketPrice(double value) {
        this.ticketPrice = value;
    }

    /**
     * Gets the value of the basePrice property.
     * 
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the value of the basePrice property.
     * 
     */
    public void setBasePrice(double value) {
        this.basePrice = value;
    }

    /**
     * Gets the value of the dateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateTime(String value) {
        this.dateTime = value;
    }

    /**
     * Gets the value of the auditorium property.
     * 
     * @return
     *     possible object is
     *     {@link Auditorium }
     *     
     */
    public Auditorium getAuditorium() {
        return auditorium;
    }

    /**
     * Sets the value of the auditorium property.
     * 
     * @param value
     *     allowed object is
     *     {@link Auditorium }
     *     
     */
    public void setAuditorium(Auditorium value) {
        this.auditorium = value;
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

}
