
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AdvancedSettings complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AdvancedSettings">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UseGlobal" type="{http://sap.com/xi/BASIS/Global}Indicator" minOccurs="0"/>
 *         &lt;element name="SpecificConfiguration" type="{http://sap.com/xi/BASIS/Global}LANGUAGEINDEPENDENT_Text" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AdvancedSettings", propOrder = {
    "useGlobal",
    "specificConfiguration"
})
public class AdvancedSettings {

    @XmlElement(name = "UseGlobal")
    protected Boolean useGlobal;
    @XmlElement(name = "SpecificConfiguration")
    protected String specificConfiguration;

    /**
     * Gets the value of the useGlobal property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUseGlobal() {
        return useGlobal;
    }

    /**
     * Sets the value of the useGlobal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseGlobal(Boolean value) {
        this.useGlobal = value;
    }

    /**
     * Gets the value of the specificConfiguration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpecificConfiguration() {
        return specificConfiguration;
    }

    /**
     * Sets the value of the specificConfiguration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpecificConfiguration(String value) {
        this.specificConfiguration = value;
    }

}
