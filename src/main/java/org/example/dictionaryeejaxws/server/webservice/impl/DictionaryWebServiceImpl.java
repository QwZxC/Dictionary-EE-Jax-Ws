package org.example.dictionaryeejaxws.server.webservice.impl;

import org.example.dictionaryeejaxws.server.dto.XmlWords;
import org.example.dictionaryeejaxws.server.dto.WordDto;
import org.example.dictionaryeejaxws.server.entity.DictionaryType;
import org.example.dictionaryeejaxws.server.entity.Word;
import org.example.dictionaryeejaxws.server.service.api.DictionaryService;
import org.example.dictionaryeejaxws.server.webservice.api.DictionaryWebService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@WebService(endpointInterface = "org.example.dictionaryeejaxws.server.webservice.api.DictionaryWebService")
@Stateless
public class DictionaryWebServiceImpl implements DictionaryWebService {

    @EJB
    private DictionaryService dictionaryService;

    @Override
    public XmlWords getWords(@WebParam(name = "type")DictionaryType type) {
        return dictionaryService.findWords(type);
    }

    @Produces(MediaType.APPLICATION_XML)
    @Override
    public Word getTranslation(@QueryParam("value") String value) {
        return dictionaryService.findTranslation(value);
    }

    @Produces(MediaType.APPLICATION_XML)
    @Override
    public void createWord(WordDto dto) {
        dictionaryService.createWord(dto);
    }

    @Produces(MediaType.APPLICATION_XML)
    @Override
    public void updateTranslation(WordDto dto) {
        dictionaryService.updateWord(dto);
    }

    @Produces(MediaType.APPLICATION_XML)
    @Override
    public void deleteWord(WordDto dto) {
        dictionaryService.deleteWord(dto);
    }

}
