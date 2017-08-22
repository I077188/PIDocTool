
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VirusScanCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="VirusScanCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Use Global"/>
 *     &lt;enumeration value="No Virus Scan"/>
 *     &lt;enumeration value="Virus Scan by Adapter"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "VirusScanCode")
@XmlEnum
public enum VirusScanCode {

    @XmlEnumValue("Use Global")
    USE_GLOBAL("Use Global"),
    @XmlEnumValue("No Virus Scan")
    NO_VIRUS_SCAN("No Virus Scan"),
    @XmlEnumValue("Virus Scan by Adapter")
    VIRUS_SCAN_BY_ADAPTER("Virus Scan by Adapter");
    private final String value;

    VirusScanCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static VirusScanCode fromValue(String v) {
        for (VirusScanCode c: VirusScanCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
