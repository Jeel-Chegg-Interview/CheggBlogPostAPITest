package postRequests;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * This class does various API validations for jsonblob.com
 * @author Jeel Patel
 * @version 1.0
 *
 */
public class CreateBlogAPI {

	// URL received after POST request - to be used for various other requests
	public static String BLOG_URL;

	/**
	 * Setting up the baseURI i.e. core API testing URL (for application under test)
	 */
	@BeforeSuite
	public void setUp(){
		RestAssured.baseURI = "https://jsonblob.com/api/jsonBlob";
	}

	/**
	 * Generating blog post via POST API request
	 */
	@Test
	public void testCreatePost() {
		// Test data to be included while creating blog post
		JSONObject requestParams = new JSONObject();
		requestParams.put("id", 1);
		requestParams.put("firstname", "bill");
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
				.post(RestAssured.baseURI)
				.then()
				.contentType("application/json")
				.extract()
				.response();

		// Checking if blog post got created successfully
		Assert.assertEquals(response.getStatusCode(), 201);
		
		// Getting the location of unique URL where the blog got created
		BLOG_URL = response.header("location");
		System.out.println("Response URL: " + response.header("location"));
		System.out.println("Before Update: "+response.prettyPrint());
	}	
}