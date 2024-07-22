
package org.example.dictionaryeejaxws.server;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dictionaryType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="dictionaryType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="LETTERS"/&gt;
 *     &lt;enumeration value="NUMBERS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "dictionaryType")
@XmlEnum
public enum DictionaryType {

    LETTERS,
    NUMBERS;

    public String value() {
        return name();
    }

    public static DictionaryType fromValue(String v) {
        return valueOf(v);
    }

}
