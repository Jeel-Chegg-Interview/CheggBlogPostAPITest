package putRequests;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import postRequests.CreateBlogAPI;
/**
 * This class updates the data for a given blog post
 * @author Jeel Patel
 * @version 1.0
 *
 */
public class UpdateBlogPost {
	/**
	 * Getting Updating blog post and validating that blog post is updated 
	 */
	@Test
	public void testDataUpdate() {
		String newBlogURL = CreateBlogAPI.BLOG_URL;
		// Test data to be included while updating blog post
				JSONObject requestParams = new JSONObject();
				requestParams.put("id", 2);
				requestParams.put("firstname", "billy");
				requestParams.put("lastname", "gates");
				
				//Setting up new Request specification
				RequestSpecification request = RestAssured.given();
				request.contentType("application/json");
				request.accept("application/json");
				request.header("cache-control", "no-cache");
				request.body(requestParams.toString());
				
				// Sending POST API request (with parameters) and storing response
				Response response = request
						.when()
						.put(newBlogURL)
						.then()
						.contentType("application/json")
						.extract()
						.response();
		
		//Response response = RestAssured.patch(newBlogURL, updateID);
		int responseCode = response.getStatusCode();
		Assert.assertEquals(responseCode, 200);
	
		//System.out.println("Headers: "+response.getHeaders());
		System.out.println("Response Code for UPdate operation: " + responseCode);
		System.out.println("Blob After Update : "+response.prettyPrint() );	
	}
}