
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for MessageHeaderID complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MessageHeaderID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SenderPartyID" type="{http://sap.com/xi/BASIS}CommunicationPartyID" minOccurs="0"/>
 *         &lt;element name="SenderComponentID" type="{http://sap.com/xi/BASIS}CommunicationComponentComponentID"/>
 *         &lt;element name="InterfaceName" type="{http://sap.com/xi/BASIS}DesignObjectName"/>
 *         &lt;element name="InterfaceNamespace" type="{http://sap.com/xi/BASIS}DesignObjectNamespace"/>
 *         &lt;element name="ReceiverPartyID" type="{http://sap.com/xi/BASIS}CommunicationPartyID" minOccurs="0"/>
 *         &lt;element name="ReceiverComponentID" type="{http://sap.com/xi/BASIS}CommunicationComponentComponentID" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageHeaderID", propOrder = {
    "senderPartyID",
    "senderComponentID",
    "interfaceName",
    "interfaceNamespace",
    "receiverPartyID",
    "receiverComponentID"
})
public class MessageHeaderID {

    @XmlElement(name = "SenderPartyID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String senderPartyID;
    @XmlElement(name = "SenderComponentID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String senderComponentID;
    @XmlElement(name = "InterfaceName", required = true)
    protected String interfaceName;
    @XmlElement(name = "InterfaceNamespace", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String interfaceNamespace;
    @XmlElement(name = "ReceiverPartyID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String receiverPartyID;
    @XmlElement(name = "ReceiverComponentID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String receiverComponentID;

    /**
     * Gets the value of the senderPartyID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderPartyID() {
        return senderPartyID;
    }

    /**
     * Sets the value of the senderPartyID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderPartyID(String value) {
        this.senderPartyID = value;
    }

    /**
     * Gets the value of the senderComponentID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderComponentID() {
        return senderComponentID;
    }

    /**
     * Sets the value of the senderComponentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderComponentID(String value) {
        this.senderComponentID = value;
    }

    /**
     * Gets the value of the interfaceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterfaceName() {
        return interfaceName;
    }

    /**
     * Sets the value of the interfaceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterfaceName(String value) {
        this.interfaceName = value;
    }

    /**
     * Gets the value of the interfaceNamespace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterfaceNamespace() {
        return interfaceNamespace;
    }

    /**
     * Sets the value of the interfaceNamespace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterfaceNamespace(String value) {
        this.interfaceNamespace = value;
    }

    /**
     * Gets the value of the receiverPartyID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiverPartyID() {
        return receiverPartyID;
    }

    /**
     * Sets the value of the receiverPartyID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiverPartyID(String value) {
        this.receiverPartyID = value;
    }

    /**
     * Gets the value of the receiverComponentID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiverComponentID() {
        return receiverComponentID;
    }

    /**
     * Sets the value of the receiverComponentID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiverComponentID(String value) {
        this.receiverComponentID = value;
    }

}
