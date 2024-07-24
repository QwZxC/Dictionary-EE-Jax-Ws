package org.example.dictionaryeejaxws.server.jms.impl;

import org.example.dictionaryeejaxws.server.service.api.XmlService;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
import javax.jms.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

@MessageDriven(name = "Consumer",
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/ExpiryQueue")
        })
@Stateless
public class ConsumerImpl implements MessageListener {

    private final Logger logger = Logger.getLogger(this.getClass().getName());
    @EJB
    private XmlService xmlService;

    @Override
    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        logger.info("Принято сообщение");
        processMessage(objectMessage);
    }

    private void processMessage(ObjectMessage message) {
        logger.info("               Начата обработка файла             ");
        try {
            xmlService.processXmlDoc((File) message.getObject());
        } catch (Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        }
        logger.info("               Обработка файла закончена            ");
    }
}