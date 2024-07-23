package org.example.dictionaryeejaxws.server.jms.api;

import javax.ejb.Stateless;

@Stateless
public interface Producer {
    void produceMessage();
}
