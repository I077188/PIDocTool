
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for LogMessageReceiverRule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LogMessageReceiverRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ReceiverRuleID" type="{http://sap.com/xi/BASIS}ReceiverRuleID" minOccurs="0"/>
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
@XmlType(name = "LogMessageReceiverRule", propOrder = {
    "receiverRuleID",
    "logMessageItem"
})
public class LogMessageReceiverRule {

    @XmlElement(name = "ReceiverRuleID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String receiverRuleID;
    @XmlElement(name = "LogMessageItem")
    protected LogMessageItem logMessageItem;

    /**
     * Gets the value of the receiverRuleID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReceiverRuleID() {
        return receiverRuleID;
    }

    /**
     * Sets the value of the receiverRuleID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReceiverRuleID(String value) {
        this.receiverRuleID = value;
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
