
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LogMessageCommunicationChannel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LogMessageCommunicationChannel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CommunicationChannelID" type="{http://sap.com/xi/BASIS}CommunicationChannelID" minOccurs="0"/>
 *         &lt;element name="LogMessageItem" type="{http://sap.com/xi/BASIS}LogMessageItem"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogMessageCommunicationChannel", propOrder = {
    "communicationChannelID",
    "logMessageItem"
})
public class LogMessageCommunicationChannel {

    @XmlElement(name = "CommunicationChannelID")
    protected CommunicationChannelID communicationChannelID;
    @XmlElement(name = "LogMessageItem", required = true)
    protected LogMessageItem logMessageItem;

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
     * Gets the value of the logMessageItem property.
     * 
     * @return
     *     possible object is
     *     {@link LogMessageItem }
     *     
     */
    public LogMessageItem getLogMessageItem() {
        return logMessageItem;
    }

    /**
     * Sets the value of the logMessageItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogMessageItem }
     *     
     */
    public void setLogMessageItem(LogMessageItem value) {
        this.logMessageItem = value;
    }

}
