package org.example.dictionaryeejaxws.server.service.impl;

import org.example.dictionaryeejaxws.server.dto.XmlWords;
import org.example.dictionaryeejaxws.server.entity.Task;
import org.example.dictionaryeejaxws.server.repository.api.DictionaryRepository;
import org.example.dictionaryeejaxws.server.service.api.XmlService;
import org.example.dictionaryeejaxws.server.validator.api.XmlValidator;
import org.xml.sax.SAXException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

@Stateless
public class XmlServiceImpl implements XmlService {

    @EJB
    private DictionaryRepository dictionaryRepository;
    @EJB
    private XmlValidator validator;
    private static final Logger logger = Logger.getLogger(XmlServiceImpl.class.getName());

    @Override
    public void createXmlDoc(Task task) throws JAXBException, IOException, SAXException {
        XmlWords words = new XmlWords(dictionaryRepository.findAllWordsByCreationDate(task.getCreationDate()));
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlWords.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File file = getXmlDoc();
        marshaller.marshal(words, file);
        marshaller.marshal(words, System.out);
        validator.validate();
        logger.info("XML-файл создан");
    }

    @Override
    public File getXmlDoc() {
        return  new File(Thread.currentThread().getContextClassLoader().getResource("META-INF/Words.xml").getFile());
    }
}
