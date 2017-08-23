
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
 * <p>Java class for ParameterGroup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParameterGroup">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ParameterGroupID" type="{http://sap.com/xi/BASIS}ParameterGroupID"/>
 *         &lt;element name="Parameter" type="{http://sap.com/xi/BASIS}RestrictedGenericProperty" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParameterGroup", propOrder = {
    "parameterGroupID",
    "parameter"
})
public class ParameterGroup {

    @XmlElement(name = "ParameterGroupID", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String parameterGroupID;
    @XmlElement(name = "Parameter", required = true)
    protected List<RestrictedGenericProperty> parameter;

    /**
     * Gets the value of the parameterGroupID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParameterGroupID() {
        return parameterGroupID;
    }

    /**
     * Sets the value of the parameterGroupID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParameterGroupID(String value) {
        this.parameterGroupID = value;
    }

    /**
     * Gets the value of the parameter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RestrictedGenericProperty }
     * 
     * 
     */
    public List<RestrictedGenericProperty> getParameter() {
        if (parameter == null) {
            parameter = new ArrayList<RestrictedGenericProperty>();
        }
        return this.parameter;
    }

}
