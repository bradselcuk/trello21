package hotelReservation;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateBooking {

    @Test
    public void test(){

        String jsonObject = "{\n" +
                "    \"firstname\" : \"Don\",\n" +
                "    \"lastname\" : \"Watson\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        given().contentType(ContentType.JSON).
                body(jsonObject).
                when().
                post("https://restful-booker.herokuapp.com/booking").prettyPeek().
                then().statusCode(200);

    }
}
