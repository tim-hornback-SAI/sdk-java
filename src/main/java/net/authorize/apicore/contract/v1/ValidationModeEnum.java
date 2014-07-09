//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.08 at 05:59:48 PM PDT 
//


package net.authorize.apicore.contract.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for validationModeEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="validationModeEnum">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="testMode"/>
 *     &lt;enumeration value="liveMode"/>
 *     &lt;enumeration value="oldLiveMode"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "validationModeEnum")
@XmlEnum
public enum ValidationModeEnum {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("testMode")
    TEST_MODE("testMode"),
    @XmlEnumValue("liveMode")
    LIVE_MODE("liveMode"),
    @XmlEnumValue("oldLiveMode")
    OLD_LIVE_MODE("oldLiveMode");
    private final String value;

    ValidationModeEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ValidationModeEnum fromValue(String v) {
        for (ValidationModeEnum c: ValidationModeEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
