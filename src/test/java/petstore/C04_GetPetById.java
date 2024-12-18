package petstore;

import base_url.PetStoreBaseUrl;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static petstore.C03_CreatePetPojo.expectedData;
import static petstore.C03_CreatePetPojo.petId;

public class C04_GetPetById extends PetStoreBaseUrl {
    /*
    Given
        https://petstore.swagger.io/v2/pet/56793

    When
        User sends GET request

    Then
        Status code should be 200

    And
        Response body should be like:

        {
          "id": 18,
          "category": {
            "id": 0,
            "name": "Kedi"
          },
          "name": "Pamuk",
          "photoUrls": [
            "url1",
            "url2",
            "url3"
          ],
          "tags": [
            {
              "id": 0,
              "name": "Beyaz"
            },
            {
              "id": 1,
              "name": "Yavru"
            },
            {
              "id": 2,
              "name": "Sevimli"
            }
          ],
          "status": "available"
        }

     */

    @Test
    void getPetTest(){
        //Set the url
        spec.pathParams("first", "pet","second", petId);

        //Set the expected data
        //Bir önceki class'ta oluşturulan aynı data oldugu icin ve hemen bundan once calisaca[i icin tekrar yapmadik
        //asssertiona expectedData direkt geldi import ettik

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        PetPojo actualData = ObjectMapperUtils.convertJsonStrToJava(response.asString(), PetPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getId(), expectedData.getId());
        assertEquals(actualData.getCategory().getName(), expectedData.getCategory().getName());
        assertEquals(actualData.getName(), expectedData.getName());
        assertEquals(actualData.getPhotoUrls().get(0), expectedData.getPhotoUrls().get(0));
        assertEquals(actualData.getPhotoUrls().get(1), expectedData.getPhotoUrls().get(1));
        assertEquals(actualData.getPhotoUrls().get(2), expectedData.getPhotoUrls().get(2));
        assertEquals(actualData.getTags().get(0).getName(), expectedData.getTags().get(0).getName());
        assertEquals(actualData.getTags().get(1).getName(), expectedData.getTags().get(1).getName());
        assertEquals(actualData.getTags().get(2).getName(), expectedData.getTags().get(2).getName());
        assertEquals(actualData.getStatus(), expectedData.getStatus());

    }
}