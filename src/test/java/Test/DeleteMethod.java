package Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

public class DeleteMethod {
    @Test
    public void testDeleteMethod() {
        baseURI = "https://regres.in";
         when().delete("/api/users/2").then().statusCode(204);
    }
}