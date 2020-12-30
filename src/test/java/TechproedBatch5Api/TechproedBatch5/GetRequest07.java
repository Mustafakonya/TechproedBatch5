package TechproedBatch5Api.TechproedBatch5;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GetRequest07 extends TestBase{

	//Among the data there are someones whose first name is "Susan"
	//URL spec01 from TestBase
	
	@Test
	public void get01() {
	Response response = given().
			              spec(spec01).
			              get("/booking?firstname=Susan");//iyi degil
	response.prettyPrint();
	
	assertTrue(response.getBody().asString().contains("bookingid"));
	}
	
	
	
	
	
	@Test
	public void get02() {
		
		spec01.queryParam("firstname", "Susan");//iyi
	Response response = given().
			              spec(spec01).
			              get("/booking");
	response.prettyPrint();
	
	assertTrue(response.getBody().asString().contains("bookingid"));
	}
	
}
