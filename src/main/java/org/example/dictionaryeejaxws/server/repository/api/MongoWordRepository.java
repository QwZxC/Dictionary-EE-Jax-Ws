package org.example.dictionaryeejaxws.server.repository.api;

import org.example.dictionaryeejaxws.server.entity.Word;

import java.util.List;

public interface MongoWordRepository {

    void findAllWords();
    List<Word> findAllWordsByValue(String value);
    Word findWordById(String id);
    void saveWord(Word word);
    void updateWord(Word word);
    void deleteWord(Word word);
    void createWord(Word word);
}
