
package com.sap.xi.basis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AtomicConditionBlock complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AtomicConditionBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AtomicCondition" type="{http://sap.com/xi/BASIS}AtomicCondition" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AtomicConditionBlock", propOrder = {
    "atomicCondition"
})
public class AtomicConditionBlock {

    @XmlElement(name = "AtomicCondition")
    protected List<AtomicCondition> atomicCondition;

    /**
     * Gets the value of the atomicCondition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the atomicCondition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAtomicCondition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AtomicCondition }
     * 
     * 
     */
    public List<AtomicCondition> getAtomicCondition() {
        if (atomicCondition == null) {
            atomicCondition = new ArrayList<AtomicCondition>();
        }
        return this.atomicCondition;
    }

}
