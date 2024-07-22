package org.example.dictionaryeejaxws.server.webservice.impl;

import org.example.dictionaryeejaxws.server.dto.SoapResponse;
import org.example.dictionaryeejaxws.server.dto.WordDto;
import org.example.dictionaryeejaxws.server.dto.XmlWords;
import org.example.dictionaryeejaxws.server.entity.DictionaryType;
import org.example.dictionaryeejaxws.server.entity.Word;
import org.example.dictionaryeejaxws.server.service.api.DictionaryService;
import org.example.dictionaryeejaxws.server.webservice.api.DictionaryWebService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.QueryParam;

@WebService(endpointInterface = "org.example.dictionaryeejaxws.server.webservice.api.DictionaryWebService")
@Stateless
public class DictionaryWebServiceImpl implements DictionaryWebService {

    private static final String SUCCESS = "Successfully";
    @EJB
    private DictionaryService dictionaryService;

    @Override
    public XmlWords getWords(@WebParam(name = "type")DictionaryType type) {
        return dictionaryService.findWords(type);
    }

    @Override
    public Word getTranslation(@QueryParam("value") String value) {
        return dictionaryService.findTranslation(value);
    }

    @Override
    public SoapResponse createWord(WordDto dto) {
        dictionaryService.createWord(dto);
        return new SoapResponse(SUCCESS);
    }

    @Override
    public SoapResponse updateTranslation(WordDto dto) {
        dictionaryService.updateWord(dto);
        return new SoapResponse(SUCCESS);
    }

    @Override
    public SoapResponse deleteWord(WordDto dto) {
        dictionaryService.deleteWord(dto);
        return new SoapResponse(SUCCESS);
    }
}