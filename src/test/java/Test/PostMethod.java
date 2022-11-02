package Test;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured.*;

import static io.restassured.RestAssured.given;

public class PostMethod {
    String baseURI = "https://reqres.in/api";
    @Test
    public void TestPostMethod() {
        JSONObject request = new JSONObject();
        request.put("name", "Random");
        request.put("job", "QA");
        System.out.println(request.toJSONString());
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).log().all();
    }
}