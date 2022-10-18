package com.qa.test.rest;

import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DeleteCall {
    private DeleteCall() {
    }

    @Test
    public static void delete() {
        ResponseBody response = given().
                when().
                delete("https://gorest.co.in/public/v2/users/4114").
                then()
                .extract().
                response().
                prettyPeek();

        String res = response.asString();

//        Assert.assertEquals(res.contains("Authentication failed"), true);
    }

}
