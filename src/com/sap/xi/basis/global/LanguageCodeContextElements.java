
package com.sap.xi.basis.global;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LanguageCodeContextElements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LanguageCodeContextElements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LanguageInstalledIndicator" type="{http://sap.com/xi/BASIS/Global}Indicator" minOccurs="0"/>
 *         &lt;element name="LanguageAllowedIndicator" type="{http://sap.com/xi/BASIS/Global}Indicator" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LanguageCodeContextElements", propOrder = {
    "languageInstalledIndicator",
    "languageAllowedIndicator"
})
public class LanguageCodeContextElements {

    @XmlElement(name = "LanguageInstalledIndicator")
    protected Boolean languageInstalledIndicator;
    @XmlElement(name = "LanguageAllowedIndicator")
    protected Boolean languageAllowedIndicator;

    /**
     * Gets the value of the languageInstalledIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLanguageInstalledIndicator() {
        return languageInstalledIndicator;
    }

    /**
     * Sets the value of the languageInstalledIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLanguageInstalledIndicator(Boolean value) {
        this.languageInstalledIndicator = value;
    }

    /**
     * Gets the value of the languageAllowedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLanguageAllowedIndicator() {
        return languageAllowedIndicator;
    }

    /**
     * Sets the value of the languageAllowedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLanguageAllowedIndicator(Boolean value) {
        this.languageAllowedIndicator = value;
    }

}
