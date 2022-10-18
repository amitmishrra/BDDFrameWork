package com.qa.test.rest;

import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class PostCallBDD {
    private PostCallBDD() {
    }

    public static HashMap map = new HashMap();


    @BeforeClass
    public static void postData() {
        map.put("FirstName", "Amit");
        map.put("LastName", "Mishra");
    }

    @Test
    public static void postReq() {


      ResponseBody body=  given().
                body(map).
                when().
                post("https://reqres.in/api/users").getBody();
        System.out.println("the print vlaue"+body.prettyPrint());
    }
}
