
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for CommunicationPartyAdditionalIdentifier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommunicationPartyAdditionalIdentifier">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://sap.com/xi/BASIS>CommunicationPartyAdditionalIdentifier.Content">
 *       &lt;attribute name="schemeID">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;maxLength value="120"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="schemeAgencyID">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;maxLength value="120"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommunicationPartyAdditionalIdentifier", propOrder = {
    "value"
})
public class CommunicationPartyAdditionalIdentifier {

    @XmlValue
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String value;
    @XmlAttribute(name = "schemeID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String schemeID;
    @XmlAttribute(name = "schemeAgencyID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String schemeAgencyID;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the schemeID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemeID() {
        return schemeID;
    }

    /**
     * Sets the value of the schemeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemeID(String value) {
        this.schemeID = value;
    }

    /**
     * Gets the value of the schemeAgencyID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSchemeAgencyID() {
        return schemeAgencyID;
    }

    /**
     * Sets the value of the schemeAgencyID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSchemeAgencyID(String value) {
        this.schemeAgencyID = value;
    }

}
