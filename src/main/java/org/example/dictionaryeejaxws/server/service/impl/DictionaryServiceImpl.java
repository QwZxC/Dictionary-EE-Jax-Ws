package org.example.dictionaryeejaxws.server.service.impl;

import org.example.dictionaryeejaxws.server.dto.WordDto;
import org.example.dictionaryeejaxws.server.dto.XmlWords;
import org.example.dictionaryeejaxws.server.entity.DictionaryType;
import org.example.dictionaryeejaxws.server.entity.Word;
import org.example.dictionaryeejaxws.server.mapper.WordMapper;
import org.example.dictionaryeejaxws.server.repository.api.DictionaryRepository;
import org.example.dictionaryeejaxws.server.service.api.DictionaryService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;

@Stateless
public class DictionaryServiceImpl implements DictionaryService {

    private final DictionaryRepository dictionaryRepository;
    private final DictionaryRepository mongoWordRepository;

    @Inject
    public DictionaryServiceImpl(
            @Named("JpaRepository") DictionaryRepository dictionaryRepository,
            @Named("MongoRepository") DictionaryRepository mongoWordRepository
    ) {
        this.dictionaryRepository = dictionaryRepository;
        this.mongoWordRepository = mongoWordRepository;
    }

    @Override
    public XmlWords findWords(DictionaryType type) {
        mongoWordRepository.findWords(type);
        return new XmlWords(dictionaryRepository.findWords(type));
    }

    @Override
    public Word findTranslation(String value) {
        Word word = dictionaryRepository.findWordByValue(value);
        return dictionaryRepository.findTranslation(word);
    }

    @Override
    public void createWord(WordDto word) {
        Word newWord = WordMapper.toEntity(word);
        dictionaryRepository.createWord(newWord);
        mongoWordRepository.createWord(newWord);
    }

    @Override
    public void updateWord(WordDto word) {
        dictionaryRepository.updateWord(WordMapper.toEntity(word));
    }

    @Override
    public void deleteWord(WordDto word) {
        Word oldWord = dictionaryRepository.findWordByValue(word.getValue());
        dictionaryRepository.deleteWord(oldWord);
        mongoWordRepository.deleteWord(oldWord);
    }
}
