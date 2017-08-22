
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
 * <p>Java class for RestrictedIntegratedConfiguration complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RestrictedIntegratedConfiguration">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MasterLanguage" type="{http://sap.com/xi/BASIS/Global}LanguageCode"/>
 *         &lt;element name="AdministrativeData" type="{http://sap.com/xi/BASIS}RestrictedObjectAdministrativeData" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://sap.com/xi/BASIS/Global}LONG_Description" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="IntegratedConfigurationID" type="{http://sap.com/xi/BASIS}MessageHeaderID"/>
 *         &lt;element name="InboundProcessing" type="{http://sap.com/xi/BASIS}InboundProcessing" minOccurs="0"/>
 *         &lt;element name="Receivers" type="{http://sap.com/xi/BASIS}Receivers" minOccurs="0"/>
 *         &lt;element name="ReceiverInterfaces" type="{http://sap.com/xi/BASIS}ReceiverInterfaces" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="OutboundProcessing" type="{http://sap.com/xi/BASIS}OutboundProcessing" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="PrefixNamespaceMapping" type="{http://sap.com/xi/BASIS}PrefixNamespaceMapping" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Logging" type="{http://sap.com/xi/BASIS}AdvancedSettings" minOccurs="0"/>
 *         &lt;element name="Staging" type="{http://sap.com/xi/BASIS}AdvancedSettings" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RestrictedIntegratedConfiguration", propOrder = {
    "masterLanguage",
    "administrativeData",
    "description",
    "integratedConfigurationID",
    "inboundProcessing",
    "receivers",
    "receiverInterfaces",
    "outboundProcessing",
    "prefixNamespaceMapping",
    "logging",
    "staging"
})
public class RestrictedIntegratedConfiguration {

    @XmlElement(name = "MasterLanguage", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String masterLanguage;
    @XmlElement(name = "AdministrativeData")
    protected RestrictedObjectAdministrativeData administrativeData;
    @XmlElement(name = "Description")
    protected List<LONGDescription> description;
    @XmlElement(name = "IntegratedConfigurationID", required = true)
    protected MessageHeaderID integratedConfigurationID;
    @XmlElement(name = "InboundProcessing")
    protected InboundProcessing inboundProcessing;
    @XmlElement(name = "Receivers")
    protected Receivers receivers;
    @XmlElement(name = "ReceiverInterfaces")
    protected List<ReceiverInterfaces> receiverInterfaces;
    @XmlElement(name = "OutboundProcessing")
    protected List<OutboundProcessing> outboundProcessing;
    @XmlElement(name = "PrefixNamespaceMapping")
    protected List<PrefixNamespaceMapping> prefixNamespaceMapping;
    @XmlElement(name = "Logging")
    protected AdvancedSettings logging;
    @XmlElement(name = "Staging")
    protected AdvancedSettings staging;

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
     *     {@link RestrictedObjectAdministrativeData }
     *     
     */
    public RestrictedObjectAdministrativeData getAdministrativeData() {
        return administrativeData;
    }

    /**
     * Sets the value of the administrativeData property.
     * 
     * @param value
     *     allowed object is
     *     {@link RestrictedObjectAdministrativeData }
     *     
     */
    public void setAdministrativeData(RestrictedObjectAdministrativeData value) {
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
     * Gets the value of the integratedConfigurationID property.
     * 
     * @return
     *     possible object is
     *     {@link MessageHeaderID }
     *     
     */
    public MessageHeaderID getIntegratedConfigurationID() {
        return integratedConfigurationID;
    }

    /**
     * Sets the value of the integratedConfigurationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageHeaderID }
     *     
     */
    public void setIntegratedConfigurationID(MessageHeaderID value) {
        this.integratedConfigurationID = value;
    }

    /**
     * Gets the value of the inboundProcessing property.
     * 
     * @return
     *     possible object is
     *     {@link InboundProcessing }
     *     
     */
    public InboundProcessing getInboundProcessing() {
        return inboundProcessing;
    }

    /**
     * Sets the value of the inboundProcessing property.
     * 
     * @param value
     *     allowed object is
     *     {@link InboundProcessing }
     *     
     */
    public void setInboundProcessing(InboundProcessing value) {
        this.inboundProcessing = value;
    }

    /**
     * Gets the value of the receivers property.
     * 
     * @return
     *     possible object is
     *     {@link Receivers }
     *     
     */
    public Receivers getReceivers() {
        return receivers;
    }

    /**
     * Sets the value of the receivers property.
     * 
     * @param value
     *     allowed object is
     *     {@link Receivers }
     *     
     */
    public void setReceivers(Receivers value) {
        this.receivers = value;
    }

    /**
     * Gets the value of the receiverInterfaces property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the receiverInterfaces property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReceiverInterfaces().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReceiverInterfaces }
     * 
     * 
     */
    public List<ReceiverInterfaces> getReceiverInterfaces() {
        if (receiverInterfaces == null) {
            receiverInterfaces = new ArrayList<ReceiverInterfaces>();
        }
        return this.receiverInterfaces;
    }

    /**
     * Gets the value of the outboundProcessing property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outboundProcessing property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutboundProcessing().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OutboundProcessing }
     * 
     * 
     */
    public List<OutboundProcessing> getOutboundProcessing() {
        if (outboundProcessing == null) {
            outboundProcessing = new ArrayList<OutboundProcessing>();
        }
        return this.outboundProcessing;
    }

    /**
     * Gets the value of the prefixNamespaceMapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prefixNamespaceMapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrefixNamespaceMapping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PrefixNamespaceMapping }
     * 
     * 
     */
    public List<PrefixNamespaceMapping> getPrefixNamespaceMapping() {
        if (prefixNamespaceMapping == null) {
            prefixNamespaceMapping = new ArrayList<PrefixNamespaceMapping>();
        }
        return this.prefixNamespaceMapping;
    }

    /**
     * Gets the value of the logging property.
     * 
     * @return
     *     possible object is
     *     {@link AdvancedSettings }
     *     
     */
    public AdvancedSettings getLogging() {
        return logging;
    }

    /**
     * Sets the value of the logging property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdvancedSettings }
     *     
     */
    public void setLogging(AdvancedSettings value) {
        this.logging = value;
    }

    /**
     * Gets the value of the staging property.
     * 
     * @return
     *     possible object is
     *     {@link AdvancedSettings }
     *     
     */
    public AdvancedSettings getStaging() {
        return staging;
    }

    /**
     * Sets the value of the staging property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdvancedSettings }
     *     
     */
    public void setStaging(AdvancedSettings value) {
        this.staging = value;
    }

}
