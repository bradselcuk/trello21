package hotelReservation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBookingID {

    @Test
    public void test(){
        given().get("https://restful-booker.herokuapp.com/booking/1").prettyPeek().
                then().
                statusCode(200);
    }
}
