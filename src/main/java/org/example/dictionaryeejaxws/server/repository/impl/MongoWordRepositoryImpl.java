package org.example.dictionaryeejaxws.server.repository.impl;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.example.dictionaryeejaxws.server.entity.Word;
import org.example.dictionaryeejaxws.server.mapper.WordMapper;
import org.example.dictionaryeejaxws.server.mongo.MongoClientProvider;
import org.example.dictionaryeejaxws.server.repository.api.MongoWordRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class MongoWordRepositoryImpl implements MongoWordRepository {

    @EJB
    private MongoClientProvider mongoClientProvider;
    private static final String DB_NAME = "DictionaryDb";
    private static final String COLLECTION_NAME = "words";
    private final Logger logger = Logger.getLogger("MongoWordRepositoryImpl");

    @Override
    public List<Word> findAllWords() {
        logger.info("Запрос на выборку всех слов из MongoDb");
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        MongoDatabase db = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> collection = db.getCollection(COLLECTION_NAME);
        List<Document> result = collection.find().into(new ArrayList<>());
        return getResultList(result);
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
    public List<Word> findAllWordsByValue(String value) {
        logger.info("Запрос на выборку всех слов подходящих по значению из MongoDb");
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        MongoDatabase db = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> collection = db.getCollection(COLLECTION_NAME);
        Document filter = new Document("value", value);
        ArrayList<Document> result = collection.find(filter).into(new ArrayList<>());
        return getResultList(result);
    }

    @Override
    public Word findWordById(String id) {
        logger.info("Запрос на выборку всех слов подходящих по id из MongoDb");
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        MongoDatabase db = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> collection = db.getCollection(COLLECTION_NAME);
        Document filter = new Document("id", id);
        ArrayList<Document> result = collection.find(filter).into(new ArrayList<>());
        return WordMapper.deserializeWord(result.get(0).toJson());
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
    public void createWord(Word word) {
        logger.info("Запрос на создание слова в MongoDb");
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        MongoDatabase db = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> collection = db.getCollection(COLLECTION_NAME);
        Document doc = new Document("id", word.getId());
        doc.append("value", word.getValue())
                .append("translation", word.getTranslation())
                .append("dictionary-type", word.getDictionaryType().toString())
                .append("creation-date", word.getCreationDate());
        collection.insertOne(doc);
    }
}
