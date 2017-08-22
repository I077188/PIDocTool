
package com.sap.xi.basis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Receivers complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Receivers">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReceiverRule" type="{http://sap.com/xi/BASIS}IntegratedConfigurationReceiverRule" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ExternalReceiverRule" type="{http://sap.com/xi/BASIS}ReceiverDeterminationInclude" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="DynamicReceiverRule" type="{http://sap.com/xi/BASIS}ReceiverDeterminationMapping" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NoReceiverBehaviour" type="{http://sap.com/xi/BASIS}NoReceiverBehaviour" minOccurs="0"/>
 *         &lt;element name="NoReceiverReceiver" type="{http://sap.com/xi/BASIS}CommunicationComponentID" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Receivers", propOrder = {
    "receiverRule",
    "externalReceiverRule",
    "dynamicReceiverRule",
    "noReceiverBehaviour",
    "noReceiverReceiver"
})
public class Receivers {

    @XmlElement(name = "ReceiverRule")
    protected List<IntegratedConfigurationReceiverRule> receiverRule;
    @XmlElement(name = "ExternalReceiverRule")
    protected List<ReceiverDeterminationInclude> externalReceiverRule;
    @XmlElement(name = "DynamicReceiverRule")
    protected List<ReceiverDeterminationMapping> dynamicReceiverRule;
    @XmlElement(name = "NoReceiverBehaviour")
    @XmlSchemaType(name = "token")
    protected NoReceiverBehaviour noReceiverBehaviour;
    @XmlElement(name = "NoReceiverReceiver")
    protected CommunicationComponentID noReceiverReceiver;

    /**
     * Gets the value of the receiverRule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the receiverRule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReceiverRule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntegratedConfigurationReceiverRule }
     * 
     * 
     */
    public List<IntegratedConfigurationReceiverRule> getReceiverRule() {
        if (receiverRule == null) {
            receiverRule = new ArrayList<IntegratedConfigurationReceiverRule>();
        }
        return this.receiverRule;
    }

    /**
     * Gets the value of the externalReceiverRule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the externalReceiverRule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExternalReceiverRule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReceiverDeterminationInclude }
     * 
     * 
     */
    public List<ReceiverDeterminationInclude> getExternalReceiverRule() {
        if (externalReceiverRule == null) {
            externalReceiverRule = new ArrayList<ReceiverDeterminationInclude>();
        }
        return this.externalReceiverRule;
    }

    /**
     * Gets the value of the dynamicReceiverRule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dynamicReceiverRule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDynamicReceiverRule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReceiverDeterminationMapping }
     * 
     * 
     */
    public List<ReceiverDeterminationMapping> getDynamicReceiverRule() {
        if (dynamicReceiverRule == null) {
            dynamicReceiverRule = new ArrayList<ReceiverDeterminationMapping>();
        }
        return this.dynamicReceiverRule;
    }

    /**
     * Gets the value of the noReceiverBehaviour property.
     * 
     * @return
     *     possible object is
     *     {@link NoReceiverBehaviour }
     *     
     */
    public NoReceiverBehaviour getNoReceiverBehaviour() {
        return noReceiverBehaviour;
    }

    /**
     * Sets the value of the noReceiverBehaviour property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoReceiverBehaviour }
     *     
     */
    public void setNoReceiverBehaviour(NoReceiverBehaviour value) {
        this.noReceiverBehaviour = value;
    }

    /**
     * Gets the value of the noReceiverReceiver property.
     * 
     * @return
     *     possible object is
     *     {@link CommunicationComponentID }
     *     
     */
    public CommunicationComponentID getNoReceiverReceiver() {
        return noReceiverReceiver;
    }

    /**
     * Sets the value of the noReceiverReceiver property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommunicationComponentID }
     *     
     */
    public void setNoReceiverReceiver(CommunicationComponentID value) {
        this.noReceiverReceiver = value;
    }

}
