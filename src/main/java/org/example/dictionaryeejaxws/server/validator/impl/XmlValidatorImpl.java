package org.example.dictionaryeejaxws.server.validator.impl;

import org.example.dictionaryeejaxws.server.validator.api.XmlValidator;
import org.xml.sax.SAXException;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class XmlValidatorImpl implements XmlValidator {

    private Validator validator;
    private final Logger logger = Logger.getLogger(XmlValidatorImpl.class.getName());

    @PostConstruct
    private void initValidator() {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(getFile("META-INF/Words.xsd"));
        try {
            Schema schema = factory.newSchema(schemaFile);
            validator = schema.newValidator();
        } catch (SAXException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }

    private File getFile(String location) {
        String file = Thread.currentThread().getContextClassLoader().getResource(location).getFile();
        return new File(file);
    }

    @Override
    public void validate(File file) throws IOException, SAXException {
        validator.validate(new StreamSource(file));
        logger.info("Файл валиден");
    }
}
