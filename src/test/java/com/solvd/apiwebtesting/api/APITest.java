package com.solvd.apiwebtesting.api;

import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import org.testng.annotations.Test;

public class APITest {

    @Test
    public void verifyUser() {
        GetUserMethod getUserMethod = new GetUserMethod();
        getUserMethod.setHeaders(String.format("Authorization=%s", "token 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"));
        getUserMethod.callAPI();
        getUserMethod.validateResponse();
    }

    @Test
    public void verifyRepositories() {
        GetRepositoriesMethod getRepositoriesMethod = new GetRepositoriesMethod();
        getRepositoriesMethod.setHeaders(String.format("Authorization=%s", "token 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"));
        getRepositoriesMethod.callAPI();
        getRepositoriesMethod.validateResponse();
    }

    @Test
    public void verifyCreatedRepository() {
        CreateRepositoryMethod createRepositoryMethod = new CreateRepositoryMethod();
        createRepositoryMethod.setHeaders(String.format("Authorization=%s", "token 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"));
        createRepositoryMethod.addProperty("name", "blog");
        createRepositoryMethod.callAPI();
        createRepositoryMethod.validateResponse();
    }

    @Test
    public void verifyRepoAccessChange() {
        ChangeRepoAccessMethod changeRepoAccessMethod = new ChangeRepoAccessMethod();
        changeRepoAccessMethod.setHeaders(String.format("Authorization=%s", "token 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"));
        changeRepoAccessMethod.callAPI();
        changeRepoAccessMethod.validateResponse();
    }

    @Test
    public void verifyRepositoryDelete() {
        DeleteRepositoryMethod deleteRepositoryMethod = new DeleteRepositoryMethod();
        deleteRepositoryMethod.setHeaders(String.format("Authorization=%s", "token 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"));
        deleteRepositoryMethod.callAPI();
        deleteRepositoryMethod.expectResponseStatus(HttpResponseStatusType.NO_CONTENT_204);
    }
}
