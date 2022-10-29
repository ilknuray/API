import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class Get03 extends JsonPlaceHolderBaseUrl{

    @Test
    public void get01(){
        /*
        given url
        when
            user send get request to the url
        Then
            http status code should to be 200
        And
           response format should be "application/json"
        And
           "title" is "et itaque nessesitation  maxime molestiae qui quas velit"
        And
            "completed" is   false
        And
            "userId" is 2
         */

        //set the url

        spec.pathParams("first","todos","second",23);
        //set the request
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();



        //do assertion
        //1.yol (hard assert)
        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed",equalTo(false)).
                body("userId",equalTo(2));

        // 2. Yol Sadece body içerisinde geçerli bir (Soft Assert)

        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed",equalTo(false),"userId",equalTo(2));




    }
}
