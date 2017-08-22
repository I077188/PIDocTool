
package com.sap.xi.basis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IntegratedConfigurationReadOut complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IntegratedConfigurationReadOut">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IntegratedConfiguration" type="{http://sap.com/xi/BASIS}IntegratedConfiguration" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LogMessageCollection" type="{http://sap.com/xi/BASIS}LogMessageCollection" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntegratedConfigurationReadOut", propOrder = {
    "integratedConfiguration",
    "logMessageCollection"
})
public class IntegratedConfigurationReadOut {

    @XmlElement(name = "IntegratedConfiguration")
    protected List<IntegratedConfiguration> integratedConfiguration;
    @XmlElement(name = "LogMessageCollection")
    protected LogMessageCollection logMessageCollection;

    /**
     * Gets the value of the integratedConfiguration property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the integratedConfiguration property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIntegratedConfiguration().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntegratedConfiguration }
     * 
     * 
     */
    public List<IntegratedConfiguration> getIntegratedConfiguration() {
        if (integratedConfiguration == null) {
            integratedConfiguration = new ArrayList<IntegratedConfiguration>();
        }
        return this.integratedConfiguration;
    }

    /**
     * Gets the value of the logMessageCollection property.
     * 
     * @return
     *     possible object is
     *     {@link LogMessageCollection }
     *     
     */
    public LogMessageCollection getLogMessageCollection() {
        return logMessageCollection;
    }

    /**
     * Sets the value of the logMessageCollection property.
     * 
     * @param value
     *     allowed object is
     *     {@link LogMessageCollection }
     *     
     */
    public void setLogMessageCollection(LogMessageCollection value) {
        this.logMessageCollection = value;
    }

}
