
package com.sap.xi.basis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommunicationPartyReadOut complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommunicationPartyReadOut">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Party" type="{http://sap.com/xi/BASIS}CommunicationParty" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LogMessageCollection" type="{http://sap.com/xi/BASIS}LogMessageCollection" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommunicationPartyReadOut", propOrder = {
    "party",
    "logMessageCollection"
})
public class CommunicationPartyReadOut {

    @XmlElement(name = "Party")
    protected List<CommunicationParty> party;
    @XmlElement(name = "LogMessageCollection")
    protected LogMessageCollection logMessageCollection;

    /**
     * Gets the value of the party property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the party property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommunicationParty }
     * 
     * 
     */
    public List<CommunicationParty> getParty() {
        if (party == null) {
            party = new ArrayList<CommunicationParty>();
        }
        return this.party;
    }

    /**
     * Gets the value of the logMessageCollection property.
     * 
     * @return
     *     possible object is
     *     {@link LogMessageCollection }
     *     
     */
    public LogMessageCollection getLogMessageCollection() {
        return logMessageCollection;
    }

    /**
     * Sets the value of the logMessageCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogMessageCollection }
     *     
     */
    public void setLogMessageCollection(LogMessageCollection value) {
        this.logMessageCollection = value;
    }

}
