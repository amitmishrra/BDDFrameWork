package com.qa.test.rest;

import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PutCallBDD {
    private PutCallBDD(){}

    public static HashMap map = new HashMap<>();

    public void putData(){
        map.put("data.email" , "andibandisandi@gmail.com");
        map.put("data.first_name", "Sankata");
        map.put("last_name", "Mishra");
    }

    @Test

    public static void putReq(){
     String abc =    given().
                contentType("application/JSON").header("username","admin").body(map).
                when().
                put("https://reqres.in/api/users/2").
                then().
                statusCode(200).log().all().toString();
        System.out.println("result : -" +  abc);
    }


}
