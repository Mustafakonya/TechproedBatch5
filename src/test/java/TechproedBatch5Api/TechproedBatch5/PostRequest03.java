package TechproedBatch5Api.TechproedBatch5;


import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class PostRequest03 extends TestBase{

	
	/*         POST Scenario:
	 * Accept Type should be Json
	 *  When I send a POST request
	 1) https://retful-booker.herokuapp.com/booking
	 2) Request Body
	 { 
	 "firstname": "Mustafa",
    "lastname": "Konya",
    "totalprice": 884,
    "depositpaid": false,
    "bookingdates": {
            "checkin": "2015-09-03",
            "checkout": "2016-08-17"
    },
    "additionalneeds": "Wifi"
	 }
	 Then
	 Status Code should be 200
	 And response body should match with the request body. 
	 */
	
	
	
	
	
	
	@Test
	public void post01() {
		
		Response response = createRequestBodyByMap();
		response.prettyPrint();
		
		
		
		        //JsonPath kullanarak assertion
				JsonPath json = response.jsonPath();
				SoftAssert softAssert = new SoftAssert();
				
				//firstname assertion
				softAssert.assertEquals(json.getString("booking.firstname"), "Mustafa");
				
				//lastname assertion
				softAssert.assertEquals(json.getString("booking.lastname"), "Konya");

				//totalprice assertion
				softAssert.assertEquals(json.getInt("booking.totalprice"), 884);
					
					
				//depositpaid assertion
				softAssert.assertEquals(json.getBoolean("booking.depositpaid"), false);
					
				//checkin assertion
				softAssert.assertEquals(json.getString("booking.bookingdates.checkin"), "2015-09-03");
							
					
				//checkout assertion
				softAssert.assertEquals(json.getString("booking.bookingdates.checkout"), "2016-08-17");	
					
					
				//additionalneeds assertion
					softAssert.assertEquals(json.getString("booking.additionalneeds"), "Wifi");	
					
					
				softAssert.assertAll();
	}
	
	
	
	
	
	
	
	
	
}
