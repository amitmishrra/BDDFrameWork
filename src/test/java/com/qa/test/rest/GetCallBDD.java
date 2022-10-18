package com.qa.test.rest;






//import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import javax.xml.transform.Result;
import java.io.InputStream;
import java.util.List;

import  static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetCallBDD {
    @Test
    public void test_noOfCircuits(){
        //base URI with Rest Assured class
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/";

        Response res = given()
                .when()
                .get("Books");

        //convert JSON to string
        JsonPath j = new JsonPath(res.asString());

        //get values of JSON array after getting array size
        int s = j.getInt("books.size()");
        for(int i = 0; i < s; i++) {
            String isbn = j.getString("books["+i+"].isbn");
            System.out.println(isbn);
    }
}}
