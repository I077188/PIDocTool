
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReadContextCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReadContextCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="User"/>
 *     &lt;enumeration value="Active"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReadContextCode")
@XmlEnum
public enum ReadContextCode {

    @XmlEnumValue("User")
    USER("User"),
    @XmlEnumValue("Active")
    ACTIVE("Active");
    private final String value;

    ReadContextCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReadContextCode fromValue(String v) {
        for (ReadContextCode c: ReadContextCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
