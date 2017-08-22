
package com.sap.xi.basis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReceiverInterfaces complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReceiverInterfaces">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Receiver" type="{http://sap.com/xi/BASIS}CommunicationComponentID"/>
 *         &lt;element name="ReceiverInterfaceRule" type="{http://sap.com/xi/BASIS}IntegratedConfigurationReceiverInterfaceRule" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="QualityOfService" type="{http://sap.com/xi/BASIS}QualityOfService" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReceiverInterfaces", propOrder = {
    "receiver",
    "receiverInterfaceRule",
    "qualityOfService"
})
public class ReceiverInterfaces {

    @XmlElement(name = "Receiver", required = true)
    protected CommunicationComponentID receiver;
    @XmlElement(name = "ReceiverInterfaceRule")
    protected List<IntegratedConfigurationReceiverInterfaceRule> receiverInterfaceRule;
    @XmlElement(name = "QualityOfService")
    @XmlSchemaType(name = "token")
    protected QualityOfService qualityOfService;

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
     * Gets the value of the receiverInterfaceRule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the receiverInterfaceRule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReceiverInterfaceRule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntegratedConfigurationReceiverInterfaceRule }
     * 
     * 
     */
    public List<IntegratedConfigurationReceiverInterfaceRule> getReceiverInterfaceRule() {
        if (receiverInterfaceRule == null) {
            receiverInterfaceRule = new ArrayList<IntegratedConfigurationReceiverInterfaceRule>();
        }
        return this.receiverInterfaceRule;
    }

    /**
     * Gets the value of the qualityOfService property.
     * 
     * @return
     *     possible object is
     *     {@link QualityOfService }
     *     
     */
    public QualityOfService getQualityOfService() {
        return qualityOfService;
    }

    /**
     * Sets the value of the qualityOfService property.
     * 
     * @param value
     *     allowed object is
     *     {@link QualityOfService }
     *     
     */
    public void setQualityOfService(QualityOfService value) {
        this.qualityOfService = value;
    }

}
