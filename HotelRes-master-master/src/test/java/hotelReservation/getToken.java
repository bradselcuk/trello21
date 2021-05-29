package hotelReservation;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class getToken {

    @Test
    public void test() {

        JSONObject request = new JSONObject();
        request.put("username", "admin");
        request.put("password", "password123");

           System.out.println(request.toString());

        given().contentType(ContentType.JSON).
                body(request.toString()).
                when().
                post("https://restful-booker.herokuapp.com/auth").prettyPeek().
                then().statusCode(200);

    }
}
