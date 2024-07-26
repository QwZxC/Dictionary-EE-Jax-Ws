package org.example.dictionaryeejaxws.server.mongo;

import com.mongodb.MongoClient;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class MongoClientProvider {

    private MongoClient mongoClient;

    @Lock(LockType.READ)
    public MongoClient getMongoClient() {
        return mongoClient;
    }

    @PostConstruct
    public void init() {
        mongoClient = new MongoClient("localhost", 27017);
    }
}
