
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for HeaderMapping complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HeaderMapping">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Sender" type="{http://sap.com/xi/BASIS}CommunicationPartnerExtractor" minOccurs="0"/>
 *         &lt;element name="Receiver" type="{http://sap.com/xi/BASIS}CommunicationPartnerExtractor" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HeaderMapping", propOrder = {
    "sender",
    "receiver"
})
public class HeaderMapping {

    @XmlElement(name = "Sender")
    protected CommunicationPartnerExtractor sender;
    @XmlElement(name = "Receiver")
    protected CommunicationPartnerExtractor receiver;

    /**
     * Gets the value of the sender property.
     * 
     * @return
     *     possible object is
     *     {@link CommunicationPartnerExtractor }
     *     
     */
    public CommunicationPartnerExtractor getSender() {
        return sender;
    }

    /**
     * Sets the value of the sender property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommunicationPartnerExtractor }
     *     
     */
    public void setSender(CommunicationPartnerExtractor value) {
        this.sender = value;
    }

    /**
     * Gets the value of the receiver property.
     * 
     * @return
     *     possible object is
     *     {@link CommunicationPartnerExtractor }
     *     
     */
    public CommunicationPartnerExtractor getReceiver() {
        return receiver;
    }

    /**
     * Sets the value of the receiver property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommunicationPartnerExtractor }
     *     
     */
    public void setReceiver(CommunicationPartnerExtractor value) {
        this.receiver = value;
    }

}
