package org.example.dictionaryeejaxws.server.repository.impl;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.example.dictionaryeejaxws.server.entity.DictionaryType;
import org.example.dictionaryeejaxws.server.entity.Word;
import org.example.dictionaryeejaxws.server.mapper.WordMapper;
import org.example.dictionaryeejaxws.server.mongo.MongoClientProvider;
import org.example.dictionaryeejaxws.server.qualifier.MongoRepositoryAnnotation;
import org.example.dictionaryeejaxws.server.repository.api.DictionaryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@MongoRepositoryAnnotation
@ApplicationScoped
@Named("MongoRepository")
public class MongoWordRepositoryImpl implements DictionaryRepository {

    @Inject
    private MongoClientProvider mongoClientProvider;
    private static final String DB_NAME = "DictionaryDb";
    private static final String COLLECTION_NAME = "words";
    private static final String VALUE_PROPERTY = "value";
    private final Logger logger = Logger.getLogger("MongoWordRepositoryImpl");

    @Override
    public List<Word> findWords(DictionaryType type) {
        logger.info("Запрос на выборку всех слов из MongoDb");
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        MongoDatabase db = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> collection = db.getCollection(COLLECTION_NAME);
        Document filter = new Document("dictionary-type", type.toString());
        List<Document> result = collection.find(filter).into(new ArrayList<>());
        return getResultList(result);
    }

    @Override
    public Word findTranslation(Word word) {
        logger.info("Запрос на выборку всех слов подходящих по значению из MongoDb");
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        MongoDatabase db = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> collection = db.getCollection(COLLECTION_NAME);
        Document filter = new Document(VALUE_PROPERTY, word.getValue());
        ArrayList<Document> result = collection.find(filter).into(new ArrayList<>());
        return WordMapper.deserializeWord(result.get(0).toJson());
    }

    @Override
    public Word findWordByValue(String value) {
        logger.info("Запрос на выборку всех слов подходящих по значению из MongoDb");
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        MongoDatabase db = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> collection = db.getCollection(COLLECTION_NAME);
        Document filter = new Document(VALUE_PROPERTY, value);
        ArrayList<Document> result = collection.find(filter).into(new ArrayList<>());
        return WordMapper.deserializeWord(result.get(0).toJson());
    }

    private List<Word> getResultList(List<Document> result) {
        List<Word> words = new ArrayList<>();
        for (Document document : result) {
            document.toJson();
            words.add(WordMapper.deserializeWord(document.toJson()));
        }
        return words;
    }

    @Override
    public void updateWord(Word word) {
        logger.info("Запрос на обновление слова в MongoDb");
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        MongoDatabase db = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> collection = db.getCollection(COLLECTION_NAME);
        collection.updateOne(new Document("id", word.getId()),
                new Document("$set", new Document("translation", word.getTranslation())));
    }

    @Override
    public void deleteWord(Word word) {
        logger.info("Запрос на удаление слова в MongoDb");
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        MongoDatabase db = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> collection = db.getCollection(COLLECTION_NAME);
        collection.deleteOne(Filters.eq("id", word.getId()));
    }

    @Override
    public List<Word> findAllWordsByCreationDate(LocalDate date) {
        return List.of();
    }

    @Override
    public void createWord(Word word) {
        logger.info("Запрос на создание слова в MongoDb");
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        MongoDatabase db = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> collection = db.getCollection(COLLECTION_NAME);
        Document doc = new Document("id", word.getId());
        doc.append(VALUE_PROPERTY, word.getValue())
                .append("translation", word.getTranslation())
                .append("dictionary-type", word.getDictionaryType().toString())
                .append("creation-date", word.getCreationDate());
        collection.insertOne(doc);
    }
}
