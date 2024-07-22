package org.example.dictionaryeejaxws.server.repository.api;

import org.example.dictionaryeejaxws.server.entity.DictionaryType;
import org.example.dictionaryeejaxws.server.entity.Word;

import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.List;

@Stateless
public interface DictionaryRepository {

    List<Word> findWords(DictionaryType type);
    Word findTranslation(Word word);
    List<Word> findAllWordsByCreationDate(LocalDate date);
    Word findWordByValue(String value);
    void createWord(Word word);
    void updateWord(Word word);
    void deleteWord(Word word);
}
