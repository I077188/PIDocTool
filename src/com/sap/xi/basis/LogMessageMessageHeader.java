
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LogMessageMessageHeader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LogMessageMessageHeader">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageHeader" type="{http://sap.com/xi/BASIS}MessageHeaderID" minOccurs="0"/>
 *         &lt;element name="LogMessageItem" type="{http://sap.com/xi/BASIS}LogMessageItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogMessageMessageHeader", propOrder = {
    "messageHeader",
    "logMessageItem"
})
public class LogMessageMessageHeader {

    @XmlElement(name = "MessageHeader")
    protected MessageHeaderID messageHeader;
    @XmlElement(name = "LogMessageItem")
    protected LogMessageItem logMessageItem;

    /**
     * Gets the value of the messageHeader property.
     * 
     * @return
     *     possible object is
     *     {@link MessageHeaderID }
     *     
     */
    public MessageHeaderID getMessageHeader() {
        return messageHeader;
    }

    /**
     * Sets the value of the messageHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageHeaderID }
     *     
     */
    public void setMessageHeader(MessageHeaderID value) {
        this.messageHeader = value;
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
