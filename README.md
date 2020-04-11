# CheggBlogPostAPITest
This project does automated API testing of JSON Blob API [https://jsonblob.com/api](https://jsonblob.com/api)

## QA Challenge Part 2

1. Create new blog post - *Please refer to :* **testCreatePost()**
2. Validate that blog post was created (verify status code is 200 & content-type is application/json) - *Please refer to :* **testResponseCode()** and **testContentType()**
3. Update the blog post - *Please refer to :* **testDataUpdate()**
4. Validate that blog post was updated - *Please refer to :* **testDataUpdate()**
5. Delete the blog post (verify status code is 200) - *Please refer to :* **testDeletePost()**
6. Verify that the blog post was deleted (verify status code is 404) - *Please refer to :* **testResponseCodeAfterDelete()**

Test Report (with all 6 conditions PASSED):
![Test Report](Test_Result.png)