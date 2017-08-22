
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for ReceiverDeterminationMapping complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReceiverDeterminationMapping">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Operation" type="{http://sap.com/xi/BASIS}Operation" minOccurs="0"/>
 *         &lt;element name="Mapping" type="{http://sap.com/xi/BASIS}DesignObjectID" minOccurs="0"/>
 *         &lt;element name="MappingParamters" type="{http://sap.com/xi/BASIS}MappingParameters" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReceiverDeterminationMapping", propOrder = {
    "operation",
    "mapping",
    "mappingParamters"
})
public class ReceiverDeterminationMapping {

    @XmlElement(name = "Operation")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String operation;
    @XmlElement(name = "Mapping")
    protected DesignObjectID mapping;
    @XmlElement(name = "MappingParamters")
    protected MappingParameters mappingParamters;

    /**
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperation(String value) {
        this.operation = value;
    }

    /**
     * Gets the value of the mapping property.
     * 
     * @return
     *     possible object is
     *     {@link DesignObjectID }
     *     
     */
    public DesignObjectID getMapping() {
        return mapping;
    }

    /**
     * Sets the value of the mapping property.
     * 
     * @param value
     *     allowed object is
     *     {@link DesignObjectID }
     *     
     */
    public void setMapping(DesignObjectID value) {
        this.mapping = value;
    }

    /**
     * Gets the value of the mappingParamters property.
     * 
     * @return
     *     possible object is
     *     {@link MappingParameters }
     *     
     */
    public MappingParameters getMappingParamters() {
        return mappingParamters;
    }

    /**
     * Sets the value of the mappingParamters property.
     * 
     * @param value
     *     allowed object is
     *     {@link MappingParameters }
     *     
     */
    public void setMappingParamters(MappingParameters value) {
        this.mappingParamters = value;
    }

}
