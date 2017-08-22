
package com.sap.xi.basis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Condition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Condition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AtomicConditionBlock" type="{http://sap.com/xi/BASIS}AtomicConditionBlock" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Condition", propOrder = {
    "atomicConditionBlock"
})
public class Condition {

    @XmlElement(name = "AtomicConditionBlock")
    protected List<AtomicConditionBlock> atomicConditionBlock;

    /**
     * Gets the value of the atomicConditionBlock property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the atomicConditionBlock property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAtomicConditionBlock().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AtomicConditionBlock }
     * 
     * 
     */
    public List<AtomicConditionBlock> getAtomicConditionBlock() {
        if (atomicConditionBlock == null) {
            atomicConditionBlock = new ArrayList<AtomicConditionBlock>();
        }
        return this.atomicConditionBlock;
    }

}
