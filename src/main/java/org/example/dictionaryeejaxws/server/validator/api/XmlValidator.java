package org.example.dictionaryeejaxws.server.validator.api;

import org.xml.sax.SAXException;

import javax.ejb.Stateless;
import java.io.IOException;

@Stateless
public interface XmlValidator {

    void validate() throws IOException, SAXException;
}
