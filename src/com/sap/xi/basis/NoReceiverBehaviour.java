
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NoReceiverBehaviour.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="NoReceiverBehaviour">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Error Message"/>
 *     &lt;enumeration value="Specified Receiver"/>
 *     &lt;enumeration value="Ignore"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "NoReceiverBehaviour")
@XmlEnum
public enum NoReceiverBehaviour {

    @XmlEnumValue("Error Message")
    ERROR_MESSAGE("Error Message"),
    @XmlEnumValue("Specified Receiver")
    SPECIFIED_RECEIVER("Specified Receiver"),
    @XmlEnumValue("Ignore")
    IGNORE("Ignore");
    private final String value;

    NoReceiverBehaviour(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NoReceiverBehaviour fromValue(String v) {
        for (NoReceiverBehaviour c: NoReceiverBehaviour.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
