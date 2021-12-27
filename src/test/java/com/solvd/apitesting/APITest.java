package com.solvd.apitesting;

import org.testng.annotations.Test;

import java.util.UUID;

public class APITest {

    @Test
    public void verifyUser(){
        GetUserMethod getUserMethod = new GetUserMethod();
        getUserMethod.setHeaders(String.format("Authorization=%s", "token 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"));
        getUserMethod.callAPI();
        getUserMethod.validateResponse();
    }

    @Test
    public void verifyRepositories(){
        GetRepositoriesMethod getRepositoriesMethod = new GetRepositoriesMethod();
        getRepositoriesMethod.setHeaders(String.format("Authorization=%s", "token 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"));
        getRepositoriesMethod.callAPI();
        getRepositoriesMethod.validateResponse();
    }

    @Test
    public void verifyCreatedRepository(){
        CreateRepositoryMethod createRepositoryMethod = new CreateRepositoryMethod();
        createRepositoryMethod.setHeaders(String.format("Authorization=%s", "token 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"));
        createRepositoryMethod.addProperty("name", UUID.randomUUID().toString());
        createRepositoryMethod.callAPI();
        createRepositoryMethod.validateResponse();
    }
}
