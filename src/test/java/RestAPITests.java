import dataObjects.Photo;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.junit.Assert.assertEquals;

public class RestAPITests {

    @Test
    public void simpleVerificationsDemo() {
        given().relaxedHTTPSValidation()
        .when().get("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&camera=fhaz&api_key=DEMO_KEY")
        //.when().get("https://images-api.nasa.gov/asset/as11-40-5874")
        //.when().get("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY")
        .then().statusCode(200)
        .and().body(containsString("photos"))
        .and().assertThat().body(matchesJsonSchemaInClasspath("mars_photos_response_schema.json"));
    }

    @Test
    public void parsingBodyDemo() {
        Integer expectedNumberOfPhotos = 2;
        Integer numberOfPhotos =
                given().relaxedHTTPSValidation()
                .when().get("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&camera=fhaz&api_key=DEMO_KEY")
                .getBody().jsonPath().getList("photos", Photo.class).size();

        assertEquals(numberOfPhotos, expectedNumberOfPhotos);
    }
}
