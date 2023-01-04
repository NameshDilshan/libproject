package com.library.student.datasource;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class Database { 
	
	public MongoDatabase getCollection() {
        String uri = "mongodb://localhost:27017";
        MongoClientURI mongoClientURI = new MongoClientURI(uri);
        MongoClient mongoClient = new MongoClient(mongoClientURI);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("studentlibrary01");
//        MongoCollection<Document> collection = mongoDatabase.getCollection("test1");
        return  mongoDatabase;
    }

}
