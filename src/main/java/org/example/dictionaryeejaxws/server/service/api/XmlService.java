package org.example.dictionaryeejaxws.server.service.api;

import org.example.dictionaryeejaxws.server.entity.Task;
import org.xml.sax.SAXException;

import javax.ejb.Stateless;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

@Stateless
public interface XmlService {

    void createXmlDoc(Task task) throws JAXBException, IOException, SAXException;

    File getXmlDoc();
}
