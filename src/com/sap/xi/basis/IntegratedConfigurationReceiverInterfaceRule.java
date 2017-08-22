
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
 * <p>Java class for IntegratedConfigurationReceiverInterfaceRule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IntegratedConfigurationReceiverInterfaceRule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Operation" type="{http://sap.com/xi/BASIS}Operation" minOccurs="0"/>
 *         &lt;element name="Condition" type="{http://sap.com/xi/BASIS}Condition" minOccurs="0"/>
 *         &lt;element name="Mapping" type="{http://sap.com/xi/BASIS}DesignObjectID" minOccurs="0"/>
 *         &lt;element name="MappingParameters" type="{http://sap.com/xi/BASIS}MappingParameters" minOccurs="0"/>
 *         &lt;element name="Interface" type="{http://sap.com/xi/BASIS}DesignObjectID" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IntegratedConfigurationReceiverInterfaceRule", propOrder = {
    "operation",
    "condition",
    "mapping",
    "mappingParameters",
    "_interface"
})
public class IntegratedConfigurationReceiverInterfaceRule {

    @XmlElement(name = "Operation")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String operation;
    @XmlElement(name = "Condition")
    protected Condition condition;
    @XmlElement(name = "Mapping")
    protected DesignObjectID mapping;
    @XmlElement(name = "MappingParameters")
    protected MappingParameters mappingParameters;
    @XmlElement(name = "Interface")
    protected List<DesignObjectID> _interface;

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
     * Gets the value of the condition property.
     * 
     * @return
     *     possible object is
     *     {@link Condition }
     *     
     */
    public Condition getCondition() {
        return condition;
    }

    /**
     * Sets the value of the condition property.
     * 
     * @param value
     *     allowed object is
     *     {@link Condition }
     *     
     */
    public void setCondition(Condition value) {
        this.condition = value;
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
     * Gets the value of the mappingParameters property.
     * 
     * @return
     *     possible object is
     *     {@link MappingParameters }
     *     
     */
    public MappingParameters getMappingParameters() {
        return mappingParameters;
    }

    /**
     * Sets the value of the mappingParameters property.
     * 
     * @param value
     *     allowed object is
     *     {@link MappingParameters }
     *     
     */
    public void setMappingParameters(MappingParameters value) {
        this.mappingParameters = value;
    }

    /**
     * Gets the value of the interface property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the interface property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInterface().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DesignObjectID }
     * 
     * 
     */
    public List<DesignObjectID> getInterface() {
        if (_interface == null) {
            _interface = new ArrayList<DesignObjectID>();
        }
        return this._interface;
    }

}
