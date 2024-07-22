package org.example.dictionaryeejaxws.server.dto;

import org.example.dictionaryeejaxws.server.entity.DictionaryType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "word-dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class WordDto implements Serializable {

    @XmlElement
    private String value;
    @XmlElement
    private String translation;
    @XmlElement(name = "dictionary-type")
    private DictionaryType dictionaryType;

    public WordDto() {

    }

    public WordDto(String value, String translation, DictionaryType dictionaryType) {
        this.value = value;
        this.translation = translation;
        this.dictionaryType = dictionaryType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public DictionaryType getDictionaryType() {
        return dictionaryType;
    }

    public void setDictionaryType(DictionaryType dictionaryType) {
        this.dictionaryType = dictionaryType;
    }
}
