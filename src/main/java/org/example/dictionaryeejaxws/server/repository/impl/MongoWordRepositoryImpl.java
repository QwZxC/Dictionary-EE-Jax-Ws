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

@Stateless
public class MongoWordRepositoryImpl implements MongoWordRepository {

    @EJB
    private MongoClientProvider mongoClientProvider;

    @Override
    public void findAllWords() {
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        MongoDatabase db = mongoClient.getDatabase("DictionaryDb");
        MongoCollection<Document> collection = db.getCollection("words");
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                var word = new ArrayList<>(doc.values());
                System.out.printf("%s: %s%n %s", word.get(1), word.get(2), word.get(3).getClass().getName());
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
        MongoDatabase db = mongoClient.getDatabase("DictionaryDb");
        MongoCollection<Document> collection = db.getCollection("words");
        collection.updateOne(new Document("id", word.getId()),
                new Document("$set", new Document("translation", word.getTranslation())));
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                var words = new ArrayList<>(doc.values());
            }
        }
    }

    @Override
    public void deleteWord(Word word) {
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        MongoDatabase db = mongoClient.getDatabase("DictionaryDb");
        MongoCollection<Document> collection = db.getCollection("words");
        collection.deleteOne(Filters.eq("id", word.getId()));
    }

    @Override
    public void createWord(Word word) {
        MongoClient mongoClient = mongoClientProvider.getMongoClient();
        MongoDatabase db = mongoClient.getDatabase("DictionaryDb");
        MongoCollection<Document> collection = db.getCollection("words");
        Document doc = new Document("id", word.getId());
        doc.append("value", word.getValue())
                .append("translation", word.getTranslation())
                .append("dictionary-type", word.getDictionaryType().toString())
                .append("creation-date", word.getCreationDate());
        collection.insertOne(doc);
    }
}
