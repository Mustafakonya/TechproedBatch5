package TechproedBatch5Api.TechproedBatch5;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Before;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {

	
	protected RequestSpecification spec01;
	protected RequestSpecification spec02;
	protected RequestSpecification spec03;

	@Before
	public void setUp01() {
		spec01 = new RequestSpecBuilder().
				setBaseUri("https://restful-booker.herokuapp.com").
				build();
	}	
	
	 @Before
	    public void setUp02(){
	        spec02 = new  RequestSpecBuilder().
	                setBaseUri("http://dummy.restapiexample.com/api/v1/employees").
	                build();
	}
		
	
	 @Before
	    public void setUp03(){
	        spec03 = new  RequestSpecBuilder().
	                setBaseUri("http://jsonplaceholder.typicode.com/todos").
	                build();
	}
	 
	 protected Response createRequestBodyByJsonObjectClass() {
	 
	 JSONObject jsonBookingDatesRequestBody = new JSONObject();
		jsonBookingDatesRequestBody.put("checkin", "2015-09-03");
		jsonBookingDatesRequestBody.put("checkout", "2016-08-17");
		
		
		JSONObject jsonRequestBody = new JSONObject();
		jsonRequestBody.put("firstname", "Mustafa");
		jsonRequestBody.put("lastname", "Konya");
		jsonRequestBody.put("totalprice", "884");
		jsonRequestBody.put("depositpaid", "true");
		jsonRequestBody.put("bookingdates", jsonBookingDatesRequestBody);
		jsonRequestBody.put("additionalneeds", "Wifi");

		Response response = given().
				               contentType(ContentType.JSON).
				               spec(spec01).
				               auth().
				               basic("admin", "password123").
				               body(jsonRequestBody.toString()).
				            when().
				               post("/booking");
	 return response;
	 }

	 
	 
	 protected Response createRequestBodyByMap() {
		 
		 Map bookingDatesMap = new HashMap<>();
			bookingDatesMap.put("checkin", "2020-05-02");
			bookingDatesMap.put("checkin", "2020-05-05");
			
			Map<String, Object> requestBodyMap = new HashMap<>();
			requestBodyMap.put("firstname", "Mustafa");
			requestBodyMap.put("lastname", "Konya");
			requestBodyMap.put("totalprice", 884);
			requestBodyMap.put("depositpaid", false);
			requestBodyMap.put("bookingdates", "bookingDatesMap");
			requestBodyMap.put("additionalneeds", "Wifi");

			Response response = given().
		                           contentType(ContentType.JSON).
		                           spec(spec01).
		                           auth().
		                           basic("admin", "password123").
		                           body(requestBodyMap.toString()).
		                        when().
		                           post("/booking");
			return response;
		 
	 }
	
}
