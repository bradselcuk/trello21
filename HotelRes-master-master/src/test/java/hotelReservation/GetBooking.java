package hotelReservation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBooking {
    @Test
    public void test(){
        given().get("https://restful-booker.herokuapp.com/booking").prettyPeek().
                then().
                statusCode(200);

    }
}
