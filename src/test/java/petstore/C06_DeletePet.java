package petstore;

import base_url.PetStoreBaseUrl;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;
import static petstore.C03_CreatePetPojo.petId;

public class C06_DeletePet extends PetStoreBaseUrl {
    /*
    Given
        https://petstore.swagger.io/v2/pet/:id
    When
        User sends DELETE request
    Then
        Status code should be 200
    And
        Response body should be:
                {
                  "code": 200,
                  "type": "unknown",
                  "message": "123"
                }
     */

    @Test
    void deletePetTest() {
        //Set the url
        spec.pathParams("first", "pet", "second", petId);

        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        response.then().statusCode(200).body("message", equalTo(petId+""));

    }
}