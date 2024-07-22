package org.example.dictionaryeejaxws.server.service.impl;

import org.example.dictionaryeejaxws.server.dto.WordDto;
import org.example.dictionaryeejaxws.server.dto.XmlWords;
import org.example.dictionaryeejaxws.server.entity.DictionaryType;
import org.example.dictionaryeejaxws.server.entity.Word;
import org.example.dictionaryeejaxws.server.mapper.WordMapper;
import org.example.dictionaryeejaxws.server.repository.api.DictionaryRepository;
import org.example.dictionaryeejaxws.server.service.api.DictionaryService;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class DictionaryServiceImpl implements DictionaryService {

    @EJB
    private DictionaryRepository dictionaryRepository;

    @Override
    public XmlWords findWords(DictionaryType type) {
        return new XmlWords(dictionaryRepository.findWords(type));
    }

    @Override
    public Word findTranslation(String value) {
        Word word = dictionaryRepository.findWordByValue(value);
        return dictionaryRepository.findTranslation(word);
    }

    @Override
    public void createWord(WordDto word) {
        dictionaryRepository.createWord(WordMapper.toEntity(word));
    }

    @Override
    public void updateWord(WordDto word) {
        dictionaryRepository.updateWord(WordMapper.toEntity(word));
    }

    @Override
    public void deleteWord(WordDto word) {
        dictionaryRepository.deleteWord(WordMapper.toEntity(word));
    }
}
