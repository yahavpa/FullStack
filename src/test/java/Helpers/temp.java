package Helpers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class temp
{
    String url = "http://localhost:3000/";
    RequestSpecification httpRequest;
    Response response;

    @Test
    public void testing()
    {
        JSONObject params = new JSONObject();
        params.put("title", "ATeam");
        params.put("author", "Yahav");

        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");

        httpRequest.body(params.toJSONString());
        response = httpRequest.post("/posts");
        response.prettyPrint();

        params.put("title", "ATeam1");
        params.put("author", "Yahav1");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put("/posts/1");
        response.prettyPrint();

        response = httpRequest.delete("/posts/1");
    }
}
