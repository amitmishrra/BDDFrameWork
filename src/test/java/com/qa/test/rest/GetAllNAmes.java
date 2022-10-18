package com.qa.test.rest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAllNAmes {

    private GetAllNAmes(){}
@Test(priority = 1)
    public static void getNames(){
     ResponseBody res =  given().
                when().
                get("https://gorest.co.in/public/v2/users");

        JsonPath j = new JsonPath(res.asString());

        List result = j.getList("name");
        System.out.println(result);

        String [] s = {"Chidaakaash Prajapat", "Chandrabhan Rana", "Dayamayee Varrier", "Bhagirathi Mukhopadhyay DVM",
                "Mandakini Bhattacharya", "Mukul Jha CPA", "Subhash Pothuvaal", "Bishnu Kapoor", "Rep. Swapnil Varman", "Amaranaath Pothuvaal Ret."};

        for(int i = 0 ; i< result.size(); i++){
            Assert.assertEquals(result.get(i), s[i]);

            if(result.get(i).equals(s[i])){
                System.out.println("Test passed for : " +s[i]);
            }

        }

    }

}
