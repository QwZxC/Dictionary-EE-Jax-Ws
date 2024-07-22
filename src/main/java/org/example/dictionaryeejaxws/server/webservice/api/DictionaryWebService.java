package org.example.dictionaryeejaxws.server.webservice.api;

import org.example.dictionaryeejaxws.server.dto.SoapResponse;
import org.example.dictionaryeejaxws.server.dto.WordDto;
import org.example.dictionaryeejaxws.server.dto.XmlWords;
import org.example.dictionaryeejaxws.server.entity.DictionaryType;
import org.example.dictionaryeejaxws.server.entity.Word;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface DictionaryWebService {

    @WebMethod
    XmlWords getWords(DictionaryType dictionaryType);
    @WebMethod
    Word getTranslation(String value);
    @WebMethod
    SoapResponse createWord(WordDto dto);
    @WebMethod
    SoapResponse updateTranslation(WordDto dto);
    @WebMethod
    SoapResponse deleteWord(WordDto dto);
}
