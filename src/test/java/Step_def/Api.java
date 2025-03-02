package Step_def;

import static io.restassured.RestAssured.given;

import java.util.Map;
import java.util.Properties;
import com.factory.Base_driver;
import com.pages.ConfigManager;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Api {

	Base_driver basedriver = new Base_driver();
	Properties props = ConfigManager.getProperties();
		
	String Form_ID="";

	public String baseurl() {
		return RestAssured.baseURI = (props.getProperty("Base_Url"));
	}
	
//	public int addForm(String getUrl) {
//        Response response = given()
//                .header("Content-Type", "application/json")
//                .body( "{ \"formName\": \"" + props.getProperty("Form_FirstName") + "\", \"formDescription\": \"" + props.getProperty("Form_LastName") + "\" }") 
//                .when()
//                .post(baseurl() + "/forms/addForm")   
//                .then()
//                .extract()
//                .response();
// 
//        //int formId = response.jsonPath().getInt("formId");  
////        System.out.println("Added Form ID: " + formId);
////        return formId;
////
//
//        Map<String, Object> lastForm = getSingleForm(baseurl()+ getUrl);
//        
//        return 5;
//    }

	public void Get(String url) {
		
		Response response = 
				given()
				.when()
				.get(baseurl() + url)
				.then()
				.extract()
				.response();

		System.out.print("All response in APi :" + response.asPrettyString());
		
		System.out.printf("data statuss ", response.getStatusLine().contains("200") ? "true " : "false");

		 
	}
	
//	public static Map<String, Object> getSingleForm(String apiUrl) {
//        Response response = 
//                given()
//                .when()
//                .get(apiUrl)
//                .then()
//                .extract()
//                .response();
//
//        // Return the last object (assuming only one object in response)
//        return response.jsonPath().getMap("[-1]"); 
//    }
	

}
