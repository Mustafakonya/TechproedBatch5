package TechproedBatch5Api.TechproedBatch5;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class GetRequest11 extends TestBase{
	
	/*
	 * GSON: 1) Json formatindaki data lari Java Objectlerine donusturur. (De-Serialization)
	 *       2) Java Object lerini Json formatindaki data lara donusturur. (Serialization)
	 *Note: GSON ile ayni isi yapan ObjectMapper Class da var.       
	 * */
	
	@Test
	public void get01() {
		Response response = given().
				               spec(spec03).
				            when().
				               get("/2");
		response.prettyPrint();
		
		HashMap<String, String> map = response.as(HashMap.class);
		System.out.println(map);
		
		System.out.println(map.keySet());
		
		System.out.println(map.values());
		
		//completed key degerinin false oldugunu verify ediniz
		SoftAssert softAssert = new SoftAssert();
		
		softAssert.assertEquals(map.get("completed"), false, "false olmaliydi ama degil");
		
		//userId, id, title degerlerini verify ediniz
		softAssert.assertEquals(map.get("id"), 2.0);
		softAssert.assertEquals(map.get("title"), "quis ut nam facilis et officia qui");
		softAssert.assertEquals(map.get("userId"), 1.0);
		
		
		
		
		
		
		
		
		
		
		
		
		
		softAssert.assertAll();
	}
	
	
	
	
	
	
	
	
	
	

}
