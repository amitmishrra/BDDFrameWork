package POJO;

import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class NestedJSON {

    public static String getResponseString(ResponseBody response, String path){
        JsonPath j = new JsonPath(response.asString());
        String result = j.getString(path);
        return  result;
    }

    public static int getResponseInt(ResponseBody response, String path){
        JsonPath j = new JsonPath(response.asString());
        int result = j.getInt(path);
        return  result;
    }

    public static List getResponseList(ResponseBody response, String path){
        JsonPath j = new JsonPath(response.asString());
        List result = j.getList(path);


        return  result;
    }

    @Test
    public static void json(){

        HashMap <String, String> pass = new HashMap<>();
        pass.put("password", "amit");

      ResponseBody res = given().
                body(pass).
        when().
                post("https://02aa69f4-a2a8-4efe-8db0-b258a93f6d36.mock.pstmn.io/post");

       int id =  getResponseInt(res, "[0].ppu");
       System.out.println("id : " + id);

        List batters = getResponseList(res, "[0].batters.batter.type");
        System.out.println("batters : " + batters);

        String topping = getResponseString(res, "[2].topping[3].type");
        System.out.println("topping : " + topping);
    }
}

