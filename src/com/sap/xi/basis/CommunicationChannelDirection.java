
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommunicationChannelDirection.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CommunicationChannelDirection">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Sender"/>
 *     &lt;enumeration value="Receiver"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CommunicationChannelDirection")
@XmlEnum
public enum CommunicationChannelDirection {

    @XmlEnumValue("Sender")
    SENDER("Sender"),
    @XmlEnumValue("Receiver")
    RECEIVER("Receiver");
    private final String value;

    CommunicationChannelDirection(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CommunicationChannelDirection fromValue(String v) {
        for (CommunicationChannelDirection c: CommunicationChannelDirection.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
