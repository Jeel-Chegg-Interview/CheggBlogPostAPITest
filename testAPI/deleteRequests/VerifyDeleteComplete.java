package deleteRequests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import postRequests.CreateBlogAPI;
/**
 * This class double verifies if the Delete operation was successfully completed
 * @author Jeel Patel
 * @version 1.0
 *
 */
public class VerifyDeleteComplete {
	/**
	 * Getting response code for GET request against deleted blog post to second check delete completed
	 */
	@Test
	public void testResponseCodeAfterDelete() {
		String newBlogURL = CreateBlogAPI.BLOG_URL;
		Response response = RestAssured.get(newBlogURL);
		int responseCode = response.getStatusCode();
		Assert.assertEquals(responseCode, 404);
		System.out.println("Response Code after Delete: " + responseCode);
	}
}