
package com.sap.xi.basis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommunicationChannelIdentifierCollection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommunicationChannelIdentifierCollection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CommunicationChannelID" type="{http://sap.com/xi/BASIS}CommunicationChannelID" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommunicationChannelIdentifierCollection", propOrder = {
    "communicationChannelID"
})
public class CommunicationChannelIdentifierCollection {

    @XmlElement(name = "CommunicationChannelID")
    protected List<CommunicationChannelID> communicationChannelID;

    /**
     * Gets the value of the communicationChannelID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the communicationChannelID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommunicationChannelID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommunicationChannelID }
     * 
     * 
     */
    public List<CommunicationChannelID> getCommunicationChannelID() {
        if (communicationChannelID == null) {
            communicationChannelID = new ArrayList<CommunicationChannelID>();
        }
        return this.communicationChannelID;
    }

}
