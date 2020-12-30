package TechproedBatch5Api.TechproedBatch5;

import static org.hamcrest.Matchers.*;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetRequest06 extends TestBase{

	//TestBase class olusturup her testte kullanilan datalari TestBase class a koyup
	//tekrar tekrar ayni seyleri yazmaktan kurtulacagiz.
	
	/*
	 When I send a GET request to REST API URL
	    https://restful-booker.herokuapp.com/booking/5
	 Then HTTP Status Code should be 200
	 And response content type is "application/JSON"
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
		Response response = given().
				                spec(spec01).
				            when().
				                get("/booking/5");
		response.prettyPrint();
		
		response.then().
		           assertThat().
		           statusCode(200).
		           contentType(ContentType.JSON).
		           body("firstname", equalTo("Mary" ),
		                "lastname", equalTo("Jackson"),
		                "totalprice", equalTo(856),
		                "depositpaid", equalTo(false),
		                "bookingdates.checkin", equalTo("2017-09-15"),
		                "bookingdates.checkout", equalTo("2018-01-31"));
	}
	
	
	
	
	
	
	
	
	
}
