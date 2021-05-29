package hotelReservation;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class updateBooking {


    @Test
    public void test(){

        String jsonObject = "{\n" +
                "    \"firstname\" : \"Max\",\n" +
                "    \"lastname\" : \"Goran\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        JSONObject request = new JSONObject();
        request.put("username", "admin");
        request.put("password", "password123");

        System.out.println(request.toString());

        String token = given().contentType(ContentType.JSON).
                body(request.toString()).
                when().
                post("https://restful-booker.herokuapp.com/auth").prettyPeek().jsonPath().getString("token");

        given().
                pathParam("id",1)
                .header("Content-Type","application/json" )
                .header("Accept","application/json" )
                .cookie("token", token)
                .body(jsonObject)
                .when().log().all().
                put("https://restful-booker.herokuapp.com/booking/{id}").prettyPeek().
                then().statusCode(200);

    }
}
