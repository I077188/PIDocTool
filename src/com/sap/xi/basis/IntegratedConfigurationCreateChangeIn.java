
package com.sap.xi.basis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for IntegratedConfigurationCreateChangeIn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IntegratedConfigurationCreateChangeIn">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ChangeListID" type="{http://sap.com/xi/BASIS}ChangeListChangeListID" minOccurs="0"/>
 *         &lt;element name="IntegratedConfiguration" type="{http://sap.com/xi/BASIS}RestrictedIntegratedConfiguration" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntegratedConfigurationCreateChangeIn", propOrder = {
    "changeListID",
    "integratedConfiguration"
})
public class IntegratedConfigurationCreateChangeIn {

    @XmlElement(name = "ChangeListID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String changeListID;
    @XmlElement(name = "IntegratedConfiguration")
    protected List<RestrictedIntegratedConfiguration> integratedConfiguration;

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
     * {@link RestrictedIntegratedConfiguration }
     * 
     * 
     */
    public List<RestrictedIntegratedConfiguration> getIntegratedConfiguration() {
        if (integratedConfiguration == null) {
            integratedConfiguration = new ArrayList<RestrictedIntegratedConfiguration>();
        }
        return this.integratedConfiguration;
    }

}
