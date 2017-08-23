
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for ProcessStep complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessStep">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ModuleName" type="{http://sap.com/xi/BASIS/Global}LANGUAGEINDEPENDENT_Name"/>
 *         &lt;element name="ModuleType" type="{http://sap.com/xi/BASIS}ModuleTypeCode" minOccurs="0"/>
 *         &lt;element name="ParameterGroupID" type="{http://sap.com/xi/BASIS}ParameterGroupID" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessStep", propOrder = {
    "moduleName",
    "moduleType",
    "parameterGroupID"
})
public class ProcessStep {

    @XmlElement(name = "ModuleName", required = true)
    protected String moduleName;
    @XmlElement(name = "ModuleType")
    @XmlSchemaType(name = "token")
    protected ModuleTypeCode moduleType;
    @XmlElement(name = "ParameterGroupID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String parameterGroupID;

    /**
     * Gets the value of the moduleName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * Sets the value of the moduleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModuleName(String value) {
        this.moduleName = value;
    }

    /**
     * Gets the value of the moduleType property.
     * 
     * @return
     *     possible object is
     *     {@link ModuleTypeCode }
     *     
     */
    public ModuleTypeCode getModuleType() {
        return moduleType;
    }

    /**
     * Sets the value of the moduleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModuleTypeCode }
     *     
     */
    public void setModuleType(ModuleTypeCode value) {
        this.moduleType = value;
    }

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

}
