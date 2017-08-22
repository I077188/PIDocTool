
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for Extractor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Extractor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TypeID" type="{http://sap.com/xi/BASIS}ExtractorTypeCode" minOccurs="0"/>
 *         &lt;element name="Value" type="{http://sap.com/xi/BASIS/Global}LANGUAGEINDEPENDENT_Text" minOccurs="0"/>
 *         &lt;element name="Datatype" type="{http://sap.com/xi/BASIS/Global}LANGUAGEINDEPENDENT_Text" minOccurs="0"/>
 *         &lt;element name="ContextObjectName" type="{http://sap.com/xi/BASIS}DesignObjectName" minOccurs="0"/>
 *         &lt;element name="ContextObjectNamespace" type="{http://sap.com/xi/BASIS}DesignObjectNamespace" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Extractor", propOrder = {
    "typeID",
    "value",
    "datatype",
    "contextObjectName",
    "contextObjectNamespace"
})
public class Extractor {

    @XmlElement(name = "TypeID")
    @XmlSchemaType(name = "token")
    protected ExtractorTypeCode typeID;
    @XmlElement(name = "Value")
    protected String value;
    @XmlElement(name = "Datatype")
    protected String datatype;
    @XmlElement(name = "ContextObjectName")
    protected String contextObjectName;
    @XmlElement(name = "ContextObjectNamespace")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String contextObjectNamespace;

    /**
     * Gets the value of the typeID property.
     * 
     * @return
     *     possible object is
     *     {@link ExtractorTypeCode }
     *     
     */
    public ExtractorTypeCode getTypeID() {
        return typeID;
    }

    /**
     * Sets the value of the typeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtractorTypeCode }
     *     
     */
    public void setTypeID(ExtractorTypeCode value) {
        this.typeID = value;
    }

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
     * Gets the value of the datatype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatatype() {
        return datatype;
    }

    /**
     * Sets the value of the datatype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatatype(String value) {
        this.datatype = value;
    }

    /**
     * Gets the value of the contextObjectName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContextObjectName() {
        return contextObjectName;
    }

    /**
     * Sets the value of the contextObjectName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContextObjectName(String value) {
        this.contextObjectName = value;
    }

    /**
     * Gets the value of the contextObjectNamespace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContextObjectNamespace() {
        return contextObjectNamespace;
    }

    /**
     * Sets the value of the contextObjectNamespace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContextObjectNamespace(String value) {
        this.contextObjectNamespace = value;
    }

}
