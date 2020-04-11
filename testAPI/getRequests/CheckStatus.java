package getRequests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import postRequests.CreateBlogAPI;
/**
 * This class does the basic API response check (via GET) to validate new blog post
 * @author Jeel Patel
 * @version 1.0
 *
 */
public class CheckStatus {
	/**
	 * Getting response code for GET request against newly created blog post
	 */
	@Test
	public void testResponseCode() {
		String newBlogURL = CreateBlogAPI.BLOG_URL;
		Response response = RestAssured.get(newBlogURL);
		int responseCode = response.getStatusCode();
		Assert.assertEquals(responseCode, 200);
		System.out.println("Response Code: " + responseCode);
	}

	/**
	 * Checking the content type of the response for the GET request
	 */
	@Test
	public void testContentType() {
		String newBlogURL = CreateBlogAPI.BLOG_URL;
		Response response = RestAssured.get(newBlogURL);
		String contentType = response.contentType();
		Assert.assertTrue(contentType.contains("application/json"));
		// Assert.assertEquals(contentType, "application/json");
		System.out.println("Content Type: " + contentType);
	}
}
