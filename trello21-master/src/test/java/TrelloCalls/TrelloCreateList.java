package TrelloCalls;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TrelloCreateList {

    @Test
    public void createList(){


        String key = "5f826243a6d6c4e753b4b5ce5ea36cb4";
        String token = "3ead62cc471d23bd5e074c3c58f9d1ea5fc2a5f348d9dbd5fa0da1eb8a7089e9";
        String idList = "60b1c3e2964d1534ba75a614";
        String name = "Card for Update";

        JSONObject requestParams = new JSONObject();
        requestParams.put("key",key);
        requestParams.put("token",token);
        requestParams.put("idList",idList);
        requestParams.put("name",name);

        given()
               .body(requestParams.toJSONString())
               .log().params()
               .contentType(ContentType.JSON)
               .when()
               .post("https://api.trello.com/1/cards")
               .then().statusCode(200);
    }
}
