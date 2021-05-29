package hotelReservation;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class deleteBooking {

   @Test
   public void test(){
       JSONObject request = new JSONObject();
       request.put("username", "admin");
       request.put("password", "password123");

       System.out.println(request.toString());

       String token = given().contentType(ContentType.JSON).
               body(request.toString()).
               when().
               post("https://restful-booker.herokuapp.com/auth").prettyPeek().jsonPath().getString("token");

       given().pathParam("id",1)
               .header("Content-Type","application/json" )
               .cookie("token", token)
               .when().log().all().
               delete("https://restful-booker.herokuapp.com/booking/{id}").prettyPeek().
               then().statusCode(201);
   }
}
