package org.example.dictionaryeejaxws.server.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.dictionaryeejaxws.server.dto.WordDto;
import org.example.dictionaryeejaxws.server.entity.Word;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WordMapper {

    private static final Logger LOGGER = Logger.getLogger("WordMapper");

    private WordMapper() {

    }

    public static Word deserializeWord(String json) {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        try {
            return mapper.readValue(json, Word.class);
        } catch (JsonProcessingException e) {
            LOGGER.log(Level.WARNING, e.getMessage());
        }
        return null;
    }

    public static Word toEntity(WordDto dto) {
        return new Word(dto.getValue(), dto.getTranslation(), dto.getDictionaryType());
    }
}
