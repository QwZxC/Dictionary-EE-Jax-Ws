package org.example.dictionaryeejaxws.server.entity;

import org.example.dictionaryeejaxws.server.adapter.LocalDateAdapter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "word")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlElement(name = "id", namespace = "Words.xsd")
    private Long id;

    @Column(name = "value", nullable = false)
    @XmlElement(name = "value", namespace = "Words.xsd")
    private String value;

    @Column(name = "translation", nullable = false)
    @XmlElement(name = "translation", namespace = "Words.xsd")
    private String translation;

    @Enumerated(EnumType.STRING)
    @Column(name = "dictionaryType", nullable = false)
    @XmlElement(name = "dictionary-type", namespace = "Words.xsd")
    private DictionaryType dictionaryType;

    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @Column(name = "creationDate", nullable = false)
    @XmlElement(name = "creation-date", namespace = "Words.xsd")
    private LocalDate creationDate;

    public Word() {

    }

    public Word(String value) {
        this.value = value;
    }

    public Word(String value, String translation, DictionaryType dictionaryType) {
        this.value = value;
        this.translation = translation;
        this.dictionaryType = dictionaryType;
        creationDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(id, word.id) && Objects.equals(value, word.value) && Objects.equals(translation, word.translation) && dictionaryType == word.dictionaryType && Objects.equals(creationDate, word.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, translation, dictionaryType, creationDate);
    }
}
