package org.example.dictionaryeejaxws.server.repository.impl;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.example.dictionaryeejaxws.server.entity.Word;
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
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void findAllWords() {
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        MongoDatabase db = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> collection = db.getCollection(COLLECTION_NAME);
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                var word = new ArrayList<>(doc.values());
                String bson = String.format("%s: %s%n %s", word.get(1), word.get(2), word.get(3).getClass().getName());
                logger.info(bson);
            }
        }
    }

    @Override
    public List<Word> findAllWordsByValue(String value) {
        return List.of();
    }

    @Override
    public Word findWordById(String id) {
        return null;
    }

    @Override
    public void updateWord(Word word) {
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        MongoDatabase db = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> collection = db.getCollection(COLLECTION_NAME);
        collection.updateOne(new Document("id", word.getId()),
                new Document("$set", new Document("translation", word.getTranslation())));

    }

    @Override
    public void deleteWord(Word word) {
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        MongoDatabase db = mongoClient.getDatabase(DB_NAME);
        MongoCollection<Document> collection = db.getCollection(COLLECTION_NAME);
        collection.deleteOne(Filters.eq("id", word.getId()));
    }

    @Override
    public void createWord(Word word) {
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
