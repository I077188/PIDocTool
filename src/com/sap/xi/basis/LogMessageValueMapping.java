
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for LogMessageValueMapping complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LogMessageValueMapping">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ValueMappingID" type="{http://sap.com/xi/BASIS}ValueMappingID" minOccurs="0"/>
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
@XmlType(name = "LogMessageValueMapping", propOrder = {
    "valueMappingID",
    "logMessageItem"
})
public class LogMessageValueMapping {

    @XmlElement(name = "ValueMappingID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String valueMappingID;
    @XmlElement(name = "LogMessageItem")
    protected LogMessageItem logMessageItem;

    /**
     * Gets the value of the valueMappingID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValueMappingID() {
        return valueMappingID;
    }

    /**
     * Sets the value of the valueMappingID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValueMappingID(String value) {
        this.valueMappingID = value;
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
