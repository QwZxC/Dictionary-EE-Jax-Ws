package org.example.dictionaryeejaxws.server.service.api;

import org.example.dictionaryeejaxws.server.dto.WordDto;
import org.example.dictionaryeejaxws.server.dto.XmlWords;
import org.example.dictionaryeejaxws.server.entity.DictionaryType;
import org.example.dictionaryeejaxws.server.entity.Word;

import javax.ejb.Stateless;

@Stateless
public interface DictionaryService {

    XmlWords findWords(DictionaryType type);
    Word findTranslation(String value);
    void createWord(WordDto word);
    void updateWord(WordDto word);
    void deleteWord(WordDto word);
}
