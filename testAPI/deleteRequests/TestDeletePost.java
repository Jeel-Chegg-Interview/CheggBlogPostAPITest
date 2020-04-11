package deleteRequests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import postRequests.CreateBlogAPI;
/**
 * This class conducts the actual delete operation for a given blog post
 * @author Jeel Patel
 * @version 1.0
 *
 */
public class TestDeletePost {
	/**
	 * Getting the URL of blog post and then deleting it and checking if delete operation was completed
	 */
	@Test
	public void testDeletePost() {
		String newBlogURL = CreateBlogAPI.BLOG_URL;

		// Sending POST API request (with parameters) and storing response
		Response response = given().when().delete(newBlogURL);

		// Response response = RestAssured.patch(newBlogURL, updateID);
		int responseCode = response.getStatusCode();
		Assert.assertEquals(responseCode, 200);

		// System.out.println("Headers: "+response.getHeaders());
		System.out.println("Response Code for Delete operation: " + responseCode);
		System.out.println("Blob After Delete : " + response.prettyPrint());
	}
}