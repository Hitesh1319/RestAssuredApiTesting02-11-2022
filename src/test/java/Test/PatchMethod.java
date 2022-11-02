package Test;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PatchMethod {
    @Test
    public void testPatchMethod() {
        JSONObject request = new JSONObject();
        request.put("name", "Random");
        System.out.println(request.toJSONString());
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/users").
                then().
                statusCode(201).log().all();
    }
}
