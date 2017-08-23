
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
 * <p>Java class for TemplateBasedCommunicationChannel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TemplateBasedCommunicationChannel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MasterLanguage" type="{http://sap.com/xi/BASIS/Global}LanguageCode"/>
 *         &lt;element name="AdministrativeData" type="{http://sap.com/xi/BASIS}RestrictedObjectAdministrativeData" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://sap.com/xi/BASIS/Global}LONG_Description" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="CommunicationChannelID" type="{http://sap.com/xi/BASIS}CommunicationChannelID"/>
 *         &lt;element name="ChannelTemplate" type="{http://sap.com/xi/BASIS}DesignObjectID"/>
 *         &lt;element name="AdapterEngineName" type="{http://sap.com/xi/BASIS}AdapterEngineName" minOccurs="0"/>
 *         &lt;element name="AdapterSpecificAttribute" type="{http://sap.com/xi/BASIS}GenericProperty" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AdapterSpecificTableAttribute" type="{http://sap.com/xi/BASIS}GenericPropertyTable" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ModuleProcess" type="{http://sap.com/xi/BASIS}ModuleProcess" minOccurs="0"/>
 *         &lt;element name="SenderIdentifier" type="{http://sap.com/xi/BASIS}ChannelAdditionalIdentifier" minOccurs="0"/>
 *         &lt;element name="ReceiverIdentifier" type="{http://sap.com/xi/BASIS}ChannelAdditionalIdentifier" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TemplateBasedCommunicationChannel", propOrder = {
    "masterLanguage",
    "administrativeData",
    "description",
    "communicationChannelID",
    "channelTemplate",
    "adapterEngineName",
    "adapterSpecificAttribute",
    "adapterSpecificTableAttribute",
    "moduleProcess",
    "senderIdentifier",
    "receiverIdentifier"
})
public class TemplateBasedCommunicationChannel {

    @XmlElement(name = "MasterLanguage", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String masterLanguage;
    @XmlElement(name = "AdministrativeData")
    protected RestrictedObjectAdministrativeData administrativeData;
    @XmlElement(name = "Description")
    protected List<LONGDescription> description;
    @XmlElement(name = "CommunicationChannelID", required = true)
    protected CommunicationChannelID communicationChannelID;
    @XmlElement(name = "ChannelTemplate", required = true)
    protected DesignObjectID channelTemplate;
    @XmlElement(name = "AdapterEngineName")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String adapterEngineName;
    @XmlElement(name = "AdapterSpecificAttribute")
    protected List<GenericProperty> adapterSpecificAttribute;
    @XmlElement(name = "AdapterSpecificTableAttribute")
    protected List<GenericPropertyTable> adapterSpecificTableAttribute;
    @XmlElement(name = "ModuleProcess")
    protected ModuleProcess moduleProcess;
    @XmlElement(name = "SenderIdentifier")
    protected ChannelAdditionalIdentifier senderIdentifier;
    @XmlElement(name = "ReceiverIdentifier")
    protected ChannelAdditionalIdentifier receiverIdentifier;

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
     * Gets the value of the communicationChannelID property.
     * 
     * @return
     *     possible object is
     *     {@link CommunicationChannelID }
     *     
     */
    public CommunicationChannelID getCommunicationChannelID() {
        return communicationChannelID;
    }

    /**
     * Sets the value of the communicationChannelID property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommunicationChannelID }
     *     
     */
    public void setCommunicationChannelID(CommunicationChannelID value) {
        this.communicationChannelID = value;
    }

    /**
     * Gets the value of the channelTemplate property.
     * 
     * @return
     *     possible object is
     *     {@link DesignObjectID }
     *     
     */
    public DesignObjectID getChannelTemplate() {
        return channelTemplate;
    }

    /**
     * Sets the value of the channelTemplate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DesignObjectID }
     *     
     */
    public void setChannelTemplate(DesignObjectID value) {
        this.channelTemplate = value;
    }

    /**
     * Gets the value of the adapterEngineName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdapterEngineName() {
        return adapterEngineName;
    }

    /**
     * Sets the value of the adapterEngineName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdapterEngineName(String value) {
        this.adapterEngineName = value;
    }

    /**
     * Gets the value of the adapterSpecificAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adapterSpecificAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdapterSpecificAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericProperty }
     * 
     * 
     */
    public List<GenericProperty> getAdapterSpecificAttribute() {
        if (adapterSpecificAttribute == null) {
            adapterSpecificAttribute = new ArrayList<GenericProperty>();
        }
        return this.adapterSpecificAttribute;
    }

    /**
     * Gets the value of the adapterSpecificTableAttribute property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the adapterSpecificTableAttribute property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdapterSpecificTableAttribute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericPropertyTable }
     * 
     * 
     */
    public List<GenericPropertyTable> getAdapterSpecificTableAttribute() {
        if (adapterSpecificTableAttribute == null) {
            adapterSpecificTableAttribute = new ArrayList<GenericPropertyTable>();
        }
        return this.adapterSpecificTableAttribute;
    }

    /**
     * Gets the value of the moduleProcess property.
     * 
     * @return
     *     possible object is
     *     {@link ModuleProcess }
     *     
     */
    public ModuleProcess getModuleProcess() {
        return moduleProcess;
    }

    /**
     * Sets the value of the moduleProcess property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModuleProcess }
     *     
     */
    public void setModuleProcess(ModuleProcess value) {
        this.moduleProcess = value;
    }

    /**
     * Gets the value of the senderIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link ChannelAdditionalIdentifier }
     *     
     */
    public ChannelAdditionalIdentifier getSenderIdentifier() {
        return senderIdentifier;
    }

    /**
     * Sets the value of the senderIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChannelAdditionalIdentifier }
     *     
     */
    public void setSenderIdentifier(ChannelAdditionalIdentifier value) {
        this.senderIdentifier = value;
    }

    /**
     * Gets the value of the receiverIdentifier property.
     * 
     * @return
     *     possible object is
     *     {@link ChannelAdditionalIdentifier }
     *     
     */
    public ChannelAdditionalIdentifier getReceiverIdentifier() {
        return receiverIdentifier;
    }

    /**
     * Sets the value of the receiverIdentifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChannelAdditionalIdentifier }
     *     
     */
    public void setReceiverIdentifier(ChannelAdditionalIdentifier value) {
        this.receiverIdentifier = value;
    }

}
