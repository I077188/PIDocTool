
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExtractorTypeCode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExtractorTypeCode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="XPath"/>
 *     &lt;enumeration value="Context Object"/>
 *     &lt;enumeration value="Technical Context Object"/>
 *     &lt;enumeration value="Constant"/>
 *     &lt;enumeration value="Message Header Field"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExtractorTypeCode")
@XmlEnum
public enum ExtractorTypeCode {

    @XmlEnumValue("XPath")
    X_PATH("XPath"),
    @XmlEnumValue("Context Object")
    CONTEXT_OBJECT("Context Object"),
    @XmlEnumValue("Technical Context Object")
    TECHNICAL_CONTEXT_OBJECT("Technical Context Object"),
    @XmlEnumValue("Constant")
    CONSTANT("Constant"),
    @XmlEnumValue("Message Header Field")
    MESSAGE_HEADER_FIELD("Message Header Field");
    private final String value;

    ExtractorTypeCode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ExtractorTypeCode fromValue(String v) {
        for (ExtractorTypeCode c: ExtractorTypeCode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
