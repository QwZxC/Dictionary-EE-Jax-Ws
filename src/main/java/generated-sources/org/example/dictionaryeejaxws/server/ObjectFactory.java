
package org.example.dictionaryeejaxws.server;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.dictionaryeejaxws.server package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _WordDto_QNAME = new QName("http://api.webservice.server.dictionaryeejaxws.example.org/", "word-dto");
    private final static QName _CreationDate_QNAME = new QName("Words.xsd", "creation-date");
    private final static QName _DictionaryType_QNAME = new QName("Words.xsd", "dictionary-type");
    private final static QName _Id_QNAME = new QName("Words.xsd", "id");
    private final static QName _Translation_QNAME = new QName("Words.xsd", "translation");
    private final static QName _Value_QNAME = new QName("Words.xsd", "value");
    private final static QName _Word_QNAME = new QName("Words.xsd", "word");
    private final static QName _Words_QNAME = new QName("Words.xsd", "words");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.dictionaryeejaxws.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link WordDto }
     * 
     */
    public WordDto createWordDto() {
        return new WordDto();
    }

    /**
     * Create an instance of {@link XmlWords }
     * 
     */
    public XmlWords createXmlWords() {
        return new XmlWords();
    }

    /**
     * Create an instance of {@link Word }
     * 
     */
    public Word createWord() {
        return new Word();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WordDto }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WordDto }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.webservice.server.dictionaryeejaxws.example.org/", name = "word-dto")
    public JAXBElement<WordDto> createWordDto(WordDto value) {
        return new JAXBElement<WordDto>(_WordDto_QNAME, WordDto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "Words.xsd", name = "creation-date")
    public JAXBElement<String> createCreationDate(String value) {
        return new JAXBElement<String>(_CreationDate_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DictionaryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DictionaryType }{@code >}
     */
    @XmlElementDecl(namespace = "Words.xsd", name = "dictionary-type")
    public JAXBElement<DictionaryType> createDictionaryType(DictionaryType value) {
        return new JAXBElement<DictionaryType>(_DictionaryType_QNAME, DictionaryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     */
    @XmlElementDecl(namespace = "Words.xsd", name = "id")
    public JAXBElement<Long> createId(Long value) {
        return new JAXBElement<Long>(_Id_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "Words.xsd", name = "translation")
    public JAXBElement<String> createTranslation(String value) {
        return new JAXBElement<String>(_Translation_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "Words.xsd", name = "value")
    public JAXBElement<String> createValue(String value) {
        return new JAXBElement<String>(_Value_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Word }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Word }{@code >}
     */
    @XmlElementDecl(namespace = "Words.xsd", name = "word")
    public JAXBElement<Word> createWord(Word value) {
        return new JAXBElement<Word>(_Word_QNAME, Word.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XmlWords }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XmlWords }{@code >}
     */
    @XmlElementDecl(namespace = "Words.xsd", name = "words")
    public JAXBElement<XmlWords> createWords(XmlWords value) {
        return new JAXBElement<XmlWords>(_Words_QNAME, XmlWords.class, null, value);
    }

}
