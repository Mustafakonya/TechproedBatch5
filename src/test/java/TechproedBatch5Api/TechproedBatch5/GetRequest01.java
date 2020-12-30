package TechproedBatch5Api.TechproedBatch5;

import org.junit.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetRequest01 {
//Rest Assure3d kullanarak API Testing yapacagiz
	@Test
	public void getMethod01() {
		
		given().
		when().
		   get("https://restful-booker.herokuapp.com/booking").
		then().
		   assertThat().
		   statusCode(200);
	}
	
	
	@Test
	public void getMethod() {
		
		Response response = given().
		                    when().
		                    get("https://restful-booker.herokuapp.com/booking/3");
		//Response body'i konsola yazdirmak icin response.prettyPrint(); kullanilir.
		response.prettyPrint();
		
		//statuscode'u console'da gormek icin response.getStatusCode(); kullanilir.
		System.out.println("Status Code " + response.getStatusCode());
		
		//statusline'i console'da gormek icin;
		System.out.println("Status Line " + response.getStatusLine());
		
		//Response body deki datanin content(icerik) type i 
		System.out.println("Content Type " + response.getContentType());
		
		//Headers daki bilgileri almak
		System.out.println(response.getHeaders());
		
		//Headers dan istenen specific bir data yi almak  
		System.out.println(response.getHeader("Date"));
		
		
		//Assertion yapalim
		//1) Status code 200
		//assertThat() kullanirsaniz "Hard Assertion" yapiyorsunuz demektir.
		//Yani; ilk hatada cede execution durur ve hata raporu verilir.
		//Ilk hatadan sonraki kodlar calistirilmaz.
		response.
		then().
		assertThat().
		statusCode(200).
		statusLine("HTTP/1.1 200 OK").
		contentType("application/json; charset=utf-8");
		
		
		
		
		
	}
}
