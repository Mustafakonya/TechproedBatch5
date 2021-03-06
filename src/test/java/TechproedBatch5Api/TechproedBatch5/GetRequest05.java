package TechproedBatch5Api.TechproedBatch5;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class GetRequest05 {

	/*
	 When I send a GET request to REST API URL
	    https://restful-booker.herokuapp.com/booking/5
	 Then HTTP Status Code should be 200
	 And response content type is "application/JSON"
	 And firstname should be Jim
	 And totalprice should be 602
	 And checkin should be ""
	 */
	
	
	@Test
	public void get01() {
		
		Response response = given().
				            when().
				              get("https://restful-booker.herokuapp.com/booking/1");
		
		response.prettyPrint();
		
		response.
		then().
		    assertThat().
		    statusCode(200).
		    contentType(ContentType.JSON).
		    body("firstname", Matchers.equalTo("Mary"),
		    	 "totalprice", Matchers.equalTo(892),
		    	 "bookingdates.checkin", Matchers.equalTo("2018-08-16"));
		
	}
	
	
	
	
	
}
