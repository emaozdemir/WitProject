package petstore;

import base_url.PetStoreBaseUrl;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static petstore.C03_CreatePetPojo.petId;

public class C07_GetPetByIdNegative extends PetStoreBaseUrl {
    /*
    Given
        https://petstore.swagger.io/v2/pet/:id

    When
        User sends GET request

    Then
        Status code should be 404

    And
        Response body should be like:
        {
            "code": 1,
            "type": "error",
            "message": "Pet not found"
        }

     */

    @Test
    void getPetTest(){
        //Set the url
        spec.pathParams("first", "pet","second", petId);

        //Set the expected data

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        response
                .then()
                .statusCode(404)
                .body("message", equalTo("Pet not found"));

    }
}