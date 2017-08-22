
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for AtomicCondition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AtomicCondition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Operator" type="{http://sap.com/xi/BASIS/Global}CompareOperatorCode" minOccurs="0"/>
 *         &lt;element name="LeftExtractor" type="{http://sap.com/xi/BASIS}Extractor" minOccurs="0"/>
 *         &lt;element name="RightExtractor" type="{http://sap.com/xi/BASIS}Extractor" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AtomicCondition", propOrder = {
    "operator",
    "leftExtractor",
    "rightExtractor"
})
public class AtomicCondition {

    @XmlElement(name = "Operator")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    protected String operator;
    @XmlElement(name = "LeftExtractor")
    protected Extractor leftExtractor;
    @XmlElement(name = "RightExtractor")
    protected Extractor rightExtractor;

    /**
     * Gets the value of the operator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Sets the value of the operator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperator(String value) {
        this.operator = value;
    }

    /**
     * Gets the value of the leftExtractor property.
     * 
     * @return
     *     possible object is
     *     {@link Extractor }
     *     
     */
    public Extractor getLeftExtractor() {
        return leftExtractor;
    }

    /**
     * Sets the value of the leftExtractor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Extractor }
     *     
     */
    public void setLeftExtractor(Extractor value) {
        this.leftExtractor = value;
    }

    /**
     * Gets the value of the rightExtractor property.
     * 
     * @return
     *     possible object is
     *     {@link Extractor }
     *     
     */
    public Extractor getRightExtractor() {
        return rightExtractor;
    }

    /**
     * Sets the value of the rightExtractor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Extractor }
     *     
     */
    public void setRightExtractor(Extractor value) {
        this.rightExtractor = value;
    }

}
