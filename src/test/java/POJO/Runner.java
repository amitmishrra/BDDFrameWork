package POJO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class Runner  {


   @Test
    public static void Run() throws JsonProcessingException {
       SimplePojo pojo = new SimplePojo("value1","value2");


     SimplePojo deserializedPojo =    given().
                body(pojo).
        when().
                post("https://02aa69f4-a2a8-4efe-8db0-b258a93f6d36.mock.pstmn.io/post").
         then().
                extract().
                response().
                as(SimplePojo.class);

       ObjectMapper objectMapper = new ObjectMapper() ;

       String deserializedPojoString = objectMapper.writeValueAsString(deserializedPojo);
       String serializedPojoString = objectMapper.writeValueAsString(pojo);

       System.out.println( "response value :  "+
               objectMapper.readTree(deserializedPojoString)
       );

       System.out.println("request value : " +  objectMapper.readTree(serializedPojoString));

       System.out.println(deserializedPojo.getKey1());

    }
}