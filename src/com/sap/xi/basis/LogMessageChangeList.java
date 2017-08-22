
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LogMessageChangeList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LogMessageChangeList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ChangeListID" type="{http://sap.com/xi/BASIS}ChangeListID" minOccurs="0"/>
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
@XmlType(name = "LogMessageChangeList", propOrder = {
    "changeListID",
    "logMessageItem"
})
public class LogMessageChangeList {

    @XmlElement(name = "ChangeListID")
    protected ChangeListID changeListID;
    @XmlElement(name = "LogMessageItem")
    protected LogMessageItem logMessageItem;

    /**
     * Gets the value of the changeListID property.
     * 
     * @return
     *     possible object is
     *     {@link ChangeListID }
     *     
     */
    public ChangeListID getChangeListID() {
        return changeListID;
    }

    /**
     * Sets the value of the changeListID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChangeListID }
     *     
     */
    public void setChangeListID(ChangeListID value) {
        this.changeListID = value;
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
