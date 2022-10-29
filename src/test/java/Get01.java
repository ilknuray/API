import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {

    /*
    1)Postman,manuel api testleri icin kullanilir.
    2)Otomasyon testleri icin de Rest Assured Library kullanilacak
    3)Otomasyon testlerimizi yaparken asagidaki adimlari izliyoruz:
     -Gereksinimleri anlamak,
     -Testcase olusturmak,
        *Testcase yaziminda "Gherkin" dilini kullanacagiz.Bizler yazilim diline hakim olsakta karsimizdaki kisiler hakim olmayabilir
        ama Gherkin ile yazilan testleri anlamakta zorluk cekmeyeceklerdir.

        Gherkin dilinde kullanacagimiz keywordler;
        -Given : On kosullar
        -When  : Yapilacak aksiyonlar icin (get,put,post,patch ve delete)
        -Then  : Istek yaptiktan (request gonderdikten sonra) dogrulama
        -And   :   Coklu islemlerde kullanacagiz

      - Test code larimizi yazmaya baslayacagiz
        *Set the URL,
        *Set the expected data (beklenen datanin olusturulmasi,Post,Put,Patch)
        *Type code to send request (talep gondermek icin code yazimi)
        *Do Assertion (dogrulama yapmak)

     */
    /*
Given
        https://restful-booker.herokuapp.com/booking/101
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
 */
    @Test
    public void get01() {
        //1)Set the url
        String url = " https://restful-booker.herokuapp.com/booking/101";

        //2)Set the expected data (beklenen datanin olusturulmasi,Post,Put,Patch)->bizden post put yada patch istenmedigi icin bu casede kullanmayacagiz.

        //3)Type code to send request (talep gondermek icin code yazimi)
        Response response = given().when().get(url);
        response.prettyPrint();

        //4) Do Assertion (dogrulama yapmak)
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");
        //status codu konsolda yazdiralim
        System.out.println("Status code : " +response.getStatusCode());

        //content type i konsolda yazdiralim
        System.out.println("Content type : " +response.getContentType());

        //status line i konsolda yazdiralim
        System.out.println("Status line : " +response.getStatusLine());

        //Header i konsolda yazdiralim
        System.out.println("Header : " +response.getHeader("Server"));

        //headers i konsolda yazdiralim
        System.out.println("Headers : "+response.getHeaders());

        //time i konsolda yazdiralim
        System.out.println("Time : " +response.getTime());



    }


}
