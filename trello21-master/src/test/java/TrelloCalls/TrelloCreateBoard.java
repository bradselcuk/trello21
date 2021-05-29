package TrelloCalls;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class TrelloCreateBoard {

    @Test
    public void createBoard(){

        String boardName = "Call";
        String key = "5f826243a6d6c4e753b4b5ce5ea36cb4";
        String token = "3ead62cc471d23bd5e074c3c58f9d1ea5fc2a5f348d9dbd5fa0da1eb8a7089e9";

        JSONObject requestParams = new JSONObject();
        requestParams.put("key",key);
        requestParams.put("token",token);
        requestParams.put("name",boardName);

        given()
                .body(requestParams.toJSONString())
                .log().params()
                .contentType(ContentType.JSON)
                .when()
                .post("https://api.trello.com/1/boards/").prettyPeek()
                .then().statusCode(200);


    }
}
