
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.sap.xi.basis.global.Text;


/**
 * <p>Java class for LogMessageItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LogMessageItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SeverityCode" type="{http://sap.com/xi/BASIS/Global}LogItemSeverityCode" minOccurs="0"/>
 *         &lt;element name="ClassificationCode" type="{http://sap.com/xi/BASIS}LogMessageClassificationCode" minOccurs="0"/>
 *         &lt;element name="Message" type="{http://sap.com/xi/BASIS/Global}Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LogMessageItem", propOrder = {
    "severityCode",
    "classificationCode",
    "message"
})
public class LogMessageItem {

    @XmlElement(name = "SeverityCode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String severityCode;
    @XmlElement(name = "ClassificationCode")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String classificationCode;
    @XmlElement(name = "Message")
    protected Text message;

    /**
     * Gets the value of the severityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeverityCode() {
        return severityCode;
    }

    /**
     * Sets the value of the severityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeverityCode(String value) {
        this.severityCode = value;
    }

    /**
     * Gets the value of the classificationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassificationCode() {
        return classificationCode;
    }

    /**
     * Sets the value of the classificationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassificationCode(String value) {
        this.classificationCode = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link Text }
     *     
     */
    public Text getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link Text }
     *     
     */
    public void setMessage(Text value) {
        this.message = value;
    }

}
