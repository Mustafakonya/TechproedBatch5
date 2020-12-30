package TechproedBatch5Api.TechproedBatch5;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetRequest08 extends TestBase{
	
	/*
	 Positive Scenario:
	 When I send a GET request to REST API URL
	 https://restful-booker.herokuapp.com/booking/5
	 HTTP Status Code should be 200
	 And Response format should be "application/JSON"
	 And response body should be like;
	 { 
	 "firstname": "Mark",
    "lastname": "Wilson",
    "totalprice": 884,
    "depositpaid": false,
    "bookingdates": {
            "checkin": "2015-09-03",
            "checkout": "2016-08-17"
    }
	 }
	 */
	
	
	@Test
	public void get01() {
		
		spec01.pathParam("bookingid", 5);
		
		Response response = given().
				               spec(spec01).
				            when().
				               get("/booking/5");
		response.prettyPrint();
		
		//JSON formatindaki datalarin icinde gezmenizi kolaylastirir
		JsonPath jsonpath = response.jsonPath();
		
		System.out.println(jsonpath.getString("firstname"));
		assertEquals("First name is not as expected","Eric",jsonpath.getString("firstname"));
		
		
		System.out.println(jsonpath.getString("lastname"));
		assertEquals("Last name is not as expected", "Ericsson",jsonpath.getString("lastname"));
		
		System.out.println(jsonpath.getInt("totalprice"));
		assertEquals("Total price is not as expected", 205, jsonpath.getInt("totalprice"));
		
		System.out.println(jsonpath.getBoolean("depositpaid"));
		assertEquals("Deposit paid is not as expected", false, jsonpath.getBoolean("depositpaid"));
		
		System.out.println(jsonpath.getString("bookingdates.checkin"));
		assertEquals("Booking dates checkin is not as expected", "2016-10-12", jsonpath.getString("bookingdates.checkin"));
		
		System.out.println(jsonpath.getString("bookingdates.checkout"));
		assertEquals("Booking dates checkout is not as expected", "2020-10-01", jsonpath.getString("booking.checkout"));
		
	}
	
	

}
