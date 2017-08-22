
package com.sap.xi.basis;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MappingParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MappingParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Integer" type="{http://sap.com/xi/BASIS}IntegerProperty" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="String" type="{http://sap.com/xi/BASIS}RestrictedGenericProperty" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Channel" type="{http://sap.com/xi/BASIS}ChannelProperty" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MappingParameters", propOrder = {
    "integer",
    "string",
    "channel"
})
public class MappingParameters {

    @XmlElement(name = "Integer")
    protected List<IntegerProperty> integer;
    @XmlElement(name = "String")
    protected List<RestrictedGenericProperty> string;
    @XmlElement(name = "Channel")
    protected List<ChannelProperty> channel;

    /**
     * Gets the value of the integer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the integer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInteger().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntegerProperty }
     * 
     * 
     */
    public List<IntegerProperty> getInteger() {
        if (integer == null) {
            integer = new ArrayList<IntegerProperty>();
        }
        return this.integer;
    }

    /**
     * Gets the value of the string property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the string property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getString().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RestrictedGenericProperty }
     * 
     * 
     */
    public List<RestrictedGenericProperty> getString() {
        if (string == null) {
            string = new ArrayList<RestrictedGenericProperty>();
        }
        return this.string;
    }

    /**
     * Gets the value of the channel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the channel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChannel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChannelProperty }
     * 
     * 
     */
    public List<ChannelProperty> getChannel() {
        if (channel == null) {
            channel = new ArrayList<ChannelProperty>();
        }
        return this.channel;
    }

}
