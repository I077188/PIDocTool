
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.sap.xi.basis.global.LONGDescription;


/**
 * <p>Java class for ChangeListID complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChangeListID">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ChangeListID" type="{http://sap.com/xi/BASIS}ChangeListChangeListID" minOccurs="0"/>
 *         &lt;element name="Name" type="{http://sap.com/xi/BASIS/Global}LANGUAGEINDEPENDENT_LONG_Name" minOccurs="0"/>
 *         &lt;element name="Description" type="{http://sap.com/xi/BASIS/Global}LONG_Description" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeListID", propOrder = {
    "changeListID",
    "name",
    "description"
})
public class ChangeListID {

    @XmlElement(name = "ChangeListID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String changeListID;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Description")
    protected LONGDescription description;

    /**
     * Gets the value of the changeListID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChangeListID() {
        return changeListID;
    }

    /**
     * Sets the value of the changeListID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChangeListID(String value) {
        this.changeListID = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link LONGDescription }
     *     
     */
    public LONGDescription getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link LONGDescription }
     *     
     */
    public void setDescription(LONGDescription value) {
        this.description = value;
    }

}
