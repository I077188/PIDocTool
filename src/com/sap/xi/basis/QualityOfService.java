
package com.sap.xi.basis;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QualityOfService.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="QualityOfService">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="EOIO"/>
 *     &lt;enumeration value="EO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "QualityOfService")
@XmlEnum
public enum QualityOfService {

    EOIO,
    EO;

    public String value() {
        return name();
    }

    public static QualityOfService fromValue(String v) {
        return valueOf(v);
    }

}
