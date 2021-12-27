package com.solvd.apitesting;

import org.testng.annotations.Test;

public class APITest {

    @Test
    public void verifyUser(){
        GetUserMethod getUserMethod = new GetUserMethod();
        getUserMethod.setHeaders(String.format("Authorization=%s", "token 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"));
        getUserMethod.callAPI();
        getUserMethod.validateResponse();
    }
}
