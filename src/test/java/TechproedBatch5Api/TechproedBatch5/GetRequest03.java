package TechproedBatch5Api.TechproedBatch5;

import static org.junit.Assert.assertEquals;

import org.hamcrest.Matchers;
import org.junit.Test;


import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetRequest03 {

	/*
	 Positive Scenario:
	 When I send a GET request to REST API URL
	 https://restful-booker.herokuapp.com/booking/1
	 And Accept type is "application/json"
	 Then
	 HTTP Status Code should be 200
	 And Response format should be "application/JSON"
	 And first name should be "Mark"
	 And last name should be "Smith"
	 And check in date should be "2017-12-02"
	 And checkout date should be "2020-12-08"
	 */
	
	
	@Test
	public void get01() {
		Response response = given().
				                accept("application/json").
				            when().
				                get("https://restful-booker.herokuapp.com/booking/2");
		response.prettyPrint();
		
		
		//1. Yol
		response.then().
		              assertThat().
		              statusCode(200).
		              contentType("application/JSON").
		              body("firstname", Matchers.equalTo("Eric")).
		              body("lastname", Matchers.equalTo("Wilson")).
		              body("totalprice", Matchers.equalTo(743)).
		              body("depositpaid", Matchers.equalTo(true)).
		              body("bookingdates.checkin", Matchers.equalTo("2015-10-26")).
		              body("bookingdates.checkout", Matchers.equalTo("2020-07-26"));
		              

		//Tekrarli body() kullanmadan nasil yapilir?
		response.then().
		            assertThat().
		            statusCode(200).
		            contentType("application/JSON").
		            body("firstname", Matchers.equalTo("Eric"),
		            	 "lastname", Matchers.equalTo("Wilson"),
		            	 "totalprice", Matchers.equalTo(743),
		            	 "depositpaid", Matchers.equalTo(true),
		            	 "bookingdates.checkin", Matchers.equalTo("2015-10-26"),
		            	 "bookingdates.checkout", Matchers.equalTo("2020-07-26"));
		
		
		
		
			
		//2. Yol
		assertEquals(200, response.getStatusCode());
			
	}
	
}
