package TechproedBatch5Api.TechproedBatch5;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class PostRequest01 extends TestBase{

	
	/*
	 * Post Request olusturmak icin gerekenler :
	 * 1) Edpoint verilmeli
	 * 2) Request body verilmeli
	 * 3) Authorization verilmeli
	 * 4) Accept Type istege bagli
	 * 5) Content Type istege bagli
	 * 
	 *  
	 *  GET ve POST Request farklari:
	 *  1) GET Request olusturmak icin sadece EndPoint yeterlidir, ama POST Request 
	 *  olusturmak icin Endpoint yaninda Request body de gerekir.
	 *  2) GET data cekmek icin, POST yeni data olusturmak icin kullanilir. 
	 *  
	 *  NOTE: API Developer lar olusturulacak data nin bazi bolumlerinin bos birakilmasina karar vermislerse
	 *        POST Request olustururken kesinlikle o kismlara deger verilerek POST Request olusturulmalidir. Eger buna 
	 *        dikkat etmezseniz '400 Bad request' status alirsiniz 
	 *  
	 *  NOTE: API Developer lar olusturulacak data nin bazi bolunlerinin tekrarli olmamasina karar vermislerse 
	 *        POST Request olustururken o kisimlara tekrarli degerler verilerek POST Request olusturulmamalidir.
	 *        Eger buna dikkat etmezseniz '400 Bad Request' status code alirsiniz.
	 *  
	 *       POST Scenario:
	 * Accept Type should be Json
	 *  When I send a POST request
	 1) https://retful-booker.herokuapp.com/booking
	 2) Request Body
	 { 
	 "firstname": "Mark",
    "lastname": "Wilson",
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

	
	// 1. Way: Iyi degil.
	
	@Test
	public void PostRequest01() {
			String jsonReqBody = "{ \n" + 
					"	 \"firstname\": \"Mustafa\",\n" + 
					"    \"lastname\": \"Konya\",\n" + 
					"    \"totalprice\": 884,\n" + 
					"    \"depositpaid\": false,\n" + 
					"    \"bookingdates\": {\n" + 
					"            \"checkin\": \"2015-09-03\",\n" + 
					"            \"checkout\": \"2016-08-17\"\n" + 
					"    },\n" + 
					"    \"additionalneeds\": \"Wifi\"\n" + 
					"	 }";
	Response response = given().
			               contentType(ContentType.JSON).//content Type: Icerik tipi. Database e yolladigim datanin icerigi JSON
			               spec(spec01).
			               auth().
			               basic("admin", "password123").
			               body(jsonReqBody).
			            when().
			               post("booking");
	response.prettyPrint();
	
	
	
	
	//Status Code 200 olmali.
	response.
	       then().
	       assertThat().
	       statusCode(200);
	
	//JsonPath kullanarak assewrtion
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
