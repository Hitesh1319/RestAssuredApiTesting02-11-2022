package Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static io.restassured.RestAssured.*;

public class GetMethod {
    @Test
    void test_GetMethod() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.prettyPrint());
        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
        System.out.println(response.getBody());
        System.out.println(response.getBody().asString());
        System.out.println(response.getTime());
        System.out.println(response.getHeader("Content-text"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }
    @Test
    void test_GetMethod01() {
        given().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("data.id[3]",equalTo(10)).body("data.first_name", hasItems("Byron"));
    }
}
