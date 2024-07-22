package org.example.dictionaryeejaxws.server;

import org.example.dictionaryeejaxws.server.webservice.api.DictionaryWebService;
import org.example.dictionaryeejaxws.server.webservice.impl.DictionaryWebServiceImpl;

import javax.xml.ws.Endpoint;

public class DictionaryApplication {

    public static void main(String[] args) {
        DictionaryWebService dictionaryWebService = new DictionaryWebServiceImpl();
        Endpoint.publish("http://localhost:1986/wss/dictionary", dictionaryWebService);
    }
}
