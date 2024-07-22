package org.example.dictionaryeejaxws.server.dto;

import org.example.dictionaryeejaxws.server.entity.Word;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "words", namespace = "Words.xsd")
public class XmlWords implements Serializable {

    @XmlElement(name = "word",namespace = "Words.xsd")
    private List<Word> words;

    public XmlWords() {}

    public XmlWords(List<Word> words) {
        this.words = words;
    }

    public List<Word> getWords() {
        return words;
    }
}