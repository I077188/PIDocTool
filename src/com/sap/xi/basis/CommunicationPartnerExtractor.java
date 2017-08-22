
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommunicationPartnerExtractor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommunicationPartnerExtractor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CommunicationParty" type="{http://sap.com/xi/BASIS}Extractor" minOccurs="0"/>
 *         &lt;element name="CommunicationPartySchema" type="{http://sap.com/xi/BASIS}Extractor" minOccurs="0"/>
 *         &lt;element name="CommunicationPartyAgency" type="{http://sap.com/xi/BASIS}Extractor" minOccurs="0"/>
 *         &lt;element name="CommunicationComponent" type="{http://sap.com/xi/BASIS}Extractor" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommunicationPartnerExtractor", propOrder = {
    "communicationParty",
    "communicationPartySchema",
    "communicationPartyAgency",
    "communicationComponent"
})
public class CommunicationPartnerExtractor {

    @XmlElement(name = "CommunicationParty")
    protected Extractor communicationParty;
    @XmlElement(name = "CommunicationPartySchema")
    protected Extractor communicationPartySchema;
    @XmlElement(name = "CommunicationPartyAgency")
    protected Extractor communicationPartyAgency;
    @XmlElement(name = "CommunicationComponent")
    protected Extractor communicationComponent;

    /**
     * Gets the value of the communicationParty property.
     * 
     * @return
     *     possible object is
     *     {@link Extractor }
     *     
     */
    public Extractor getCommunicationParty() {
        return communicationParty;
    }

    /**
     * Sets the value of the communicationParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link Extractor }
     *     
     */
    public void setCommunicationParty(Extractor value) {
        this.communicationParty = value;
    }

    /**
     * Gets the value of the communicationPartySchema property.
     * 
     * @return
     *     possible object is
     *     {@link Extractor }
     *     
     */
    public Extractor getCommunicationPartySchema() {
        return communicationPartySchema;
    }

    /**
     * Sets the value of the communicationPartySchema property.
     * 
     * @param value
     *     allowed object is
     *     {@link Extractor }
     *     
     */
    public void setCommunicationPartySchema(Extractor value) {
        this.communicationPartySchema = value;
    }

    /**
     * Gets the value of the communicationPartyAgency property.
     * 
     * @return
     *     possible object is
     *     {@link Extractor }
     *     
     */
    public Extractor getCommunicationPartyAgency() {
        return communicationPartyAgency;
    }

    /**
     * Sets the value of the communicationPartyAgency property.
     * 
     * @param value
     *     allowed object is
     *     {@link Extractor }
     *     
     */
    public void setCommunicationPartyAgency(Extractor value) {
        this.communicationPartyAgency = value;
    }

    /**
     * Gets the value of the communicationComponent property.
     * 
     * @return
     *     possible object is
     *     {@link Extractor }
     *     
     */
    public Extractor getCommunicationComponent() {
        return communicationComponent;
    }

    /**
     * Sets the value of the communicationComponent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Extractor }
     *     
     */
    public void setCommunicationComponent(Extractor value) {
        this.communicationComponent = value;
    }

}
