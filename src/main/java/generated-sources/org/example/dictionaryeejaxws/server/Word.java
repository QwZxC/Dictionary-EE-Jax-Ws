
package org.example.dictionaryeejaxws.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for word complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="word"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{Words.xsd}id" minOccurs="0"/&gt;
 *         &lt;element ref="{Words.xsd}value" minOccurs="0"/&gt;
 *         &lt;element ref="{Words.xsd}translation" minOccurs="0"/&gt;
 *         &lt;element ref="{Words.xsd}dictionary-type" minOccurs="0"/&gt;
 *         &lt;element ref="{Words.xsd}creation-date" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "word", propOrder = {
    "id",
    "value",
    "translation",
    "dictionaryType",
    "creationDate"
})
public class Word {

    @XmlElement(namespace = "Words.xsd")
    protected Long id;
    @XmlElement(namespace = "Words.xsd")
    protected String value;
    @XmlElement(namespace = "Words.xsd")
    protected String translation;
    @XmlElement(name = "dictionary-type", namespace = "Words.xsd")
    @XmlSchemaType(name = "string")
    protected DictionaryType dictionaryType;
    @XmlElement(name = "creation-date", namespace = "Words.xsd")
    protected String creationDate;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the translation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranslation() {
        return translation;
    }

    /**
     * Sets the value of the translation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranslation(String value) {
        this.translation = value;
    }

    /**
     * Gets the value of the dictionaryType property.
     * 
     * @return
     *     possible object is
     *     {@link DictionaryType }
     *     
     */
    public DictionaryType getDictionaryType() {
        return dictionaryType;
    }

    /**
     * Sets the value of the dictionaryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DictionaryType }
     *     
     */
    public void setDictionaryType(DictionaryType value) {
        this.dictionaryType = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationDate(String value) {
        this.creationDate = value;
    }

}
