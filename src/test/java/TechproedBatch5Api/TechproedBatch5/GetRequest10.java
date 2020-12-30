package TechproedBatch5Api.TechproedBatch5;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GetRequest10 extends TestBase{

	/*
	 When I send a GET request to REST API URL
	 https://dummy.restapiexample.com/api/v1/employees
	 Then
	 Status Code should be 200
	 1) Print all ids greater than 10 on the console
	    Assert that there are 14 ids greater than 10
	 2) Print all ages less than 30 on the console
	    Assert that maximum age is 23
	 3) Print all employee names whose salaries are greater than 350000
	    Assert that Charde Marshall is one of the employees whose salary is greater than 350000   
	 */
	
	
	
	@Test
	public void get01() {
		Response response = given().
				               spec(spec02).
				            when().
				               get();
		response.prettyPrint();
		
		response.
		      then().
		      assertThat()
		      .statusCode(200);
		
		JsonPath json = response.jsonPath();
		SoftAssert softAssert = new SoftAssert();
		
	//10 dan buyuk tum id leri console a yazdir.
		List<String> idList = json.getList("data.findAll{Integer.valueOf(it.id)>10}.id");
		System.out.println(idList);
		
	//verify
		softAssert.assertEquals(idList.size(), 14, "Eleman sayisi istenen gibi degil");
		
	
	//30 dan kucuk tum yaslari console a yazdir
		List<String> ageList = json.getList("data.findAll{Integer.valueOf(it.employee_age)<30}.employee_age");
		System.out.println(ageList);
		
		
	// Assert that maximum age is 23
		Collections.sort(ageList);
		softAssert.assertTrue(ageList.get(ageList.size()-1).equals("23"), "Yas istenen gibi degil");
		
		
	//Print all employee names whose salaries are greater than 350000
		List<String> nameList = json.getList("data.findAll{Integer.valueOf(it.employee_salary)>350000}.employee_name");
		System.out.println(nameList);
		
		
	//Assert that Charde Marshall is one of the employees whose salary is greater than 350000	
		softAssert.assertTrue(nameList.contains("Charde Marshall"));
		
		
		
		softAssert.assertAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
