package org.example.dictionaryeejaxws.server.service.impl;

import org.example.dictionaryeejaxws.server.dto.XmlWords;
import org.example.dictionaryeejaxws.server.entity.Task;
import org.example.dictionaryeejaxws.server.repository.api.DictionaryRepository;
import org.example.dictionaryeejaxws.server.service.api.FileService;
import org.example.dictionaryeejaxws.server.service.api.XmlService;
import org.example.dictionaryeejaxws.server.validator.api.XmlValidator;
import org.xml.sax.SAXException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

@Stateless
public class XmlServiceImpl implements XmlService {

    @EJB
    private DictionaryRepository dictionaryRepository;
    @EJB
    private XmlValidator validator;
    @EJB
    private FileService fileService;
    private static final Logger logger = Logger.getLogger(XmlServiceImpl.class.getName());

    @Override
    public void createXmlDoc(Task task) throws JAXBException, IOException, SAXException {
        XmlWords words = new XmlWords(dictionaryRepository.findAllWordsByCreationDate(task.getCreationDate()));
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlWords.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        File file = fileService.getFile("META-INF/Words.xml");
        marshaller.marshal(words, file);
        validator.validate(file);
        logger.info("XML-файл создан");
    }

    @Override
    public File getXmlDoc() {
        return fileService.getFile("");
    }

    @Override
    public void processXmlDoc(File file) throws TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        File toWrite = fileService.getFile("META-INF/WordsConsumed.xml");
        File xsl = fileService.getFile("META-INF/Words.xsl");
        Transformer transformer = tf.newTransformer(new StreamSource(xsl));
        transformer.transform(new StreamSource(file), new StreamResult(toWrite));
    }
}
