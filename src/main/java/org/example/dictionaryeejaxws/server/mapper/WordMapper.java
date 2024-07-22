package org.example.dictionaryeejaxws.server.mapper;

import org.example.dictionaryeejaxws.server.dto.WordDto;
import org.example.dictionaryeejaxws.server.entity.Word;

import java.util.ArrayList;
import java.util.List;

public class WordMapper {

    public static List<WordDto> toDtos(List<Word> words) {
        List<WordDto> dtos = new ArrayList<>(words.size());
        words.forEach(word -> dtos.add(new WordDto(word.getValue(), word.getTranslation(), word.getDictionaryType())));
        return dtos;
    }

    public static Word toEntity(WordDto dto) {
        return new Word(dto.getValue(), dto.getTranslation(), dto.getDictionaryType());
    }
}
