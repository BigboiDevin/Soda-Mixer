package com.devin.sodamixer;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class FrontPage {
    MongoClientURI uri = new MongoClientURI("mongodb+srv://kay:myRealPassword@cluster0.mongodb.net/");
    MongoClient mongoClient = new MongoClient(uri);
    MongoDatabase database = mongoClient.getDatabase("test");
}