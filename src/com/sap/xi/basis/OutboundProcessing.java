
package com.sap.xi.basis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OutboundProcessing complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OutboundProcessing">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Receiver" type="{http://sap.com/xi/BASIS}CommunicationComponentID"/>
 *         &lt;element name="ReceiverInterface" type="{http://sap.com/xi/BASIS}DesignObjectID"/>
 *         &lt;element name="CommunicationChannel" type="{http://sap.com/xi/BASIS}CommunicationChannelID" minOccurs="0"/>
 *         &lt;element name="SchemaValidationIndicator" type="{http://sap.com/xi/BASIS/Global}Indicator" minOccurs="0"/>
 *         &lt;element name="VirusScan" type="{http://sap.com/xi/BASIS}VirusScanCode" minOccurs="0"/>
 *         &lt;element name="AdapterSpecificAttribute" type="{http://sap.com/xi/BASIS}GenericProperty" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AdapterSpecificTableAttribute" type="{http://sap.com/xi/BASIS}GenericPropertyTable" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="HeaderMapping" type="{http://sap.com/xi/BASIS}HeaderMapping" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutboundProcessing", propOrder = {
    "receiver",
    "receiverInterface",
    "communicationChannel",
    "schemaValidationIndicator",
    "virusScan",
    "adapterSpecificAttribute",
    "adapterSpecificTableAttribute",
    "headerMapping"
})
public class OutboundProcessing {

    @XmlElement(name = "Receiver", required = true)
    protected CommunicationComponentID receiver;
    @XmlElement(name = "ReceiverInterface", required = true)
    protected DesignObjectID receiverInterface;
    @XmlElement(name = "CommunicationChannel")
    protected CommunicationChannelID communicationChannel;
    @XmlElement(name = "SchemaValidationIndicator")
    protected Boolean schemaValidationIndicator;
    @XmlElement(name = "VirusScan")
    @XmlSchemaType(name = "token")
    protected VirusScanCode virusScan;
    @XmlElement(name = "AdapterSpecificAttribute")
    protected List<GenericProperty> adapterSpecificAttribute;
    @XmlElement(name = "AdapterSpecificTableAttribute")
    protected List<GenericPropertyTable> adapterSpecificTableAttribute;
    @XmlElement(name = "HeaderMapping")
    protected HeaderMapping headerMapping;

    /**
     * Gets the value of the receiver property.
     * 
     * @return
     *     possible object is
     *     {@link CommunicationComponentID }
     *     
     */
    public CommunicationComponentID getReceiver() {
        return receiver;
    }

    /**
     * Sets the value of the receiver property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommunicationComponentID }
     *     
     */
    public void setReceiver(CommunicationComponentID value) {
        this.receiver = value;
    }

    /**
     * Gets the value of the receiverInterface property.
     * 
     * @return
     *     possible object is
     *     {@link DesignObjectID }
     *     
     */
    public DesignObjectID getReceiverInterface() {
        return receiverInterface;
    }

    /**
     * Sets the value of the receiverInterface property.
     * 
     * @param value
     *     allowed object is
     *     {@link DesignObjectID }
     *     
     */
    public void setReceiverInterface(DesignObjectID value) {
        this.receiverInterface = value;
    }

    /**
     * Gets the value of the communicationChannel property.
     * 
     * @return
     *     possible object is
     *     {@link CommunicationChannelID }
     *     
     */
    public CommunicationChannelID getCommunicationChannel() {
        return communicationChannel;
    }

    /**
     * Sets the value of the communicationChannel property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommunicationChannelID }
     *     
     */
    public void setCommunicationChannel(CommunicationChannelID value) {
        this.communicationChannel = value;
    }

    /**
     * Gets the value of the schemaValidationIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSchemaValidationIndicator() {
        return schemaValidationIndicator;
    }

    /**
     * Sets the value of the schemaValidationIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSchemaValidationIndicator(Boolean value) {
        this.schemaValidationIndicator = value;
    }

    /**
     * Gets the value of the virusScan property.
     * 
     * @return
     *     possible object is
     *     {@link VirusScanCode }
     *     
     */
    public VirusScanCode getVirusScan() {
        return virusScan;
    }

    /**
     * Sets the value of the virusScan property.
     * 
     * @param value
     *     allowed object is
     *     {@link VirusScanCode }
     *     
     */
    public void setVirusScan(VirusScanCode value) {
        this.virusScan = value;
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
     * Gets the value of the headerMapping property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderMapping }
     *     
     */
    public HeaderMapping getHeaderMapping() {
        return headerMapping;
    }

    /**
     * Sets the value of the headerMapping property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderMapping }
     *     
     */
    public void setHeaderMapping(HeaderMapping value) {
        this.headerMapping = value;
    }

}
