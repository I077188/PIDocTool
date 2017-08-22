
package com.sap.xi.basis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.sap.xi.basis.global.LONGDescription;


/**
 * <p>Java class for CommunicationParty complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommunicationParty">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MasterLanguage" type="{http://sap.com/xi/BASIS/Global}LanguageCode"/>
 *         &lt;element name="AdministrativeData" type="{http://sap.com/xi/BASIS}ObjectAdministrativeData" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://sap.com/xi/BASIS/Global}LONG_Description" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PartyID" type="{http://sap.com/xi/BASIS}CommunicationPartyID"/>
 *         &lt;element name="AdditionalIdentifier" type="{http://sap.com/xi/BASIS}CommunicationPartyAdditionalIdentifier" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommunicationParty", propOrder = {
    "masterLanguage",
    "administrativeData",
    "description",
    "partyID",
    "additionalIdentifier"
})
public class CommunicationParty {

    @XmlElement(name = "MasterLanguage", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String masterLanguage;
    @XmlElement(name = "AdministrativeData")
    protected ObjectAdministrativeData administrativeData;
    @XmlElement(name = "Description")
    protected List<LONGDescription> description;
    @XmlElement(name = "PartyID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String partyID;
    @XmlElement(name = "AdditionalIdentifier", required = true)
    protected List<CommunicationPartyAdditionalIdentifier> additionalIdentifier;

    /**
     * Gets the value of the masterLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterLanguage() {
        return masterLanguage;
    }

    /**
     * Sets the value of the masterLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterLanguage(String value) {
        this.masterLanguage = value;
    }

    /**
     * Gets the value of the administrativeData property.
     * 
     * @return
     *     possible object is
     *     {@link ObjectAdministrativeData }
     *     
     */
    public ObjectAdministrativeData getAdministrativeData() {
        return administrativeData;
    }

    /**
     * Sets the value of the administrativeData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObjectAdministrativeData }
     *     
     */
    public void setAdministrativeData(ObjectAdministrativeData value) {
        this.administrativeData = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the description property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LONGDescription }
     * 
     * 
     */
    public List<LONGDescription> getDescription() {
        if (description == null) {
            description = new ArrayList<LONGDescription>();
        }
        return this.description;
    }

    /**
     * Gets the value of the partyID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPartyID() {
        return partyID;
    }

    /**
     * Sets the value of the partyID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPartyID(String value) {
        this.partyID = value;
    }

    /**
     * Gets the value of the additionalIdentifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalIdentifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalIdentifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommunicationPartyAdditionalIdentifier }
     * 
     * 
     */
    public List<CommunicationPartyAdditionalIdentifier> getAdditionalIdentifier() {
        if (additionalIdentifier == null) {
            additionalIdentifier = new ArrayList<CommunicationPartyAdditionalIdentifier>();
        }
        return this.additionalIdentifier;
    }

}
